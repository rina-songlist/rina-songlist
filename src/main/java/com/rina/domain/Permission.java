package com.rina.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * permission表所对应的实体类
 * @author arvin
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements Serializable {

    private static final long serialVersionUID = 5756114488508173304L;

    private Long id;

    private String name;

    private String remark;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}