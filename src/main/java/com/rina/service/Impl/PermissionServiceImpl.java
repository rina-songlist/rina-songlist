package com.rina.service.Impl;

import com.rina.domain.dto.PermissionDto;
import com.rina.exception.JdbcConnectFailedException;
import com.rina.mapper.PermissionMapper;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.service.PermissionService;
import com.rina.util.RespUtil;
import com.rina.util.TreeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 许可所对应的service
 *
 * @author arvin
 * @date 2022/06/13
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public class PermissionServiceImpl implements PermissionService {

	private final PermissionMapper permissionMapper;

	@Override
	public Resp listPermissions() {
		List<PermissionDto> permissionDtos;

		try {
			permissionDtos = queryPermissions2PerMissionDtos();
			return RespUtil.queryData(permissionDtos);
		} catch (JdbcConnectFailedException e) {
			log.error("数据库错误！{}", e.getLocalizedMessage());
			return Resp.serverError();
		}
	}

	@Override
	public Resp treePermissions() {
		final List<PermissionDto> permissionDtos;

		try {
			permissionDtos = queryPermissions2PerMissionDtos();
			final List<PermissionDto> treePermissions = TreeUtil.list2tree(permissionDtos,
					PermissionDto::getId,
					PermissionDto::getParentId,
					PermissionDto::getOrderValue,
					PermissionDto::getChildren,
					PermissionDto::setChildren);
			return UsualResp.succeed(treePermissions);
		} catch (JdbcConnectFailedException e) {
			log.error("数据库错误！{}", e.getLocalizedMessage());
			return Resp.serverError();
		}
	}

	private List<PermissionDto> queryPermissions2PerMissionDtos() throws JdbcConnectFailedException{
		final List<PermissionDto> permissionDtos = permissionMapper.getAllPermissions()
				.stream().map(permission -> {
					final PermissionDto dto = new PermissionDto();
					BeanUtils.copyProperties(permission, dto);
					return dto;
				})
				.collect(Collectors.collectingAndThen(Collectors.toList(), dtos -> {
					if (dtos.isEmpty()) {
						throw new JdbcConnectFailedException("数据库错误！");
					}
					return dtos;
				}));

		permissionDtos.forEach(permissionDto -> Optional.ofNullable(permissionDto.getParentId())
				.ifPresent(parentId -> permissionDto.setParentName(permissionMapper.getOnePermission(parentId).getName())));
		return permissionDtos;
	}

}
