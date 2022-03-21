package com.rina.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * menu表所对应的实体类
 *
 * @author arvin
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {

    private static final long serialVersionUID = 8769523180890381985L;

    private Long menuId;

    private String menuName;

    private String menuIcon;

    private String menuUrl;

    private Long menuParentId;

    private Long menuOrderValue;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

}