package com.rina.controller;

import com.rina.domain.dto.UserLoginDto;
import com.rina.enums.ResultCode;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户相关的controller（含登陆接口）
 *
 * @author arvin
 * @date 2022/02/28
 */
@RestController
@RequestMapping("/private")
@RequiredArgsConstructor
@Api(tags = "用户相关接口（含登陆接口）")
public class UserController {

	private final UserService userService;

	@PostMapping("/login")
	@ApiOperation(value = "后台登陆接口", notes = "无需授权")
	public Resp login(@RequestBody(required = true) @ApiParam(value = "用户名/密码", required = true) UserLoginDto userLoginDto,
	                  final HttpServletResponse response) {
		final UsualResp<String> login = userService.login(userLoginDto.getUsername(), userLoginDto.getPassword());
		if (!login.getCode().equals(ResultCode.OK.getCode())) {
			return Resp.failed();
		}
		response.setHeader("Authorization", login.getData());
		return Resp.succeed();
	}

}
