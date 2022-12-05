package com.rina.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用权限相关的请求体
 * @author arvin
 * @date 2022/03/30
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户权限信息")
public class RoleUserDto implements Serializable {

	private static final long serialVersionUID = -7465804681447964067L;

	/**
	 * 用户ID
	 */
	@NotNull
	@NotBlank
	@Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private Long userId;

	/**
	 * 权限ID
	 */
	@NotNull
	@NotBlank
	@Schema(description = "权限ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private Long roleId;

}
