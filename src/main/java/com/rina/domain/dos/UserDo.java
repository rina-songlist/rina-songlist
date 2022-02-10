package com.rina.domain.dos;

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
public class UserDo implements Serializable {

	private static final long serialVersionUID = 3019037580106318923L;

	private String userName;

	private String roleName;

}
