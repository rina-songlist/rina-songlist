package com.rina.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * role_user表所对应的实体类
 *
 * @author arvin
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class RoleUser implements Serializable {

    private static final long serialVersionUID = 457992597942856703L;

    private Long roleId;

    private Long userId;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    /**
     * 连表查询时存放role信息
     */
    private Role role;

}