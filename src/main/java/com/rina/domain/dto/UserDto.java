package com.rina.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "用户的详细内容")
public class UserDto implements Serializable {

	private static final long serialVersionUID = 6237639195205521573L;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID", required = false, example = "1")
	private Long id;

	/**
	 * 用户名
	 */
	@NotNull
	@NotBlank
	@ApiModelProperty(value = "用户名", required = true, example = "test")
	private String userName;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码", required = false, example = "test")
	private String password;

	/**
	 * 用户状态
	 */
	@NotNull
	@NotBlank
	@ApiModelProperty(value = "用户状态", required = true, example = "true")
	private Boolean status;

	/**
	 * 当前用户权限名
	 */
	@ApiModelProperty(value = "当前用户权限名", required = true, example = "test")
	private String roleName;

	/**
	 * 创建者
	 */
	@ApiModelProperty(value = "菜单ID", required = false, example = "test")
	private String createBy;

	/**
	 * 更新者
	 */
	@ApiModelProperty(value = "菜单ID", required = false, example = "test")
	private String updateBy;

}
