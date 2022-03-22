package com.rina.service.Impl;

import com.rina.domain.User;
import com.rina.domain.vo.UserDetailsVo;
import com.rina.mapper.UserMapper;
import com.rina.mapper.UserRoleMapper;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.service.UserService;
import com.rina.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * 用户管理和登陆相关的service
 *
 * @author arvin
 * @date 2022/02/28
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	private final UserRoleMapper userRoleMapper;
	private final JwtUtil jwtUtil;

	@Override
	public Resp login(String username, String password) {
		String token = null;
		try {
			final User user = userMapper.login(username);

			if (BCrypt.checkpw(password, user.getPassword())) {
				final UserDetailsVo userDetailsVo = new UserDetailsVo(
						user.getUserName(),
						userRoleMapper.findRoleByUser(user.getUserId()).getRoleId()
				);
				token = jwtUtil.createJwtToken(userDetailsVo);
			} else {
				return Resp.failed();
			}
		} catch (Exception e) {
			log.error("查询参数有误 {}", e.getLocalizedMessage());
			return Resp.failed();
		}

		return UsualResp.succeed(token);
	}
}
