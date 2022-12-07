package com.rina.controller;

import com.rina.domain.dto.RoleDto;
import com.rina.resp.Resp;
import com.rina.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 权限所对应的controller
 *
 * @author arvin
 * @date 2022/03/26
 */
@RestController
@RequestMapping("/private/system")
@RequiredArgsConstructor
@Tag(name = "权限相关接口")
public class RoleController {

	private final RoleService roleService;

	@GetMapping("/role")
	@Operation(summary = "查看权限列表", security = {@SecurityRequirement(name = "Authorization")})
	public Resp listRoles() {
		return roleService.listRoles();
	}

	@GetMapping("/roleMenu/{id}")
	@Operation(summary = "获取指定权限下的菜单", security = {@SecurityRequirement(name = "Authorization")})
	public Resp listRoleMenus(@PathVariable(value = "id") @Parameter(name = "权限ID", in = ParameterIn.PATH, required = true) Long roleId) {
		return roleService.listRoleMenus(roleId);
	}

	@GetMapping("/rolePermission/{id}")
	@Operation(summary = "获取指定权限下的许可", security = {@SecurityRequirement(name = "Authorization")})
	public Resp listRolePermissions(@PathVariable(value = "id") @Parameter(name = "权限ID", in = ParameterIn.PATH, required = true) Long roleId) {
		return roleService.listRolePermissions(roleId);
	}

	@GetMapping("/role/{id}")
	@Operation(summary = "获取单一权限", security = {@SecurityRequirement(name = "Authorization")})
	public Resp getSingleRole(@PathVariable(value = "id") @Parameter(name = "权限ID", in = ParameterIn.PATH, required = true) Long roleId) {
		return roleService.getSingleRole(roleId);
	}

	@PutMapping("/role")
	@Operation(summary = "添加（更改）一条权限", security = {@SecurityRequirement(name = "Authorization")})
	public Resp editRole(@RequestBody @Parameter(name = "权限详情", in = ParameterIn.DEFAULT, required = true) RoleDto roleDto) {
		return roleService.editRole(roleDto);
	}

	@PostMapping("/roleMenu/{id}")
	@Operation(summary = "更改可查看菜单", security = {@SecurityRequirement(name = "Authorization")})
	public Resp changeMenus(@PathVariable(value = "id") @Parameter(name = "权限ID", in = ParameterIn.PATH, required = true) Long roleId,
	                        @RequestBody @Parameter(name = "菜单ID", in = ParameterIn.DEFAULT, required = true) Long... menuIds) {
		return roleService.changeMenus(roleId, menuIds);
	}

	@PostMapping("/rolePermission/{id}")
	@Operation(summary = "更改可查看许可", security = {@SecurityRequirement(name = "Authorization")})
	public Resp changePermissions(@PathVariable(value = "id") @Parameter(name = "权限ID", in = ParameterIn.PATH, required = true) Long roleId,
	                              @RequestBody @Parameter(name = "许可ID", in = ParameterIn.DEFAULT, required = true) Long... permissionIds) {
		return roleService.changePermissions(roleId, permissionIds);
	}

	@DeleteMapping("/role/{id}")
	@Operation(summary = "删除一条权限", security = {@SecurityRequirement(name = "Authorization")})
	public Resp deleteRole(@PathVariable(value = "id") @Parameter(name = "权限ID", in = ParameterIn.PATH, required = true) Long roleId) {
		return roleService.deleteRole(roleId);
	}

}
