package com.rina.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 抽象所有表中基础字段的抽象类
 * @author arvin
 * @date 2022/11/27
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractBasicTable implements Serializable {

	private static final long serialVersionUID = -8064302120020067823L;

	private String createBy;

	private Date createTime;

	private String updateBy;

	private Date updateTime;

}
