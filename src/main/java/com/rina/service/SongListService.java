package com.rina.service;

import com.rina.resp.Resp;

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
	 * @param orderBy 排序依据
	 * @param withDesc 是否倒序
	 * @param ids 歌曲IDs
	 * @param nameOrArtist 歌名或歌手名
	 * @return 歌单内容
	 */
	Resp querySongLists(Integer pageSize,
	                    Integer pageNum,
	                    String orderBy,
	                    Boolean withDesc,
	                    String nameOrArtist,
	                    Long... ids);

}
