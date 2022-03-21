package com.rina.service;

import com.alibaba.fastjson.JSON;
import com.rina.domain.vo.UserDetailsVo;
import com.rina.mapper.MenuMapper;
import com.rina.mapper.RoleMenuMapper;
import com.rina.resp.Resp;
import com.rina.util.MyThreadLocal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 菜单所对应的service的测试类
 *
 * @author arvin
 * @date 2022/03/19
 */
@SpringBootTest
public class MenuServiceTests {

	@Autowired
	private MenuService menuService;

	@Autowired
	MenuMapper menuMapper;

	@Autowired
	RoleMenuMapper roleMenuMapper;

	@Test
	public void testTreeMenus() {
		MyThreadLocal.set(new UserDetailsVo("admin", 1L));
		final Resp resp = menuService.treeMenus();
		System.out.println(JSON.toJSONString(resp));
	}

}
