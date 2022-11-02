package com.rina.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * menu_permission表所对应的实体类
 * @author arvin
 * @date 2022/10/10
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class MenuPermission implements Serializable {

    private static final long serialVersionUID = 8067507136141895301L;

    private Long menuId;

    private Long permissionId;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}