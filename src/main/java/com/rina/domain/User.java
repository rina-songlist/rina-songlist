package com.rina.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * user表所对应的实体类
 *
 * @author arvin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractDomainTable {

    private static final long serialVersionUID = 8867247020450884661L;

    private Long id;

    private String userName;

    private String password;

    private Boolean status;

    public User(String createBy, Date createTime, String updateBy, Date updateTime, Long id, String userName, String password, Boolean status) {
        super(id, createBy, createTime, updateBy, updateTime);
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

}