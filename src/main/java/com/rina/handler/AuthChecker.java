package com.rina.handler;

import com.rina.domain.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * SpringSecurity
 * 自定义的权限校验
 * @author arvin
 * @date 2022/06/08
 */
@Component
public class AuthChecker {

	/**
	 * 当前用户持有任何权限
	 * @return
	 */
	public boolean authenticated() {
		final LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return loginUser.getPermissions() != null;
	}

	/**
	 * 当前用户持有所有指定权限
	 * @param authorities 指定的权限
	 * @return
	 */
	public boolean hasAuthorities(String... authorities) {
		final LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final List<String> permissions = loginUser.getPermissions();
		final List<String> auths = Arrays.asList(authorities);
		return new HashSet<>(permissions).containsAll(auths);
	}

}
