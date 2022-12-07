package com.rina.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户的返回体
 *
 * @author arvin
 * @date 2022/03/23
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户的详细内容")
public class UserDto implements Serializable {

	private static final long serialVersionUID = 6237639195205521573L;

	/**
	 * 用户ID
	 */
	@Schema(description = "用户ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long id;

	/**
	 * 用户名
	 */
	@NotNull
	@NotBlank
	@Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "username")
	private String userName;

	/**
	 * 密码
	 */
	@Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "password")
	private String password;

	/**
	 * 用户状态
	 */
	@NotNull
	@NotBlank
	@Schema(description = "用户状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
	private Boolean status;

	/**
	 * 权限ID
	 */
	@Schema(description = "权限ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = Schema.AccessMode.READ_ONLY)
	private Long roleId;

	/**
	 * 当前用户权限名
	 */
	@Schema(description = "当前用户权限名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = Schema.AccessMode.READ_ONLY)
	private String roleName;

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
