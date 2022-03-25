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
	 * 删除一条权限
	 * @param roleId 权限ID
	 * @return
	 */
	Resp deleteRole(Long roleId);

}
