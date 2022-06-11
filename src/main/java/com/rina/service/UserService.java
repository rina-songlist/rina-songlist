package com.rina.service;

import com.rina.domain.dto.RoleUserDto;
import com.rina.domain.dto.UserDto;
import com.rina.resp.Resp;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * 用户管理和登陆相关的service
 *
 * @author arvin
 * @date 2022/02/28
 */
public interface UserService extends PublicService{

	/**
	 * 账号登陆的方法
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	Resp login(String username, String password);

	/**
	 * 更新token
	 * @param newUserName 新的用户名
	 * @return
	 */
	@PreAuthorize("@authChecker.authenticated()")
	Resp updateToken(String newUserName);

	/**
	 * 获取所有用户
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:user:view')")
	Resp listUsers();

	/**
	 * 获取单个用户
	 * @param userId 用户ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:user:view')")
	Resp getSingleUser(Long userId);

	/**
	 *  添加（更改）一个用户
	 *  注：添加用户时默认为访客权限
	 * @param userDto
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:user:edit')")
	Resp editUser(UserDto userDto);

	/**
	 * 更改用户权限
	 * @param roleUserDto 用户权限详情
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:role:change')")
	Resp changeRole(RoleUserDto roleUserDto);

	/**
	 * 删除一个用户
	 * @param userId 用户ID
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:user:delete')")
	Resp deleteUser(Long userId);

}
