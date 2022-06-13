package com.rina.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * user表所对应的mapper的测试类
 *
 * @author arvin
 * @date 2022/02/28
 */
@SpringBootTest
public class UserMapperTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void TestLogin(){
		System.out.println(passwordEncoder.matches("123456", userMapper.login("admin").getPassword()));
	}

}
