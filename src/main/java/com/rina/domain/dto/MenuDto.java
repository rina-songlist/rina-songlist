package com.rina.domain.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 菜单的返回体
 *
 * @author arvin
 * @date 2022/03/15
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto implements Serializable {

	private static final long serialVersionUID = 6042211652617506636L;

	/**
	 * 菜单ID
	 */
	private Long id;

	/**
	 * 菜单名
	 */
	@NotNull
	private String name;

	/**
	 * 菜单对应图标
	 */
	@NotNull
	private String icon;

	/**
	 * 菜单功能对应地址
	 */
	private String url;

	/**
	 * 父级ID
	 */
	private Long parentId;

	/**
	 * 当前层级的排序顺序
	 */
	@NotNull
	private Long orderValue;

	/**
	 * 创建者
	 */
	private String createBy;

	/**
	 * 更新者
	 */
	private String updateBy;

	/**
	 * 子菜单
	 */
	private List<MenuDto> children;

}
