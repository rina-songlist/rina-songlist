package com.rina.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * menu_permission表所对应的实体类
 * @author arvin
 * @date 2022/10/10
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MenuPermission extends AbstractBasicTable {

    private static final long serialVersionUID = 8067507136141895301L;

    private Long menuId;

    private Long permissionId;

    public MenuPermission(String createBy, Date createTime, String updateBy, Date updateTime, Long menuId, Long permissionId) {
        super(createBy, createTime, updateBy, updateTime);
        this.menuId = menuId;
        this.permissionId = permissionId;
    }

}