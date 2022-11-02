package com.rina.controller;

import com.rina.resp.Resp;
import com.rina.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 许可所对应的controller
 * @author arvin
 * @date 2022/06/13
 */
@RestController
@RequiredArgsConstructor
public class PermissionController {

	private final PermissionService permissionService;

	@GetMapping("/permission")
	@ApiOperation(value = "查看许可列表", notes = "需要授权")
	public Resp listPermissions() {
		return permissionService.listPermissions();
	}

}
