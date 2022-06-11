package com.rina.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 当前登陆的用户的实体类（UserDetails的实现类）
 * @author arvin
 * @date 2022/05/30
 */
@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

	private static final long serialVersionUID = 8024413516380134439L;

	private User user;
	private Long roleId;
	private List<String> permissions;

	@JsonIgnore
	private List<SimpleGrantedAuthority> authorities;

	public LoginUser(User user, Long roleId, List<String> permissions) {
		this.user = user;
		this.roleId = roleId;
		this.permissions = permissions;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (Objects.nonNull(authorities)) {
			return authorities;
		}

		return permissions.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.getStatus();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getStatus();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getStatus();
	}

	@Override
	public boolean isEnabled() {
		return user.getStatus();
	}
}
