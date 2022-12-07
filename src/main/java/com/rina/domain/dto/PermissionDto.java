package com.rina.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "许可详细内容")
public class PermissionDto implements Serializable {

	private static final long serialVersionUID = 5014187531606454240L;

	/**
	 * 许可ID
	 */
	@Schema(description = "许可ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long id;

	/**
	 * 许可权限名
	 */
	@Schema(description = "许可权限名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String name;

	/**
	 * 许可权限的说明
	 */
	@Schema(description = "许可权限的说明", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String remark;

	/**
	 * 父级ID
	 */
	@Schema(description = "父级ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long parentId;

	/**
	 * 父级菜单名
	 */
	@Schema(description = "父级菜单名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String parentName;

	/**
	 * 当前层级的排序
	 */
	@Schema(description = "当前层级的排序", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long orderValue;

	/**
	 * 禁用勾选状态
	 */
	@Schema(description = "禁用勾选状态", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Boolean disabled;

	/**
	 * 创建者
	 */
	@Schema(description = "创建者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String createBy;

	/**
	 * 更新者
	 */
	@Schema(description = "更新者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String updateBy;

	/**
	 * 子权限
	 */
	@Schema(description = "子权限", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = Schema.AccessMode.READ_ONLY)
	private List<PermissionDto> children;

}
