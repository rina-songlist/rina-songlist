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

    /**
     * 删除一个用户
     * @param userId 用户ID
     * @return
     */
    int deleteOneUser(Long userId);

    /**
     * 添加一个用户
     * @param user 用户详情
     * @return
     */
    int insert(User user);

    /**
     * 通过用户ID获取一个用户
     * @param userId 用户ID
     * @return
     */
    User getOneUser(Long userId);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUsers();

    /**
     * 通过用户ID更新一个用户信息
     * @param user 用户详情
     * @return
     */
    int updateOneUserByUserId(User user);

    /**
     * 通过用户名查询用户信息（主要是登陆时使用）
     * @param username 用户名
     * @return
     */
    User login(String username);

    /**
     * 获取最新的用户ID
     * @return 用户ID
     */
    Long getNewestUserId();

    /**
     * 用户名更新时更新表中的创建者和更新者
     * @param newEditor 新的用户名
     * @return
     */
    int updateEditorName(String newEditor);
}