package com.rina.service.Impl;

import com.rina.domain.LoginUser;
import com.rina.domain.User;
import com.rina.mapper.RolePermissionMapper;
import com.rina.mapper.RoleUserMapper;
import com.rina.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserDetailsService的实现类
 * @author arvin
 * @date 2022/05/30
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserMapper userMapper;
	private final RoleUserMapper roleUserMapper;
	private final RolePermissionMapper rolePermissionMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userMapper.login(username);
		if (Objects.isNull(user)) {
			log.info("此用户不存在：{}",username);
			throw new UsernameNotFoundException("用户名或密码错误");
		}

		final Long roleId = roleUserMapper.findRoleByUser(user.getId()).getRoleId();
		List<String> permissions = new ArrayList<>();
		rolePermissionMapper.findPermissionsByRoleId(roleId)
				.forEach(rolePermission -> {
					permissions.add(rolePermission.getPermission().getName());
				});


		return new LoginUser(user, roleId, permissions);
	}

}
