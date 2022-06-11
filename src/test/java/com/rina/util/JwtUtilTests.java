package com.rina.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Jwt的工具类的测试类
 * @author arvin
 * @date 2022/06/04
 */
@SpringBootTest
public class JwtUtilTests {

	@Autowired
	private JwtUtil jwtUtil;

	@Test
	void testCreateJwtToken() throws InterruptedException {
		final String jwtToken = jwtUtil.createJwtToken("123");

		Thread.sleep(5000);

		final String subject = jwtUtil.parseJwtToken(jwtToken).getSubject();
		assertEquals("123", subject, "JWT解析失败！");
	}
}
