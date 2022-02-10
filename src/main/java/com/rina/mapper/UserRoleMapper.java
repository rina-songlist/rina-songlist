package com.rina.mapper;

import com.rina.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * user_role表所对应的mapper
 *
 * @author arvin
 */
@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("userId") Long userId);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(@Param("roleId") Long roleId, @Param("userId") Long userId);

    List<UserRole> selectAll();

    int updateByPrimaryKey(UserRole record);
}