package com.rina.service;

import com.rina.resp.Resp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * user表所对应的mapper的测试
 *
 * @author arvin
 * @date 2022/02/28
 */
@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserService userService;

	@Test
	public void testLogin() {
		final Resp resp = userService.login("admin", "123456");
		System.out.println(resp);
	}

}
