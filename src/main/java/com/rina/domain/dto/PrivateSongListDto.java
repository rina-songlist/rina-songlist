package com.rina.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * 歌单的管理详情
 *
 * @author arvin
 * @date 2022/03/25
	@Schema(name = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1")
 */
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@With
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "歌单的管理详情")
public class PrivateSongListDto extends SongListDto{

	private static final long serialVersionUID = 7985311136693060361L;

	/**
	 * 创建者
	 */
	@Schema(description = "创建者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String createBy;

	/**
	 * 更新者
	 */
	@Schema(description = "更新者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String updateBy;

}
