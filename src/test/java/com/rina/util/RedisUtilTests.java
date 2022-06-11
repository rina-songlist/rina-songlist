package com.rina.util;

import com.rina.config.AppProperties;
import com.rina.domain.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * redis的工具类的测试类
 * @author arvin
 * @date 2022/06/03
 */
@SpringBootTest
public class RedisUtilTests {

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AppProperties appProperties;

	@Test
	void testBasicControl() throws InterruptedException {
		redisUtil.set("test", "test value");

		System.out.println(redisUtil.hasKey("test"));

		System.out.println(redisUtil.get("test"));

		redisUtil.del("test");
	}

	@Test
	void testUserDetailsControl() {
		// 使用AuthenticationManager进行用户验证
		final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("admin", "123456");
		final Authentication authenticate = authenticationManager.authenticate(authenticationToken);

		// 认证失败，给出相应的提示
		if (Objects.isNull(authenticate)) {
			throw new RuntimeException("登陆失败！");
		}

		// 认证成功，生成jwt
		final LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
		final String userId = loginUser.getUser().getId().toString();
		final String token = jwtUtil.createJwtToken(userId);

		// 将自定义的过期时间解析并换算为long
		long expireTime = 1L;
		final String[] strings = appProperties.getJwt().getTokenExpireTime().split("\\*");
		for (String string : strings) {
			expireTime *= Long.parseLong(string);
		}
		expireTime /= 1000;

		System.out.println(loginUser);

		// 将解析成功的用户信息存入缓存
		redisUtil.set("login:" + userId, loginUser, expireTime);

		// ----------------------------------

		final Object obj = redisUtil.get("login:1");
		LoginUser loginUser2 = (LoginUser) obj;

		assertEquals(loginUser, loginUser2, "redis反序列化失败！");
	}

}
