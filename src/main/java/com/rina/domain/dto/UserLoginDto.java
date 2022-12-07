package com.rina.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户登陆时的请求体
 *
 * @author arvin
 * @date 2022/02/28
 */
@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "登陆信息")
public class UserLoginDto implements Serializable {

	private static final long serialVersionUID = -2438647957404692821L;

	/**
	 * 用户名
	 */
	@NotNull
	@NotBlank
	@Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "username")
	private String username;

	/**
	 * 密码
	 */
	@NotNull
	@NotBlank
	@Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "password")
	private String password;

}
