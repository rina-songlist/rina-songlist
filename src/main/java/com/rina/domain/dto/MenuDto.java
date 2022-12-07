package com.rina.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
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
@Schema(description = "菜单详细内容")
public class MenuDto implements Serializable {

	private static final long serialVersionUID = 6042211652617506636L;

	/**
	 * 菜单ID
	 */
	@Schema(description = "菜单ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long id;

	/**
	 * 菜单名
	 */
	@NotNull
	@NotBlank
	@Schema(description = "菜单名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String name;

	/**
	 * 菜单对应图标
	 */
	@NotNull
	@NotBlank
	@Schema(description = "菜单对应图标", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String icon;

	/**
	 * 菜单功能对应地址
	 */
	@Schema(description = "菜单功能对应地址", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String url;

	/**
	 * 父级ID
	 */
	@Schema(description = "父级ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long parentId;

	/**
	 * 父级菜单名
	 */
	@Schema(description = "父级菜单名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = Schema.AccessMode.READ_ONLY)
	private String parentName;

	/**
	 * 当前层级的排序顺序
	 */
	@NotNull
	@NotBlank
	@Schema(description = "当前层级的排序顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private Long orderValue;

	/**
	 * 创建者
	 */
	@Schema(description = "创建者", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = Schema.AccessMode.READ_ONLY)
	private String createBy;

	/**
	 * 更新者
	 */
	@Schema(description = "更新者", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = Schema.AccessMode.READ_ONLY)
	private String updateBy;

	/**
	 * 子菜单
	 */
	@Schema(description = "子菜单", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = Schema.AccessMode.READ_ONLY)
	private List<MenuDto> children;

}
