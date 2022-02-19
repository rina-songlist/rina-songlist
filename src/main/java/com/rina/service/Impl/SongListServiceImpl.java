package com.rina.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rina.domain.dto.SongListDto;
import com.rina.enums.ResultCode;
import com.rina.mapper.SongListMapper;
import com.rina.resp.PageResp;
import com.rina.service.SongListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 歌单展示相关的服务
 *
 * @author arvin
 * @date 2022/02/07
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SongListServiceImpl implements SongListService {

	private final SongListMapper songListMapper;

	@Override
	public PageResp<List<SongListDto>> querySongLists(Integer pageSize,
	                                                  Integer pageNum,
	                                                  String orderBy,
	                                                  Boolean withDesc,
	                                                  String nameOrArtist,
	                                                  Long... ids) {
		String orderMsg = null;
		if (!withDesc) {
			orderMsg = "song_" + orderBy;
		} else {
			orderMsg = "song_" + orderBy + " desc";
		}

		final Page<Object> page = PageHelper.startPage(pageNum, pageSize, orderMsg);
		List<SongListDto> songListDtoList = null;
		long totalPages = 0;

		try {
			if (ids != null && ids.length > 0) {
				// 随机查询
				songListDtoList = songListMapper.selectByIds(ids).stream()
						.map(songList -> SongListDto.builder()
								.id(songList.getSongId())
								.name(songList.getSongName())
								.artist(songList.getSongArtist())
								.language(songList.getSongLanguage())
								.build())
						.collect(Collectors.toList());
			} else {
				// 普通查询
				songListDtoList = songListMapper.selectByNameOrArtist(nameOrArtist).stream()
						.map(songList -> SongListDto.builder()
								.id(songList.getSongId())
								.name(songList.getSongName())
								.artist(songList.getSongArtist())
								.language(songList.getSongLanguage())
								.build())
						.collect(Collectors.toList());
			}
		} catch (Exception e) {
			log.error("查询参数有误 {}", e.getLocalizedMessage());
			return PageResp.failed();
		}
		totalPages = page.getTotal();

		return PageResp.succeed(ResultCode.OK, songListDtoList, totalPages);
	}

}
