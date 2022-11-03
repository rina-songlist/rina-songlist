package com.rina.service;

import com.alibaba.fastjson.JSON;
import com.rina.resp.Resp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

/**
 * 许可所对应的service的测试类
 * @author arvin
 * @date 2022/06/13
 */
@SpringBootTest
public class PermissionServiceTests {

	@Autowired
	private PermissionService permissionService;

	@Test
	@WithMockUser(authorities = {"sys:permission:view"})
	void testListPermissions() {
		final Resp resp = permissionService.listPermissions();
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	@WithMockUser(authorities = {"sys:permission:view"})
	void testTreePermissions() {
		final Resp resp = permissionService.treePermissions();
		System.out.println(JSON.toJSONString(resp));
	}

}
