package com.rina.mapper;

import com.rina.domain.Menu;
import com.rina.domain.RoleMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * role_menu表所对应的mapper的测试类
 *
 * @author arvin
 * @date 2022/03/15
 */
@SpringBootTest
public class RoleMenuMapperTests {

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Test
	public void testFindMenuByRole() {
		final List<RoleMenu> menuByRole = roleMenuMapper.findMenuByRole(1L);
		final Menu menuName = menuByRole.get(1).getMenu();
		System.out.println(menuName);
	}

}
