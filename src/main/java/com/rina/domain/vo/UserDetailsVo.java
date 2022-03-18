package com.rina.domain.vo;

import lombok.*;

import java.io.Serializable;

/**
 * 简略化的user信息
 *
 * @author arvin
 * @date 2022/02/09
 */
@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsVo implements Serializable {

	private static final long serialVersionUID = 3019037580106318923L;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 权限名
	 */
	private Long roleId;

}
