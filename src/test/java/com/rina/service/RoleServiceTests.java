package com.rina.service;

import com.alibaba.fastjson.JSON;
import com.rina.domain.dto.RoleDto;
import com.rina.domain.vo.UserDetailsVo;
import com.rina.resp.Resp;
import com.rina.util.MyThreadLocal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 权限管理相关的service的测试
 *
 * @author arvin
 * @date 2022/03/26
 */
@SpringBootTest
public class RoleServiceTests {

	@Autowired
	private RoleService roleService;

	@Test
	void testListRoles() {
		final Resp resp = roleService.listRoles();
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	void testGetSingleRole() {
		final Resp resp = roleService.getSingleRole(1L);
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	void testEditRoleWithInsert() {
		MyThreadLocal.set(new UserDetailsVo("test", 1L));

		final Resp resp = roleService.editRole(new RoleDto(null, "test", null, null));
		System.out.println(JSON.toJSONString(resp));

		MyThreadLocal.unset();
	}

	@Test
	void testEditRoleWithUpdate() {
		MyThreadLocal.set(new UserDetailsVo("test", 1L));

		final Resp resp = roleService.editRole(new RoleDto(3L, "test2", null, null));
		System.out.println(JSON.toJSONString(resp));

		MyThreadLocal.unset();
	}

	@Test
	void testDeleteRole() {
		final Resp resp = roleService.deleteRole(3L);
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	void testListRoleMenus() {
		final Resp resp = roleService.listRoleMenus(1L);
		System.out.println(JSON.toJSONString(resp));
	}

}
