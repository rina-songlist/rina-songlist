package com.rina.domain;

import com.rina.domain.relation.AbstractRoleRelationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * role_user表所对应的实体类
 *
 * @author arvin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleUser extends AbstractRoleRelationType {

    private static final long serialVersionUID = 457992597942856703L;

    private Long userId;

    /**
     * 连表查询时存放role信息
     */
    private Role role;

    public RoleUser(Long roleId, String createBy, Date createTime, String updateBy, Date updateTime, Long userId, Role role) {
        super(roleId, createBy, createTime, updateBy, updateTime);
        this.userId = userId;
        this.role = role;
    }
}