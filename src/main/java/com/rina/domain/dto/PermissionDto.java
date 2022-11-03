package com.rina.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 许可的返回体
 * @author arvin
 * @date 2022/06/21
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "许可详细内容")
public class PermissionDto implements Serializable {

	private static final long serialVersionUID = 5014187531606454240L;

	/**
	 * 许可ID
	 */
	@ApiModelProperty(value = "许可ID", required = false, example = "1")
	private Long id;

	/**
	 * 许可权限名
	 */
	@ApiModelProperty(value = "许可权限名", required = false, example = "sys:menu:view")
	private String name;

	/**
	 * 许可权限的说明
	 */
	@ApiModelProperty(value = "许可权限的说明", required = false, example = "查看菜单")
	private String remark;

	/**
	 * 父级ID
	 */
	@ApiModelProperty(value = "父级ID", required = false, example = "1")
	private Long parentId;

	/**
	 * 父级菜单名
	 */
	@ApiModelProperty(value = "父级菜单名", required = false, example = "菜单权限")
	private String parentName;

	/**
	 * 当前层级的排序
	 */
	@ApiModelProperty(value = "当前层级的排序", required = false, example = "1")
	private Long orderValue;

	/**
	 * 禁用勾选状态
	 */
	@ApiModelProperty(value = "禁用勾选状态", required = false, example = "true")
	private Boolean disabled;

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
	 * 子权限
	 */
	@ApiModelProperty(value = "子权限", required = false, example = "tests", hidden = true)
	private List<PermissionDto> children;

}
