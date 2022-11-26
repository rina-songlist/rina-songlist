package com.rina.util;

import com.rina.domain.RoleMenu;
import com.rina.mapper.RoleMenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 关系表工具类的测试类
 * @author : aftermath
 * @date : 2022-11-09 14:57:22
 */
@SpringBootTest
public class RelationTableUtilsTests {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Test
    public void updateByIdTest() {
        final List<Long> newMenuIds = Arrays.asList(2L, 3L, 6L);

        List<Integer> integers = RelationTableUtils.compareAndUpdateRelationTable(2L, newMenuIds,
                roleMenuMapper::findMenuByRole,
                RoleMenu::getMenuId,
                permissionId -> RoleMenu.builder()
                        .roleId(2L)
                        .menuId(permissionId)
                        .createBy("aftermath")
                        .createTime(new Date())
                        .updateBy("aftermath")
                        .updateTime(new Date())
                        .build(),
                roleMenuMapper::insert,
                roleMenuMapper::deleteByPrimaryKey);
        System.out.println(integers);

    }

}
