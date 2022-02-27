package com.rina.service;

import com.rina.resp.UsualResp;

/**
 * 用户管理和登陆相关的服务
 *
 * @author arvin
 * @date 2022/02/28
 */
public interface UserService {

	UsualResp<String> login(String username, String password);

}