package com.rina.controller;

import com.rina.domain.dto.MenuDto;
import com.rina.resp.Resp;
import com.rina.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "菜单相关接口")
public class MenuController {

	private final MenuService menuService;

	@GetMapping("/menu")
	@Operation(summary = "查看菜单列表", security = {@SecurityRequirement(name = "Authorization")})
	public Resp showMenus(@RequestParam @Parameter(name = "菜单展示方式（tree/list）", in = ParameterIn.QUERY, required = true) String type) {
		if ("tree".equals(type)) {
			return menuService.treeMenus();
		} else if ("list".equals(type)) {
			return menuService.listMenus();
		}
		return Resp.notFound();
	}

	@GetMapping("/menu/{id}")
	@Operation(summary = "获取单一菜单", security = {@SecurityRequirement(name = "Authorization")})
	public Resp getSingleMenu(@PathVariable(value = "id") @Parameter(name = "查询单个菜单", in = ParameterIn.PATH, required = true) Long menuId) {
		return menuService.getSingleMenu(menuId);
	}

	@PutMapping("/menu")
	@Operation(summary = "添加/编辑单一菜单", description = "添加菜单时默认只有菜单权限", security = {@SecurityRequirement(name = "Authorization")})
	public Resp editMenu(@RequestBody @Parameter(name = "菜单详情", in = ParameterIn.DEFAULT, required = true) MenuDto menuDto) {
		return menuService.editMenu(menuDto);
	}

	@DeleteMapping("/menu/{id}")
	@Operation(summary = "删除菜单", security = {@SecurityRequirement(name = "Authorization")})
	public Resp deleteMenu(@PathVariable(value = "id") @Parameter(name = "菜单ID", in = ParameterIn.PATH, required = true) Long menuId) {
		return menuService.deleteMenu(menuId);
	}

}
