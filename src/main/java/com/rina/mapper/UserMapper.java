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

    /**
     * 通过用户名查询用户信息（主要是登陆时使用）
     * @param username
     * @return
     */
    User login(String username);

    /**
     * 获取最新的用户ID
     * @return 用户ID
     */
    Long getNewestUserId();
}