package com.rina.service.Impl;

import com.rina.domain.Menu;
import com.rina.domain.RoleMenu;
import com.rina.domain.dto.MenuDto;
import com.rina.mapper.MenuMapper;
import com.rina.mapper.RoleMenuMapper;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.service.MenuService;
import com.rina.util.MyThreadLocal;
import com.rina.util.RespUtils;
import com.rina.util.TreeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 菜单所对应的service
 *
 * @author arvin
 * @date 2022/03/15
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

	private final MenuMapper menuMapper;
	private final RoleMenuMapper roleMenuMapper;

	@Override
	public Resp treeMenus() {
		final Long roleId = Long.valueOf(MyThreadLocal.get().get("roleId"));
		log.info("当前权限ID为：{}", roleId);

		final List<MenuDto> menuDtos = queryMenus2menuDtos(roleId);

		if (menuDtos == null) {
			log.error("数据库操作错误");
			return Resp.failed();
		} else {
			List<MenuDto> treeMenus = TreeUtil.list2tree(menuDtos, MenuDto::getId, MenuDto::getParentId, MenuDto::getOrderValue, MenuDto::getChildren, MenuDto::setChildren);
			return UsualResp.succeed(treeMenus);
		}
	}

	@Override
	public Resp listMenus() {
		final List<MenuDto> menuDtos = queryMenus2menuDtos(null);

		return RespUtils.queryData(menuDtos);
	}

	@Override
	public Resp getSingleMenu(Long menuId) {
		final Menu menu = menuMapper.getOneMenu(menuId);

		if (menu == null) {
			log.info("查询数据不存在");
			return Resp.failed();
		}
		final MenuDto menuDto = MenuDto.builder()
				.id(menu.getMenuId())
				.name(menu.getMenuName())
				.icon(menu.getMenuIcon())
				.url(menu.getMenuUrl())
				.parentId(menu.getMenuParentId())
				.orderValue(menu.getMenuOrderValue())
				.createBy(menu.getCreateBy())
				.updateBy(menu.getUpdateBy())
				.build();

		return UsualResp.succeed(menuDto);
	}

	@Override
	public Resp editMenu(MenuDto menuDto) {
		final String currentUser = MyThreadLocal.get().get("userName");
		log.info("当前用户为：{}", currentUser);

		int menuResult = 0;
		int roleResult = 0;
		if (menuDto.getId() == null) {
			// 添加新的的菜单
			final Menu menu = Menu.builder()
					.menuName(menuDto.getName())
					.menuIcon(menuDto.getIcon())
					.menuUrl(menuDto.getUrl())
					.menuParentId(menuDto.getParentId() == 0 ? null : menuDto.getParentId())
					.menuOrderValue(menuDto.getOrderValue())
					.createBy(currentUser)
					.createTime(new Date())
					.updateBy(currentUser)
					.updateTime(new Date())
					.build();
			menuResult = menuMapper.insert(menu);

			// 将最新菜单加入管理员的权限组
			final Long menuId = menuMapper.getNewestMenuId();
			final RoleMenu roleMenu = RoleMenu.builder()
					.roleId(1L)
					.menuId(menuId)
					.createBy(currentUser)
					.createTime(new Date())
					.updateBy(currentUser)
					.updateTime(new Date())
					.build();
			roleResult = roleMenuMapper.insert(roleMenu);
		} else {
			// 编辑指定菜单
			Menu menu = menuMapper.findMenuById(menuDto.getId());

			// 更新前做数据可用性检查
			if (dataUsableCheck(menuDto.getName())) {
				menu = menu.withMenuName(menuDto.getName());
			}
			if (dataUsableCheck(menuDto.getIcon())) {
				menu = menu.withMenuIcon(menuDto.getIcon());
			}
			if (dataUsableCheck(menuDto.getUrl())) {
				menu = menu.withMenuUrl(menuDto.getUrl());
			}
			menu = menu.withMenuParentId(menuDto.getParentId() == 0 ? null : menuDto.getParentId());
			if (dataUsableCheck(menuDto.getOrderValue())) {
				menu = menu.withMenuOrderValue(menuDto.getOrderValue());
			}
			menu = menu.withUpdateBy(currentUser);
			menu = menu.withUpdateTime(new Date());

			menuResult = menuMapper.updateOneMenuByMenuId(menu);
			roleResult = 1;
		}

		return RespUtils.editData(menuResult, roleResult);
	}

	@Override
	public Resp deleteMenu(Long menuId) {
		final int menuResult = menuMapper.deleteOneMenu(menuId);
		final int roleResult = roleMenuMapper.deleteByMenuId(menuId);

		return RespUtils.deleteData(menuResult, roleResult);
	}

	/**
	 * 查询数据库中多个menu并转换为menuDto
	 * @param roleId 当前用户的roleID
	 * @return 处理结果
	 */
	private List<MenuDto> queryMenus2menuDtos(Long roleId) {
		if (roleId == null) {
			List<MenuDto> menuDtos =menuMapper.getAllMenus()
					.stream().map(setMenu2menuDto())
					.collect(Collectors.toList());
			menuDtos.forEach(x -> Optional.ofNullable(x.getParentId())
					.ifPresent(parentId -> x.setParentName(menuMapper.getOneMenu(parentId).getMenuName())));
			return menuDtos;
		} else {
			List<Menu> menus = roleMenuMapper.findMenuByRole(roleId)
					.stream().map(x -> Menu.builder()
							.menuId(x.getMenuId())
							.menuName(x.getMenu().getMenuName())
							.menuUrl(x.getMenu().getMenuUrl())
							.menuIcon(x.getMenu().getMenuIcon())
							.menuParentId(x.getMenu().getMenuParentId())
							.menuOrderValue(x.getMenu().getMenuOrderValue())
							.createBy(x.getMenu().getCreateBy())
							.createTime(x.getMenu().getCreateTime())
							.updateBy(x.getMenu().getUpdateBy())
							.updateTime(x.getMenu().getUpdateTime())
							.build())
					.collect(Collectors.toList());
			List<Menu> menus2 = new ArrayList<>(menus);
			menus.forEach(x -> {
				Menu menu2 = null;
				if (x.getMenuParentId() != null) {
					menu2 = menuMapper.getOneMenu(x.getMenuParentId());
				}
				if (menu2 != null && !menus.contains(menu2)) {
					menus2.add(menu2);
				}
			});
			return menus2.stream().map(setMenu2menuDto())
					.collect(Collectors.toList());
		}
	}

	/**
	 * 将Menu转换为MenuDto
	 * @return
	 */
	private Function<Menu, MenuDto> setMenu2menuDto() {
		return x -> MenuDto.builder()
				.id(x.getMenuId())
				.name(x.getMenuName())
				.icon(x.getMenuIcon())
				.url(x.getMenuUrl())
				.parentId(x.getMenuParentId())
				.orderValue(x.getMenuOrderValue())
				.createBy(x.getCreateBy())
				.updateBy(x.getUpdateBy())
				.build();
	}
}
