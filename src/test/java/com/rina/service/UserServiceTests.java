package com.rina.service;

import com.alibaba.fastjson.JSON;
import com.rina.domain.dto.UserDto;
import com.rina.domain.vo.UserDetailsVo;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.util.MyThreadLocal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户管理和登陆相关的service的测试
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
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testListUsers() {
		final Resp resp = userService.listUsers();
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testGetSingleUser() {
		final Resp resp = userService.getSingleUser(1L);
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testEditUserWithInsert() {
		MyThreadLocal.set(new UserDetailsVo("test", 1L));

		final Resp resp = userService.editUser(new UserDto(null,
				"tester3",
				"123123",
				true,
				null,
				null,
				null));
		System.out.println(JSON.toJSONString(resp));

		MyThreadLocal.unset();
	}

	@Test
	public void testEditUserWithUpdate() {
		MyThreadLocal.set(new UserDetailsVo("test", 1L));

		final UsualResp<UserDto> resp = (UsualResp) userService.getSingleUser(2L);
		final UserDto userDto = resp.getData().withUserName("tester2");
		final Resp resp1 = userService.editUser(userDto);
		System.out.println(JSON.toJSONString(resp1));

		MyThreadLocal.unset();
	}

	@Test
	public void testDeleteUser() {
		final Resp resp = userService.deleteUser(3L);
		System.out.println(JSON.toJSONString(resp));
	}

}
