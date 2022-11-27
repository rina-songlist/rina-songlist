package com.rina.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * menu表所对应的实体类
 *
 * @author arvin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Menu extends AbstractDomainTable {

    private static final long serialVersionUID = 8769523180890381985L;

    private String name;

    private String icon;

    private String url;

    private Long parentId;

    private Long orderValue;

    public Menu(String createBy, Date createTime, String updateBy, Date updateTime, Long id, String name, String icon, String url, Long parentId, Long orderValue) {
        super(id, createBy, createTime, updateBy, updateTime);
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.parentId = parentId;
        this.orderValue = orderValue;
    }
}