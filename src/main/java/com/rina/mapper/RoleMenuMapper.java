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

    /**
     * 添加一个新菜单权限
     * @param roleMenu 菜单权限详情
     * @return
     */
    int insert(RoleMenu roleMenu);

    RoleMenu selectByPrimaryKey(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    List<RoleMenu> selectAll();

    int updateByPrimaryKey(RoleMenu record);

    /**
     * 通过权限ID查询菜单
     * @param roleId 权限ID
     * @return 菜单的集合
     */
    List<RoleMenu> findMenuByRole(Long roleId);

    /**
     * 通过菜单ID删除
     * @param menuId 菜单ID
     * @return
     */
    int deleteByMenuId(Long menuId);

    /**
     * 用户名更新时更新表中的创建者和更新者
     * @param oldEditor 旧的用户名
     * @param newEditor 新的用户名
     * @return
     */
    int updateEditorName(String oldEditor, String newEditor);
}