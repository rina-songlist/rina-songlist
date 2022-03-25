package com.rina.service;

import com.rina.domain.dto.SongListDto;
import com.rina.resp.Resp;

/**
 * 歌单展示相关的服务
 *
 * @author arvin
 * @date 2022/02/07
 */
public interface SongListService extends PublicService{

	/**
	 * 查询歌单
	 * @param pageSize 页面大小
	 * @param pageNum 第n页
	 * @param orderBy 排序依据
	 * @param withDesc 是否倒序
	 * @param ids 歌曲IDs
	 * @param nameOrArtist 歌名或歌手名
	 * @return 歌单内容
	 */
	Resp listSongLists(Integer pageSize,
	                   Integer pageNum,
	                   String orderBy,
	                   Boolean withDesc,
	                   String nameOrArtist,
	                   Long... ids);

	/**
	 * 获取一条歌单
	 * @param songId 歌曲ID
	 * @return
	 */
	Resp getSingleSong(Long songId);

	/**
	 * 添加（更改）一条歌单
	 * @param songListDto 歌单返回体
	 * @return
	 */
	Resp editSongList(SongListDto songListDto);

	/**
	 * 删除一条歌单
	 * @param songId 歌曲ID
	 * @return
	 */
	Resp deleteSongList(Long songId);

}
