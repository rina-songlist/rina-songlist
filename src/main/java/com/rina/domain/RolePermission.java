package com.rina.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * role_permission表所对应的实体类
 * @author arvin
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 4471319874141668747L;

    private Long roleId;

    private Long permissionId;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Permission permission;
}