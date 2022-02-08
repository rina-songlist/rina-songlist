package com.rina.service;

import com.rina.domain.dto.SongListDto;
import com.rina.resp.PageResp;

import java.util.List;

/**
 * 歌单展示相关的服务
 *
 * @author arvin
 * @date 2022/02/07
 */
public interface SongListService {

	/**
	 * 查询歌单
	 * @param pageSize 页面大小
	 * @param pageNum 第n页
	 * @param ids 歌曲IDs
	 * @param nameOrArtist 歌名或歌手名
	 * @return 歌单内容
	 */
	PageResp<List<SongListDto>> querySongLists(Integer pageSize,
	                                           Integer pageNum,
	                                           Long[] ids,
	                                           String nameOrArtist);

}
