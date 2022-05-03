package com.rina.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * user表所对应的实体类
 *
 * @author arvin
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 8867247020450884661L;

    private Long id;

    private String userName;

    private String password;

    private Boolean status;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

}