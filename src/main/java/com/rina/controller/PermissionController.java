package com.rina.controller;

import com.rina.resp.Resp;
import com.rina.service.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "许可相关接口")
public class PermissionController {

	private final PermissionService permissionService;

	@GetMapping("/permission")
	@Operation(summary = "查看许可列表", security = { @SecurityRequirement(name = "Authorization") })
	public Resp listPermissions() {
		return permissionService.listPermissions();
	}

}
