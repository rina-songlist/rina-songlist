package com.rina.service;

import com.rina.domain.dto.RoleDto;
import com.rina.resp.Resp;

/**
 * 权限管理相关的service
 *
 * @author arvin
 * @date 2022/03/26
 */
public interface RoleService extends PublicService{

	/**
	 * 获取所有权限列表
	 * @return
	 */
	Resp listRoles();

	/**
	 * 查询指定权限下的菜单
	 * @param roleId 权限ID
	 * @return
	 */
	Resp listRoleMenus(Long roleId);

	/**
	 * 获取一条权限信息
	 * @param roleId 权限ID
	 * @return
	 */
	Resp getSingleRole(Long roleId);

	/**
	 * 添加（更改）一条权限
	 * @param roleDto 权限ID
	 * @return
	 */
	Resp editRole(RoleDto roleDto);

	/**
	 * 更改可查看菜单
	 * @param roleId 权限ID
	 * @param newMenuIds 菜单ID
	 * @return
	 */
	Resp changeMenus(Long roleId, Long... newMenuIds);

	/**
	 * 删除一条权限
	 * @param roleId 权限ID
	 * @return
	 */
	Resp deleteRole(Long roleId);

}
