package com.rina.domain.relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 抽象Role 关系表
 * 以Role 表为驱动表的所有关联表的抽象类
 * 注意：子类无法使用 {@code @With} 且需手动实现有参构造器!!!
 * @author arvin
 * @date 2022/11/18
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractRoleRelationType implements Serializable {

	private static final long serialVersionUID = -870469471184910565L;

	protected Long roleId;

	protected String createBy;

	protected Date createTime;

	protected String updateBy;

	protected Date updateTime;

}
