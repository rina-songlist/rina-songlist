package com.rina.controller;

import com.rina.config.AppProperties;
import com.rina.domain.dto.RoleUserDto;
import com.rina.domain.dto.UserDto;
import com.rina.domain.dto.UserLoginDto;
import com.rina.enums.ResultCode;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "用户相关接口（含登陆接口）")
public class UserController {

	private final UserService userService;
	private final AppProperties appProperties;

	@PostMapping("/private/login")
	@ApiOperation(value = "后台登陆接口", notes = "无需授权")
	public Resp login(@RequestBody(required = true) @ApiParam(value = "用户名/密码", required = true) UserLoginDto userLoginDto,
	                  final HttpServletResponse response) {
		final Resp resp = userService.login(userLoginDto.getUsername(), userLoginDto.getPassword());
		return setResponseHead(response, resp);
	}

	@PostMapping("/private/logout")
	@ApiOperation(value = "退出登陆接口", notes = "需要授权")
	public Resp logout() {
		return userService.logout();
	}

	@GetMapping("/private/system/user/update")
	@ApiOperation(value = "token更新接口", notes = "需要授权")
	public Resp updateToken(@RequestParam(required = true) @ApiParam(value = "新用户名", required = true) String username,
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
	@ApiOperation(value = "获取所有用户", notes = "需要授权")
	public Resp listUsers() {
		return userService.listUsers();
	}

	@GetMapping("/private/system/user/{id}")
	@ApiOperation(value = "获取单个用户", notes = "需要授权")
	public Resp getSingleUser(@PathVariable(value = "id", required = true) @ApiParam(value = "用户ID", required = true) Long userId) {
		return userService.getSingleUser(userId);
	}

	@PutMapping("/private/system/user")
	@ApiOperation(value = "添加（更改）一个用户", notes = "需要授权，添加用户时默认为访客权限")
	public Resp editUser(@RequestBody(required = true) @ApiParam(value = "用户信息详情", required = true) UserDto userDto) {
		return userService.editUser(userDto);
	}

	@PostMapping("/private/system/user")
	@ApiOperation(value = "更新用户权限", notes = "需要授权")
	public Resp changeRole(@RequestBody @ApiParam(value = "用户权限详情", required = true) RoleUserDto roleUserDto) {
		return userService.changeRole(roleUserDto);
	}

	@DeleteMapping("/private/system/user/{id}")
	@ApiOperation(value = "删除一个用户", notes = "需要授权")
	public Resp deleteUser(@PathVariable(value = "id", required = true) @ApiParam(value = "用户ID", required = true) Long userId) {
		return userService.deleteUser(userId);
	}

}
