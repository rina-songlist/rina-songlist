package com.rina.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * 抽象所有实体表中基础字段的抽象类
 * @author arvin
 * @date 2022/11/27
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractDomainTable extends AbstractBasicTable{

	private static final long serialVersionUID = 6468572880717227289L;

	private Long id;

	protected AbstractDomainTable(Long id, String createBy, Date createTime, String updateBy, Date updateTime) {
		super(createBy, createTime, updateBy, updateTime);
		this.id = id;
	}
}
