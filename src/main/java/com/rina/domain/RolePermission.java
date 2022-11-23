package com.rina.domain;

import com.rina.domain.relation.AbstractRoleRelationType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * role_permission表所对应的实体类
 * @author arvin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RolePermission extends AbstractRoleRelationType {

    private static final long serialVersionUID = 4471319874141668747L;

    private Long permissionId;

    private Permission permission;

    public RolePermission(Long roleId,
                          Long permissionId,
                          String createBy,
                          Date createTime,
                          String updateBy,
                          Date updateTime,
                          Permission permission) {
        super(roleId, createBy, createTime, updateBy, updateTime);
        this.permissionId = permissionId;
        this.permission = permission;
    }
}