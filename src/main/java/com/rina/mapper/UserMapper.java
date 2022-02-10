package com.rina.mapper;

import com.rina.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * user表所对应的mapper
 *
 * @author arvin
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    User selectByPrimaryKey(Long userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}