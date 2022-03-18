package com.rina.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rina.enums.ResultCode;
import com.rina.resp.Resp;
import com.rina.util.JwtUtil;
import com.rina.util.MdcScope;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		final String token = request.getHeader("Authorization");

		final String responseBody = objectMapper.writeValueAsString(Resp.failed(ResultCode.UNAUTHORIZED));

		try (MdcScope mdcScope = new MdcScope()) {
			if (null != token) {
				if (jwtUtil.validateToken(token)) {
					// 解析出当前用户的简要信息
					final String roleId = jwtUtil.parseClaims(token)
							.map(Claims::getSubject)
							.orElse(null);
					final String userName = jwtUtil.parseClaims(token)
							.map(claims -> claims.get("authorities", String.class))
							.orElse(null);

					// 把用户信息写入MDC
					mdcScope.put("roleId", roleId);
					mdcScope.put("userName", userName);
					log.info("当前用户信息已写入MDC");
					return true;
				}
			} else {
				log.error("当前用户未携带token");
			}
		} catch (Exception e) {
			log.error("MDC注入发生错误 {}", e.getLocalizedMessage());
		}

		response.getWriter().append(responseBody);
		return false;
	}
}
