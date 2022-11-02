package com.rina.mapper;

import com.rina.domain.MenuPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * menu_permission表所对应的mapper
 * @author arvin
 * @date 2022/10/10
 */
@Mapper
public interface MenuPermissionMapper {
    int deleteByPrimaryKey(@Param("menuId") Long menuId, @Param("permissionId") Long permissionId);

    int insert(MenuPermission record);

    MenuPermission selectByPrimaryKey(@Param("menuId") Long menuId, @Param("permissionId") Long permissionId);

    List<MenuPermission> selectAll();

    int updateByPrimaryKey(MenuPermission record);

    List<Long> findPermissionByMenu(List<Long> menuIds);
}