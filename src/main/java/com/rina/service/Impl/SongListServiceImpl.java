package com.rina.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rina.domain.dto.SongListDto;
import com.rina.enums.ResultCode;
import com.rina.mapper.SongListMapper;
import com.rina.resp.PageResp;
import com.rina.service.SongListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 歌单展示相关的服务
 *
 * @author arvin
 * @date 2022/02/07
 */
@Service
@RequiredArgsConstructor
public class SongListServiceImpl implements SongListService {

	private final SongListMapper songListMapper;

	@Override
	public PageResp<List<SongListDto>> querySongLists(Integer pageSize,
	                                                  Integer pageNum,
	                                                  Long[] ids,
	                                                  String nameOrArtist) {
		final Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		List<SongListDto> songListDtoList = null;
		int totalPages = 0;

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
		totalPages = page.getPages();

		return PageResp.succeed(ResultCode.OK, songListDtoList, totalPages);
	}

}
