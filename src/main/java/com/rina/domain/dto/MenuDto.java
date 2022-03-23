package com.rina.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "菜单详细内容")
public class MenuDto implements Serializable {

	private static final long serialVersionUID = 6042211652617506636L;

	/**
	 * 菜单ID
	 */
	@ApiModelProperty(value = "菜单ID", required = false, example = "1")
	private Long id;

	/**
	 * 菜单名
	 */
	@NotNull
	@ApiModelProperty(value = "菜单ID", required = false, example = "1")
	private String name;

	/**
	 * 菜单对应图标
	 */
	@NotNull
	@ApiModelProperty(value = "菜单ID", required = false, example = "1")
	private String icon;

	/**
	 * 菜单功能对应地址
	 */
	@ApiModelProperty(value = "菜单功能对应地址", required = false, example = "url")
	private String url;

	/**
	 * 父级ID
	 */
	@ApiModelProperty(value = "父级ID", required = false, example = "1")
	private Long parentId;

	/**
	 * 当前层级的排序顺序
	 */
	@NotNull
	@ApiModelProperty(value = "当前层级的排序顺序", required = true, example = "1")
	private Long orderValue;

	/**
	 * 创建者
	 */
	@ApiModelProperty(value = "创建者", required = false, example = "test")
	private String createBy;

	/**
	 * 更新者
	 */
	@ApiModelProperty(value = "更新者", required = false, example = "test")
	private String updateBy;

	/**
	 * 子菜单
	 */
	@ApiModelProperty(value = "子菜单", required = false, example = "tests", hidden = true)
	private List<MenuDto> children;

}
