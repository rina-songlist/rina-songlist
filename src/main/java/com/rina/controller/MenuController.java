package com.rina.controller;

import com.rina.domain.dto.MenuDto;
import com.rina.resp.Resp;
import com.rina.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单所对应的controller
 *
 * @author arvin
 * @date 2022/03/19
 */
@RestController
@RequestMapping("/private/system")
@RequiredArgsConstructor
@Api(tags = "菜单相关接口")
public class MenuController {

	private final MenuService menuService;

	@GetMapping("/menu")
	@ApiOperation(value = "查看菜单列表", notes = "需要授权")
	public Resp showMenus(@RequestParam(required = true) @ApiParam(value = "菜单展示方式（tree/list）") String type) {
		if ("tree".equals(type)) {
			return menuService.treeMenus();
		} else if ("list".equals(type)) {
			return menuService.listMenus();
		}
		return Resp.failed();
	}

	@GetMapping("/menu/{id}")
	@ApiOperation(value = "获取单一菜单", notes = "需要授权")
	public Resp getSingleMenu(@PathVariable(value = "id", required = true) @ApiParam(value = "查询单个菜单", required = true) Long menuId) {
		return menuService.getSingleMenu(menuId);
	}

	@PutMapping("/menu")
	@ApiOperation(value = "添加/编辑单一菜单", notes = "需要授权，添加菜单时默认只有菜单权限")
	public Resp editMenu(@RequestBody(required = true) @ApiParam(value = "菜单详情", required = true) MenuDto menuDto) {
		return menuService.editMenu(menuDto);
	}

	@DeleteMapping("/menu/{id}")
	@ApiOperation(value = "删除菜单", notes = "需要授权")
	public Resp deleteMenu(@PathVariable(value = "id", required = true) @ApiParam(value = "菜单ID", required = true) Long menuId) {
		return menuService.deleteMenu(menuId);
	}

}
