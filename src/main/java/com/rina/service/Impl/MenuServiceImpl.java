package com.rina.service.Impl;

import com.rina.domain.dto.MenuDto;
import com.rina.enums.ResultCode;
import com.rina.mapper.MenuMapper;
import com.rina.mapper.RoleMenuMapper;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.service.MenuService;
import com.rina.util.MyThreadLocal;
import com.rina.util.TreeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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
		final Long roleId = MyThreadLocal.get().getRoleId();
		log.info("当前权限ID为：{}", roleId);

		final List<MenuDto> menuDtos = queryMenus2menuDtos(roleId);

		if (menuDtos == null) {
			log.error("数据库查询错误");
			return Resp.failed();
		} else {
			List<MenuDto> treeMenus = TreeUtil.list2tree(menuDtos, MenuDto::getId, MenuDto::getParentId, MenuDto::getOrderValue, MenuDto::getChildren, MenuDto::setChildren);
			return UsualResp.succeed(ResultCode.OK, treeMenus);
		}
	}

	@Override
	public Resp listMenus() {
		final List<MenuDto> menuDtos = queryMenus2menuDtos(null);

		if (menuDtos == null) {
			log.error("数据库查询错误");
			return Resp.failed();
		} else {
			return UsualResp.succeed(ResultCode.OK, menuDtos);
		}
	}

	/**
	 * 查询数据库中多个menu并转换为menuDto
	 * @param roleId 当前用户的roleID
	 * @return 处理结果
	 */
	private List<MenuDto> queryMenus2menuDtos(Long roleId) {
		if (roleId == null) {
			return menuMapper.selectAll()
					.stream().map(x -> MenuDto.builder()
							.id(x.getMenuId())
							.name(x.getMenuName())
							.url(x.getMenuUrl())
							.parentId(x.getMenuParentId())
							.orderValue(x.getMenuOrderValue())
							.createBy(x.getCreateBy())
							.updateBy(x.getUpdateBy())
							.build()).collect(Collectors.toList());
		} else {
			return roleMenuMapper.findMenuByRole(roleId)
					.stream().map(x -> MenuDto.builder()
							.id(x.getMenuId())
							.name(x.getMenu().getMenuName())
							.icon(x.getMenu().getMenuIcon())
							.url(x.getMenu().getMenuUrl())
							.parentId(x.getMenu().getMenuParentId())
							.orderValue(x.getMenu().getMenuOrderValue())
							.createBy(x.getMenu().getCreateBy())
							.updateBy(x.getMenu().getUpdateBy())
							.build())
					.collect(Collectors.toList());
		}
	}
}
