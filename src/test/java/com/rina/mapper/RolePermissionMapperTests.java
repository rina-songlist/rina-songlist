package com.rina.mapper;

import com.alibaba.fastjson.JSON;
import com.rina.domain.RolePermission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * role_permission表所对应的mapper的测试类
 * @author arvin
 * @date 2022/06/08
 */
@SpringBootTest
public class RolePermissionMapperTests {

	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	@Test
	void testFindPermissionsByRoleId() {
		final List<RolePermission> permissionsByRoleId = rolePermissionMapper.findPermissionsByRoleId(1L);
		System.out.println(permissionsByRoleId);
		System.out.println(JSON.toJSONString(permissionsByRoleId));
	}

}
