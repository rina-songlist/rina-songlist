package com.rina.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.SuperBuilder;

/**
 * 歌单的管理详情
 *
 * @author arvin
 * @date 2022/03/25
 */
@Data
@SuperBuilder
@With
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "歌单的管理详情")
public class PrivateSongListDto extends SongListDto{

	private static final long serialVersionUID = 7985311136693060361L;

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
