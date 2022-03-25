package com.rina.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "歌单详情内容")
public class SongListDto implements Serializable {

	private static final long serialVersionUID = -5350617301641447106L;

	/**
	 * 歌单id
	 */
	@ApiModelProperty(value = "歌单ID", required = false, example = "1")
	private Long id;

	/**
	 * 歌曲名
	 */
	@NotNull
	@NotBlank
	@ApiModelProperty(value = "歌曲名", required = true, example = "test")
	private String name;

	/**
	 * 歌手
	 */
	@ApiModelProperty(value = "歌手", required = true, example = "tester")
	private String artist;

	/**
	 * 语言
	 */
	@NotNull
	@NotBlank
	@ApiModelProperty(value = "语言", required = true, example = "JPN")
	private String language;

}
