package com.rina.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rina.domain.vo.UserDetailsVo;
import com.rina.enums.ResultCode;
import com.rina.resp.Resp;
import com.rina.util.GuavaCacheUtil;
import com.rina.util.JwtUtil;
import com.rina.util.MyThreadLocal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * 用户信息拦截器
 *
 * @author arvin
 * @date 2022/02/09
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInfoInterceptor implements HandlerInterceptor {

	private final JwtUtil jwtUtil;
	private final ObjectMapper objectMapper;
	private final GuavaCacheUtil cache;

	private UserDetailsVo userDetails = null;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		String origin  = request.getHeader(HttpHeaders.ORIGIN);
		if (origin != null) {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
			//这里设置允许的自定义header参数
			response.setHeader("Access-Control-Allow-Headers", "Authorization");
			response.setHeader("Access-Control-Max-Age", "3600");
		}

		final String token = request.getHeader("Authorization");

		final String responseBody = objectMapper.writeValueAsString(Resp.failed(ResultCode.UNAUTHORIZED));

		out:
		if (null != token && !"".equals(token) && !"undefined".equals(token)) {
			if (cache.get(token) == null) {
				if (jwtUtil.validateToken(token)) {
					// 解析出当前用户的简要信息
					jwtUtil.parseClaims(token)
							.ifPresent(claims -> {
								try {
									userDetails = objectMapper.readValue(claims.getSubject(), UserDetailsVo.class);
								} catch (JsonProcessingException e) {
									log.error("jackson反序列化出错：{}", e.getLocalizedMessage());
								}
							});
					// 把用户信息写入MDC
					cache.put(token, userDetails);
					log.info("当前用户信息已写入MDC");
				} else {
					break out;
				}
			}
			userDetails = Optional.ofNullable(userDetails).orElse(cache.get(token));
			MyThreadLocal.set(userDetails);
			return true;
		} else {
			log.error("当前用户未携带token");
		}

		response.getWriter().append(responseBody);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		MyThreadLocal.unset();
	}
}
