package com.rina.mapper;

import com.rina.domain.RoleUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * user_role表所对应的mapper
 *
 * @author arvin
 */
@Mapper
public interface RoleUserMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("userId") Long userId);

    /**
     * 添加一个新的用户权限
     * @param roleUser 用户权限详情
     * @return
     */
    int insert(RoleUser roleUser);

    RoleUser selectByPrimaryKey(@Param("roleId") Long roleId, @Param("userId") Long userId);

    List<RoleUser> selectAll();

    int updateByPrimaryKey(RoleUser record);

    /**
     * 通过userID查找user（与其相关的role）的详细信息
     * @param userId
     * @return
     */
    RoleUser findRoleByUser(Long userId);

    /**
     * 用户名更新时更新表中的创建者和更新者
     * @param newEditor 新的用户名
     * @return
     */
    int updateEditorName(String newEditor);

    /**
     * 通过用户ID删除
     * @param userId 用户ID
     * @return
     */
    int deleteByUserId(Long userId);

}