package com.rina.service;

import com.rina.domain.dto.RoleUserDto;
import com.rina.domain.dto.UserDto;
import com.rina.resp.Resp;

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
	Resp updateToken(String newUserName);

	/**
	 * 获取所有用户
	 * @return
	 */
	Resp listUsers();

	/**
	 * 获取单个用户
	 * @param userId 用户ID
	 * @return
	 */
	Resp getSingleUser(Long userId);

	/**
	 *  添加（更改）一个用户
	 *  注：添加用户时默认为访客权限
	 * @param userDto
	 * @return
	 */
	Resp editUser(UserDto userDto);

	/**
	 * 更改用户权限
	 * @param roleUserDto 用户权限详情
	 * @return
	 */
	Resp changeRole(RoleUserDto roleUserDto);

	/**
	 * 删除一个用户
	 * @param userId 用户ID
	 * @return
	 */
	Resp deleteUser(Long userId);

}
