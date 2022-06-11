package com.rina.mapper;

import com.rina.domain.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * role_permission表所对应的mapper
 * @author arvin
 */
@Mapper
public interface RolePermissionMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int insert(RolePermission record);

    RolePermission selectByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    List<RolePermission> selectAll();

    int updateByPrimaryKey(RolePermission record);

    /**
     * 查询当前权限ID下的所有许可详情
     * @param roleId 权限ID
     * @return 许可详情
     */
    List<RolePermission> findPermissionsByRoleId(Long roleId);
}