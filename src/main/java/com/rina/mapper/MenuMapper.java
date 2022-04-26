package com.rina.mapper;

import com.rina.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * menu表所对应的mapper
 *
 * @author arvin
 */
@Mapper
public interface MenuMapper {

    /**
     * 删除一个菜单
     * @param menuId 菜单ID
     * @return
     */
    int deleteOneMenu(Long menuId);

    /**
     * 添加一个新菜单
     * @param menu 菜单详情
     * @return
     */
    int insert(Menu menu);

    /**
     * 通过菜单ID获取一个菜单
     * @param menuId 菜单ID
     * @return
     */
    Menu getOneMenu(Long menuId);

    /**
     * 获取所有菜单
     * @return
     */
    List<Menu> getAllMenus();

    /**
     * 通过菜单ID更新一个菜单
     * @param menu 菜单详情
     * @return
     */
    int updateOneMenuByMenuId(Menu menu);

    /**
     * 通过菜单ID查询当前菜单
     * @param menuId 菜单ID
     * @return 当前菜单
     */
    Menu findMenuById(Long menuId);

    /**
     * 获取最新添加的菜单的ID
     * @return 菜单ID
     */
    Long getNewestMenuId();

    /**
     * 用户名更新时更新表中的创建者和更新者
     * @param oldEditor 旧的用户名
     * @param newEditor 新的用户名
     * @return
     */
    int updateEditorName(String oldEditor, String newEditor);
}