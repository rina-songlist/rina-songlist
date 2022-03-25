package com.rina.controller;

import com.rina.domain.dto.RoleDto;
import com.rina.resp.Resp;
import com.rina.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "权限相关接口")
public class RoleController {

	private final RoleService roleService;

	@GetMapping("/role")
	@ApiOperation(value = "查看权限列表", notes = "需要授权")
	public Resp listRoles() {
		return roleService.listRoles();
	}

	@GetMapping("/role/{id}")
	@ApiOperation(value = "获取单一权限", notes = "需要授权")
	public Resp getSingleRole(@PathVariable(value = "id", required = true) @ApiParam(value = "权限ID", required = true) Long roleId) {
		return roleService.getSingleRole(roleId);
	}

	@PutMapping("/role")
	@ApiOperation(value = "添加（更改）一条权限", notes = "需要授权")
	public Resp editRole(@RequestBody @ApiParam(value = "权限详情", required = true) RoleDto roleDto) {
		return  roleService.editRole(roleDto);
	}

	@DeleteMapping("/role/{id}")
	@ApiOperation(value = "删除一条权限", notes = "需要授权")
	public Resp deleteRole(@PathVariable(value = "id", required = true) @ApiParam(value = "权限ID", required = true) Long roleId) {
		return roleService.deleteRole(roleId);
	}

}
