package com.rina.mapper;

import com.rina.domain.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * role_menu表所对应的mapper
 *
 * @author arvin
 */
@Mapper
public interface RoleMenuMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    int insert(RoleMenu record);

    RoleMenu selectByPrimaryKey(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    List<RoleMenu> selectAll();

    int updateByPrimaryKey(RoleMenu record);

    /**
     * 通过权限ID查询菜单
     * @param roleId 权限ID
     * @return 菜单的集合
     */
    List<RoleMenu> findMenuByRole(Long roleId);
}