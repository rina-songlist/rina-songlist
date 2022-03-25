package com.rina.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "权限详情内容")
public class RoleDto implements Serializable {

	private static final long serialVersionUID = 2338060146121957031L;

	/**
	 * 权限ID
	 */
	@ApiModelProperty(value = "权限ID", required = false, example = "1")
	private Long id;

	/**
	 * 权限名
	 */
	@NotNull
	@NotBlank
	@ApiModelProperty(value = "权限名", required = true, example = "true")
	private String role;

	/**
	 * 创建者
	 */
	@ApiModelProperty(value = "创建者", required = false, example = "tester")
	private String createBy;

	/**
	 * 更新者
	 */
	@ApiModelProperty(value = "更新者", required = false, example = "tester")
	private String updateBy;

}
