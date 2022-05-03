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

    private Long id;

    private String name;

    private String icon;

    private String url;

    private Long parentId;

    private Long orderValue;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

}