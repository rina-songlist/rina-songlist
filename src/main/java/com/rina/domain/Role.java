package com.rina.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * role表所对应的实体类
 *
 * @author arvin
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 8847562476138143980L;

    private Long id;

    private String role;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

}