package com.rina.task;

import com.rina.domain.RolePermission;
import com.rina.mapper.MenuPermissionMapper;
import com.rina.mapper.RolePermissionMapper;
import com.rina.util.ListUtil;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * permission相关的任务
 * @author arvin
 * @date 2022/09/30
 */
@Component
@AllArgsConstructor
@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public class PermissionTask {

	private final MenuPermissionMapper menuPermissionMapper;
	private final RolePermissionMapper rolePermissionMapper;

	/**
	 * 更新menu的view权限
	 * @param currentUser 当前用户
	 * @param roleId 需要更新的权限ID
	 * @param newMenuIds 更新后的菜单ID
	 * @return 任务完成状态
	 */
	// TODO 与RoleServiceImpl.changeMenus相似内容提取成工具类，并采用lambda方式调用
	@Async
	public Future<List<Integer>> updateViewPermissions(String currentUser, Long roleId, List<Long> newMenuIds) {
		final List<Long> newPermissionIds = newMenuIds.size() == 0 ?
				newMenuIds : menuPermissionMapper.findPermissionByMenu(newMenuIds);
		final List<Long> oldPermissionIds = new ArrayList<>();
		rolePermissionMapper.findPermissionsByRoleId(roleId)
				.forEach(rolePermission -> oldPermissionIds.add(rolePermission.getPermissionId()));
		List<Integer> permissionUpdateResult = null;

		// 添加许可
		List<RolePermission> rolePermissions = new ArrayList<>();
		ListUtil.compareLists(newPermissionIds, oldPermissionIds)
				.forEach(insert -> rolePermissions.add(RolePermission.builder()
								.roleId(roleId)
								.permissionId(insert)
								.createBy(currentUser)
								.createTime(new Date())
								.updateBy(currentUser)
								.updateTime(new Date())
						.build()));
		final List<Integer> permissionInserted = rolePermissions.stream().map(rolePermissionMapper::insert)
				.distinct()
				.map(x -> {
					if (x.equals(0)) {
						x = 1;
					}
					return x;
				})
				.collect(Collectors.toList());

		// 删除许可
		final List<Integer> permissionDeleted = ListUtil.compareLists(oldPermissionIds, newPermissionIds)
				.stream().map(x -> rolePermissionMapper.deleteByPrimaryKey(roleId, x))
				.distinct()
				.map(x -> {
					if (x.equals(0)) {
						x = 1;
					}
					return x;
				})
				.collect(Collectors.toList());

		permissionUpdateResult = permissionInserted;
		permissionUpdateResult.addAll(permissionDeleted);

		// TODO 后续需改为事物处理
		return new AsyncResult<>(permissionUpdateResult);
	}

	@Async
	public Future<List<Long>> testTransactional() {
		int insert = rolePermissionMapper.insert(RolePermission.builder()
				.roleId(2L)
				.permissionId(24L)
				.createBy("aftermath")
				.createTime(new Date())
				.updateBy("aftermath")
				.updateTime(new Date())
				.build());
		System.out.println("子线程添加是否成功: " + (insert>0));
		System.out.println("子线程读: " + rolePermissionMapper.findPermissionsByRoleId(2L).stream()
				.map(RolePermission::getPermissionId)
				.collect(Collectors.toList()));
		System.out.println(1/0);
		return new AsyncResult<>(rolePermissionMapper.findPermissionsByRoleId(2L).stream().map(RolePermission::getPermissionId).collect(Collectors.toList()));
	}
}
