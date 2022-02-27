package com.rina.mapper;

import com.rina.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * role表所对应的mapper
 *
 * @author arvin
 */
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    Role selectByPrimaryKey(Long roleId);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    /**
     * 通过roleID查看完整role信息
     * @param roleId
     * @return
     */
    Role findRoleNameById(Long roleId);
}