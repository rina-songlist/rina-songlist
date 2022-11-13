package com.rina.service;

import com.rina.domain.dto.RoleDto;
import com.rina.resp.Resp;
import org.springframework.security.access.prepost.PreAuthorize;

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
	@PreAuthorize("hasAuthority('sys:role:view')")
	Resp listRoles();

	/**
	 * 查询指定权限下的菜单
	 * @param roleId 权限ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:role:changeMenu')")
	Resp listRoleMenus(Long roleId);

	/**
	 * 查询指定权限下的许可
	 * @param roleId 权限ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:role:changePermission')")
	Resp listRolePermissions(Long roleId);

	/**
	 * 获取一条权限信息
	 * @param roleId 权限ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:role:view')")
	Resp getSingleRole(Long roleId);

	/**
	 * 添加（更改）一条权限
	 * @param roleDto 权限ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:role:edit')")
	Resp editRole(RoleDto roleDto);

	/**
	 * 更改可查看菜单
	 * @param roleId 权限ID
	 * @param newMenuIds 菜单ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:role:changeMenu')")
	Resp changeMenus(Long roleId, Long... newMenuIds);

	//TODO 改许可
	/**
	 * 更改可查看许可
	 * @param roleId 权限ID
	 * @param permissionIds 菜单ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:role:changePermission')")
	Resp changePermissions(Long roleId, Long... permissionIds);

	/**
	 * 删除一条权限
	 * @param roleId 权限ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:role:delete')")
	Resp deleteRole(Long roleId);

}
