package com.rina.mapper;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * user表所对应的mapper的测试
 *
 * @author arvin
 * @date 2022/02/28
 */
@SpringBootTest
public class UserMapperTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void TestLogin(){
//		final String hashed = BCrypt.hashpw("12345", BCrypt.gensalt());
//		System.out.println(hashed);
		System.out.println(BCrypt.checkpw("123456", userMapper.login("admin").getPassword()));
	}

}
