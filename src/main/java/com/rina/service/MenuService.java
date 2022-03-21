package com.rina.service;

import com.rina.resp.Resp;

/**
 * 菜单所对应的service
 *
 * @author arvin
 * @date 2022/03/15
 */
public interface MenuService {

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

}
