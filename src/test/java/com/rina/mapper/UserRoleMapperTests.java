package com.rina.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * user_role表所对应的mapper的测试
 *
 * @author arvin
 * @date 2022/02/28
 */
@SpringBootTest
public class UserRoleMapperTests {

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Test
	public void TestFindRoleByUser(){
		System.out.println(userRoleMapper.findRoleByUser(1L));
	}

}
