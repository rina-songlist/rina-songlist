package com.rina.service;

import com.alibaba.fastjson.JSON;
import com.rina.domain.dto.MenuDto;
import com.rina.domain.vo.UserDetailsVo;
import com.rina.mapper.MenuMapper;
import com.rina.mapper.RoleMenuMapper;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
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

		MyThreadLocal.unset();
	}

	@Test
	public void testGetSingleMenu() {
		final Resp resp = menuService.getSingleMenu(2L);
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testEditMenuWithInsert() {
		MyThreadLocal.set(new UserDetailsVo("test", 1L));

		final Resp resp = menuService.editMenu(new MenuDto(null,
				"test",
				"icon",
				"url",
				1L,
				4L,
				null,
				null,
				null));
		System.out.println(JSON.toJSONString(resp));

		MyThreadLocal.unset();
	}

	@Test
	public void testEditMenuWithUpdate() {
		MyThreadLocal.set(new UserDetailsVo("test2", 1L));

		final UsualResp resp = (UsualResp) menuService.getSingleMenu(7L);
		final MenuDto menu = (MenuDto) resp.getData();
		menu.setName("test2");

		final Resp resp1 = menuService.editMenu(menu);
		System.out.println(JSON.toJSONString(resp1));

		MyThreadLocal.unset();
	}

	@Test
	public void testDeleteMenu() {
		final Resp resp = menuService.deleteMenu(9L);
		System.out.println(JSON.toJSONString(resp));
	}
}
