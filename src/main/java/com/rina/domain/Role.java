package com.rina.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * role表所对应的实体类
 *
 * @author arvin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends AbstractDomainTable {

    private static final long serialVersionUID = 8847562476138143980L;

    private String role;

    public Role(String createBy, Date createTime, String updateBy, Date updateTime, Long id, String role) {
        super(id, createBy, createTime, updateBy, updateTime);
        this.role = role;
    }

}