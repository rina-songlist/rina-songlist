package com.rina.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * permission表所对应的实体类
 * @author arvin
 * @date 2022/10/10
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Permission extends AbstractDomainTable {

    private static final long serialVersionUID = 5756114488508173304L;

    private String name;

    private String remark;

    private Long parentId;

    private Long orderValue;

    private Boolean deepest;

    private Boolean disabled;

    private Long mainPermissionId;

    public Permission(String createBy, Date createTime, String updateBy, Date updateTime, Long id, String name, String remark, Long parentId, Long orderValue, Boolean deepest, Boolean disabled, Long mainPermissionId) {
        super(id, createBy, createTime, updateBy, updateTime);
        this.name = name;
        this.remark = remark;
        this.parentId = parentId;
        this.orderValue = orderValue;
        this.deepest = deepest;
        this.disabled = disabled;
        this.mainPermissionId = mainPermissionId;
    }

}