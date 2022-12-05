package com.rina.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 歌单返回体
 *
 * @author arvin
 * @Ape 2022/02/07
 */
@Data
@SuperBuilder
@With
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "歌单详情内容")
public class SongListDto implements Serializable {

	private static final long serialVersionUID = -5350617301641447106L;

	/**
	 * 歌单id
	 */
	@Schema(description = "歌单ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long id;

	/**
	 * 歌曲名
	 */
	@NotNull
	@NotBlank
	@Schema(description = "歌曲名", requiredMode = Schema.RequiredMode.REQUIRED, example = "song name")
	private String name;

	/**
	 * 歌手
	 */
	@Schema(description = "歌手", requiredMode = Schema.RequiredMode.REQUIRED, example = "artist")
	private String artist;

	/**
	 * 语言
	 */
	@NotNull
	@NotBlank
	@Schema(description = "语言", requiredMode = Schema.RequiredMode.REQUIRED, example = "JPN")
	private String language;

}
