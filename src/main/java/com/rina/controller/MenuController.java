package com.rina.controller;

import com.rina.resp.Resp;
import com.rina.service.MenuService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单所对应的controller
 *
 * @author arvin
 * @date 2022/03/19
 */
@RestController
@RequestMapping("/private/system")
@RequiredArgsConstructor
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

}
