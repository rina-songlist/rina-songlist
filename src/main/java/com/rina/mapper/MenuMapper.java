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
    int deleteByPrimaryKey(Long menuId);

    int insert(Menu record);

    Menu selectByPrimaryKey(Long menuId);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);

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
}