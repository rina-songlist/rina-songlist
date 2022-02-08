package com.rina.domain.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 普通用户状态下的歌单返回体
 *
 * @author arvin
 * @date 2022/02/07
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class SongListDto implements Serializable {

	private static final long serialVersionUID = -5350617301641447106L;

	/**
	 * 歌单id
	 */
	private Long id;

	/**
	 * 歌曲名
	 */
	private String name;

	/**
	 * 歌手
	 */
	private String artist;

	/**
	 * 语言
	 */
	private String language;

}
