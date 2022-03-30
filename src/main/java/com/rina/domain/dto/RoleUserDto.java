package com.rina.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "用户权限信息")
public class RoleUserDto implements Serializable {

	private static final long serialVersionUID = -7465804681447964067L;

	/**
	 * 用户ID
	 */
	@NotNull
	@NotBlank
	@ApiModelProperty(value = "用户ID", required = true, example = "1")
	private Long userId;

	/**
	 * 权限ID
	 */
	@NotNull
	@NotBlank
	@ApiModelProperty(value = "权限ID", required = true, example = "1")
	private Long roleId;

}
