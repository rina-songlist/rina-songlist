package com.rina.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * role_menu表所对应的实体类
 *
 * @author arvin
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1216966007014837211L;

    private Long roleId;

    private Long menuId;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Menu menu;

}