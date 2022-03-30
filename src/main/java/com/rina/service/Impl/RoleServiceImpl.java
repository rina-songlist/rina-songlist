package com.rina.service.Impl;

import com.rina.domain.Role;
import com.rina.domain.RoleMenu;
import com.rina.domain.dto.RoleDto;
import com.rina.enums.ResultCode;
import com.rina.mapper.RoleMapper;
import com.rina.mapper.RoleMenuMapper;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.service.RoleService;
import com.rina.util.ListUtil;
import com.rina.util.MyThreadLocal;
import com.rina.util.RespUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限管理相关的service
 *
 * @author arvin
 * @date 2022/03/26
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

	private final RoleMapper roleMapper;
	private final RoleMenuMapper roleMenuMapper;

	@Override
	public Resp listRoles() {
		final List<RoleDto> roleDtos = roleMapper.selectAll().stream()
				.map(x -> RoleDto.builder()
						.id(x.getRoleId())
						.role(x.getRoleName())
						.createBy(x.getCreateBy())
						.updateBy(x.getUpdateBy())
						.build())
				.collect(Collectors.toList());
		return RespUtils.queryData(roleDtos);
	}

	@Override
	public Resp listRoleMenus(Long roleId) {
		List<Long> menuIdList = new ArrayList<>();
		roleMenuMapper.findMenuByRole(roleId)
				.forEach(x -> menuIdList.add(x.getMenuId()));
		final Long[] menuIds = menuIdList.toArray(new Long[menuIdList.size()]);

		return RespUtils.queryData(menuIds);
	}

	@Override
	public Resp getSingleRole(Long roleId) {
		final Role role = roleMapper.selectByPrimaryKey(roleId);

		if (role == null) {
			log.error("查询数据不存在");
			return Resp.failed();
		}

		final RoleDto roleDto = RoleDto.builder()
				.id(roleId)
				.role(role.getRoleName())
				.createBy(role.getCreateBy())
				.updateBy(role.getUpdateBy())
				.build();

		return UsualResp.succeed(roleDto);
	}

	@Override
	public Resp editRole(RoleDto roleDto) {
		final String currentUser = MyThreadLocal.get().getUserName();
		log.info("当前用户为：{}", currentUser);

		int roleResult = 0;
		if (roleDto.getId() == null) {
			// 添加一条新权限
			final Role role = Role.builder()
					.roleName(roleDto.getRole())
					.createBy(currentUser)
					.createTime(new Date())
					.updateBy(currentUser)
					.updateTime(new Date())
					.build();
			roleResult = roleMapper.insert(role);
		} else {
			// 编辑权限
			Role role = roleMapper.selectByPrimaryKey(roleDto.getId());

			if (dataUsableCheck(roleDto.getRole())) {
				role = role.withRoleName(roleDto.getRole());
			}
			role = role.withUpdateBy(currentUser);
			role = role.withUpdateTime(new Date());

			roleResult = roleMapper.updateByPrimaryKey(role);
		}

		return RespUtils.editData(roleResult);
	}

	@Override
	public Resp changeMenus(Long roleId, Long... menuIds) {
		final String currentUser = MyThreadLocal.get().getUserName();

		final List<Long> newMenuIds = Arrays.asList(menuIds);
		List<Long> oldMenuIds = new ArrayList<>();
		roleMenuMapper.findMenuByRole(roleId)
				.forEach(x -> oldMenuIds.add(x.getMenuId()));

		// 添加菜单
		final List<Long> insertMenus = ListUtil.compareLists(newMenuIds, oldMenuIds);
		List<RoleMenu> roleMenus = new ArrayList<>();
		insertMenus.forEach(x -> roleMenus.add(RoleMenu.builder()
				.roleId(roleId)
				.menuId(x)
				.createBy(currentUser)
				.createTime(new Date())
				.updateBy(currentUser)
				.updateTime(new Date())
				.build()));
		roleMenus.forEach(roleMenuMapper::insert);

		// 删除菜单
		final List<Long> deleteMenus = ListUtil.compareLists(oldMenuIds, newMenuIds);
		deleteMenus.forEach(x -> roleMenuMapper.deleteByPrimaryKey(roleId, x));

		return Resp.succeed(ResultCode.CREATED);
	}

	@Override
	public Resp deleteRole(Long roleId) {
		final int roleResult = roleMapper.deleteByPrimaryKey(roleId);

		return RespUtils.deleteData(roleResult);
	}

}
