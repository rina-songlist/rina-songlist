package com.rina.mapper;

import com.rina.domain.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * permission表所对应的mapper
 * @author arvin
 * @date 2022/10/10
 */
@Mapper
public interface PermissionMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(Permission record);

    /**
     * 通过ID查找许可详情
     * @param permissionId 许可ID
     * @return 许可详情
     */
    Permission getOnePermission(Long permissionId);

    /**
     * 获取所有许可
     * @return
     */
    List<Permission> getAllPermissions();

    int updateByPrimaryKey(Permission record);
}