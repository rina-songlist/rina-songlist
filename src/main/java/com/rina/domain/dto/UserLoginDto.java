package com.rina.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "登陆信息")
public class UserLoginDto implements Serializable {

	private static final long serialVersionUID = -2438647957404692821L;

	/**
	 * 用户名
	 */
	@NotNull
	@NotBlank
	@ApiModelProperty(value = "用户名", required = true, position = 1)
	private String username;

	/**
	 * 密码
	 */
	@NotNull
	@NotBlank
	@ApiModelProperty(value = "密码", required = true, position = 2)
	private String password;

}
