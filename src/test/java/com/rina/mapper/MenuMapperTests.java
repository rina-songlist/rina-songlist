package com.rina.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * menu表所对应的mapper的测试类
 *
 * @author arvin
 * @date 2022/03/22
 */
@SpringBootTest
public class MenuMapperTests {

	@Autowired
	private MenuMapper menuMapper;

	@Test
	public void testGetNewestMenuId() {
		final Long menuId = menuMapper.getNewestMenuId();
		System.out.println(menuId);
	}

}
