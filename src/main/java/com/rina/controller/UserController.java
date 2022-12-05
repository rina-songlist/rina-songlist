package com.rina.controller;

import com.rina.config.AppProperties;
import com.rina.domain.dto.RoleUserDto;
import com.rina.domain.dto.UserDto;
import com.rina.domain.dto.UserLoginDto;
import com.rina.enums.ResultCode;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户相关的controller（含登陆接口）
 *
 * @author arvin
 * @date 2022/02/28
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "用户相关接口（含登陆接口）")
public class UserController {

	private final UserService userService;
	private final AppProperties appProperties;

	@PostMapping("/private/login")
	@Operation(summary = "后台登陆接口")
	public Resp login(@RequestBody @Parameter(name = "用户名/密码", in = ParameterIn.DEFAULT, required = true) UserLoginDto userLoginDto,
	                  final HttpServletResponse response) {
		final Resp resp = userService.login(userLoginDto.getUsername(), userLoginDto.getPassword());
		return setResponseHead(response, resp);
	}

	@PostMapping("/private/logout")
	@Operation(summary = "退出登陆接口", security = {@SecurityRequirement(name = "Authorization")})
	public Resp logout() {
		return userService.logout();
	}

	@GetMapping("/private/system/user/update")
	@Operation(summary = "token更新接口", security = {@SecurityRequirement(name = "Authorization")})
	public Resp updateToken(@RequestParam @Parameter(name = "用户名", in = ParameterIn.QUERY, required = true) String username,
	                        final HttpServletResponse response) {
		final Resp resp = userService.updateToken(username);
		return setResponseHead(response, resp);
	}

	private Resp setResponseHead(HttpServletResponse response, Resp resp) {
		UsualResp<String> completeLoginData = new UsualResp<>();
		if (!resp.getCode().equals(ResultCode.OK.getCode())) {
			return Resp.notFound();
		}
		if (resp instanceof UsualResp) {
			BeanUtils.copyProperties(resp, completeLoginData);
		} else {
			return Resp.notFound();
		}
		response.setHeader(appProperties.getJwt().getHeader(), completeLoginData.getData());
		return Resp.succeed();
	}

	@GetMapping("/private/system/user")
	@Operation(summary = "获取所有用户", security = {@SecurityRequirement(name = "Authorization")})
	public Resp listUsers() {
		return userService.listUsers();
	}

	@GetMapping("/private/system/user/{id}")
	@Operation(summary = "获取单个用户", security = {@SecurityRequirement(name = "Authorization")})
	public Resp getSingleUser(@PathVariable(value = "id") @Parameter(name = "用户ID", in = ParameterIn.PATH, required = true) Long userId) {
		return userService.getSingleUser(userId);
	}

	@PutMapping("/private/system/user")
	@Operation(summary = "添加（更改）一个用户", description = "添加用户时默认为访客权限", security = {@SecurityRequirement(name = "Authorization")})
	public Resp editUser(@RequestBody @Parameter(name = "用户信息详情", in = ParameterIn.DEFAULT, required = true) UserDto userDto) {
		return userService.editUser(userDto);
	}

	@PostMapping("/private/system/user")
	@Operation(summary = "更新用户权限", security = {@SecurityRequirement(name = "Authorization")})
	public Resp changeRole(@RequestBody @Parameter(name = "用户权限详情", in = ParameterIn.DEFAULT, required = true) RoleUserDto roleUserDto) {
		return userService.changeRole(roleUserDto);
	}

	@DeleteMapping("/private/system/user/{id}")
	@Operation(summary = "删除一个用户", security = {@SecurityRequirement(name = "Authorization")})
	public Resp deleteUser(@PathVariable(value = "id") @Parameter(name = "用户ID", in = ParameterIn.PATH, required = true) Long userId) {
		return userService.deleteUser(userId);
	}

}
