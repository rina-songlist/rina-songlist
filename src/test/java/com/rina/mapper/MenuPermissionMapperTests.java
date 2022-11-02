package com.rina.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * menu_permission表所对应的mapper的测试类
 * @author arvin
 * @date 2022/07/03
 */
@SpringBootTest
public class MenuPermissionMapperTests {

	@Autowired
	private MenuPermissionMapper menuPermissionMapper;

	@Test
	void testFindPermissionByMenu() {
		final List<Long> menus = Arrays.asList(4L, 5L, 6L);
		final List<Long> permissions = menuPermissionMapper.findPermissionByMenu(menus);
		System.out.println(permissions);
	}

}
