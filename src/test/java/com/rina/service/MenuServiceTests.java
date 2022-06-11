package com.rina.service;

import com.alibaba.fastjson.JSON;
import com.rina.domain.dto.MenuDto;
import com.rina.mapper.MenuMapper;
import com.rina.mapper.RoleMenuMapper;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;

/**
 * 菜单所对应的service的测试类
 *
 * @author arvin
 * @date 2022/03/19
 */
@SpringBootTest
@WithUserDetails(value = "admin", userDetailsServiceBeanName = "userDetailsServiceImpl")
public class MenuServiceTests {

	@Autowired
	private MenuService menuService;

	@Autowired
	MenuMapper menuMapper;

	@Autowired
	RoleMenuMapper roleMenuMapper;

	@Test
	public void testTreeMenus() {
		final Resp resp = menuService.treeMenus();
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testGetSingleMenu() {
		final Resp resp = menuService.getSingleMenu(2L);
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testEditMenuWithInsert() {
		final Resp resp = menuService.editMenu(new MenuDto(null,
				"test",
				"icon",
				"url",
				1L,
				null,
				4L,
				null,
				null,
				null));
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testEditMenuWithUpdate() {
		final UsualResp resp = (UsualResp) menuService.getSingleMenu(7L);
		final MenuDto menu = (MenuDto) resp.getData();
		menu.setName("test2");

		final Resp resp1 = menuService.editMenu(menu);
		System.out.println(JSON.toJSONString(resp1));
	}

	@Test
	public void testDeleteMenu() {
		final Resp resp = menuService.deleteMenu(9L);
		System.out.println(JSON.toJSONString(resp));
	}
}
