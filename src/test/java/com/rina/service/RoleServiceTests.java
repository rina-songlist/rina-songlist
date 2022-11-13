package com.rina.service;

import com.alibaba.fastjson.JSON;
import com.rina.domain.RolePermission;
import com.rina.domain.dto.RoleDto;
import com.rina.mapper.RolePermissionMapper;
import com.rina.resp.Resp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;

import java.util.stream.Collectors;

/**
 * 权限管理相关的service的测试
 *
 * @author arvin
 * @date 2022/03/26
 */
@SpringBootTest
@WithUserDetails(value = "admin", userDetailsServiceBeanName = "userDetailsServiceImpl")
public class RoleServiceTests {

	@Autowired
	private RoleService roleService;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	@Test
	void testTransactional() {
		try {
			roleService.testTransactional();
		} catch (Exception e) {
			System.out.println("发生错误: "+e.getMessage());
		}
		System.out.println("读已提交: " + rolePermissionMapper.findPermissionsByRoleId(2L).stream()
				.map(RolePermission::getPermissionId)
				.collect(Collectors.toList()));
	}

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
		final Resp resp = roleService.editRole(new RoleDto(null, "test", null, null));
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	void testEditRoleWithUpdate() {
		final Resp resp = roleService.editRole(new RoleDto(3L, "test2", null, null));
		System.out.println(JSON.toJSONString(resp));
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

	@Test
	void testListRolePermissions() {
		final Resp resp = roleService.listRolePermissions(1L);
		System.out.println(JSON.toJSONString(resp));
	}

}
