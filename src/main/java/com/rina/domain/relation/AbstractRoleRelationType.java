package com.rina.domain.relation;

import com.rina.domain.AbstractBasicTable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractRoleRelationType extends AbstractBasicTable {

	private static final long serialVersionUID = -870469471184910565L;

	private Long roleId;

	protected AbstractRoleRelationType(Long roleId, String createBy, Date createTime, String updateBy, Date updateTime) {
		super(createBy, createTime, updateBy, updateTime);
		this.roleId = roleId;
	}
}
