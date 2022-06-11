package com.rina.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rina.config.AppProperties;
import com.rina.domain.LoginUser;
import com.rina.exception.GuavaCacheDataNotExistException;
import com.rina.exception.JwtParseException;
import com.rina.exception.LoginException;
import com.rina.resp.Resp;
import com.rina.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * jwt鉴权过滤器
 * @author arvin
 * @date 2022/06/04
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private final AppProperties appProperties;
	private final JwtUtil jwtUtil;
	private final RedisUtil redisUtil;
	private final GuavaCacheUtil guavaCacheUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		// 获取token
		final String token = request.getHeader("Authorization");
		if (!StringUtils.hasText(token) && !Constants.FRONTEND_NULL_STRING.equals(token)) {
			filterChain.doFilter(request, response);
			return;
		}

		// 解析token
		String userId = null;
		try {
			userId = jwtUtil.parseJwtToken(token).getSubject();
		} catch (Exception e) {
			log.info("当前token：{}已过期或非法！", token);
			throw new JwtParseException("当前token已过期或非法！", e.getCause());
		}

		// 从缓存中获取用户信息
		LoginUser loginUser = null;
		try {
			if (Constants.CACHE_REDIS.equals(appProperties.getJwt().getCacheType())) {
				try {
					if (redisUtil.hasKey(Constants.LOGIN_CACHE_PREFIX + userId)) {
						loginUser = (LoginUser) redisUtil.get(Constants.LOGIN_CACHE_PREFIX + userId);
					}
				} catch (Exception e) {
					log.error("redis连接失败！：{}", e.getLocalizedMessage());
					appProperties.getJwt().setCacheType("guava");
					loginUser = guavaCacheUtil.get(Constants.LOGIN_CACHE_PREFIX + userId);
				}
			} else {
				loginUser = guavaCacheUtil.get(Constants.LOGIN_CACHE_PREFIX + userId);
			}
		} catch (JsonProcessingException e) {
			log.error("JSON反序列化错误：{}", e.getLocalizedMessage());
			WebUtil.myResponse(response, Resp.serverError());
			return;
		} catch (GuavaCacheDataNotExistException e) {
			throw new LoginException("用户未登陆！");
		}
		if (Objects.isNull(loginUser)) {
			throw new LoginException("用户未登陆！");
		}

		// 存入SecurityContextHolder
		final UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);

		// 放行
		filterChain.doFilter(request, response);
	}
}
