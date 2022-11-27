package com.rina.task;

import com.rina.domain.RolePermission;
import com.rina.mapper.MenuPermissionMapper;
import com.rina.mapper.RolePermissionMapper;
import com.rina.util.RelationTableUtils;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

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
	@Async
	public Future<List<Integer>> updateViewPermissions(String currentUser, Long roleId, List<Long> newMenuIds) {
		final List<Long> newPermissionIds = newMenuIds.size() == 0 ?
				newMenuIds : menuPermissionMapper.findPermissionByMenu(newMenuIds);
		List<Integer> permissionUpdateResult = RelationTableUtils.compareAndUpdateRelationTable(roleId, newPermissionIds,
														rolePermissionMapper::findPermissionsByRoleId,
														RolePermission::getPermissionId,
														permissionId -> RolePermission.builder()
																.roleId(roleId)
																.permissionId(permissionId)
																.createBy(currentUser)
																.createTime(new Date())
																.updateBy(currentUser)
																.updateTime(new Date())
																.build(),
														rolePermissionMapper::insert,
														rolePermissionMapper::deleteByPrimaryKey);

		return new AsyncResult<>(permissionUpdateResult);
	}

}
