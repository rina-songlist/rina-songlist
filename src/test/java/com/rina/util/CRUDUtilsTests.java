package com.rina.util;

import com.rina.domain.RoleMenu;
import com.rina.mapper.RoleMenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author : aftermath
 * @date : 2022-11-09 14:57:22
 */
@SpringBootTest
public class CRUDUtilsTests {
    @Resource
    CRUDUtils crudUtils;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Test
    public void updateByIdTest() {
        final List<Long> newMenuIds = Arrays.asList(2L, 3L, 5L);

        List<Integer> integers = crudUtils.updateById(2L, newMenuIds,
                roleMenuMapper::findMenuByRole,
                RoleMenu::getMenuId,
                t -> RoleMenu.builder().roleId(2L).menuId(t)
                        .createBy("aftermath").createTime(new Date()).updateBy("aftermath").updateTime(new Date()).build(),
                roleMenuMapper::insert,
                roleMenuMapper::deleteByPrimaryKey);
        System.out.println(integers);

    }

}
