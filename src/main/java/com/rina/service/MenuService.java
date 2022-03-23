package com.rina.service;

import com.rina.domain.dto.MenuDto;
import com.rina.resp.Resp;

/**
 * 菜单所对应的service
 *
 * @author arvin
 * @date 2022/03/15
 */
public interface MenuService extends PublicService{

	/**
	 * 树形查询菜单
	 * @return
	 */
	Resp treeMenus();

	/**
	 * 列表查询菜单
	 * @return
	 */
	Resp listMenus();

	/**
	 * 查询单个菜单
	 * @param menuId 菜单ID
	 * @return
	 */
	Resp getSingleMenu(Long menuId);

	/**
	 * 添加(更改)一个新的菜单
	 * @param menuDto 菜单内容
	 * @return
	 */
	Resp editMenu(MenuDto menuDto);

	/**
	 * 删除一个菜单
	 * @param menuId 菜单ID
	 * @return
	 */
	Resp deleteMenu(Long menuId);

}
