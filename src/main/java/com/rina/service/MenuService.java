package com.rina.service;

import com.rina.domain.dto.MenuDto;
import com.rina.resp.Resp;
import org.springframework.security.access.prepost.PreAuthorize;

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
	@PreAuthorize("@authChecker.hasAnyAuthority()")
	Resp treeMenus();

	/**
	 * 列表查询菜单
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:menu:view')")
	Resp listMenus();

	/**
	 * 查询单个菜单
	 * @param menuId 菜单ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:menu:view')")
	Resp getSingleMenu(Long menuId);

	/**
	 * 添加(更改)一个的菜单
	 * 注：添加菜单时默认只有菜单权限
	 * @param menuDto 菜单内容
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:menu:edit')")
	Resp editMenu(MenuDto menuDto);

	/**
	 * 删除一个菜单
	 * @param menuId 菜单ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:menu:delete')")
	Resp deleteMenu(Long menuId);

}
