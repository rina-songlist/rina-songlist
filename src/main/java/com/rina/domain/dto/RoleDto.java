package com.rina.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 权限的返回体
 *
 * @author arvin
 * @date 2022/03/26
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "权限详情内容")
public class RoleDto implements Serializable {

	private static final long serialVersionUID = 2338060146121957031L;

	/**
	 * 权限ID
	 */
	@Schema(description = "权限ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long id;

	/**
	 * 权限名
	 */
	@NotNull
	@NotBlank
	@Schema(description = "权限名", requiredMode = Schema.RequiredMode.REQUIRED, example = "role name")
	private String role;

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

}
