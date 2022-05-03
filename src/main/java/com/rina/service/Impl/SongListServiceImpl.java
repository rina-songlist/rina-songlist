package com.rina.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rina.domain.SongList;
import com.rina.domain.dto.PrivateSongListDto;
import com.rina.domain.dto.SongListDto;
import com.rina.enums.ResultCode;
import com.rina.mapper.SongListMapper;
import com.rina.resp.PageResp;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import com.rina.service.SongListService;
import com.rina.util.MyThreadLocal;
import com.rina.util.RespUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 歌单展示相关的service
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
	public Resp listSongLists(Integer pageSize,
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
		final boolean loginState = MyThreadLocal.get() == null;
		List<SongListDto> songListDtoList = null;
		long totalPages = 0;

		if (ids != null && ids.length > 0) {
			// 随机查询
			songListDtoList = songListMapper.selectByIds(ids).stream()
					.map(songList -> {
						final SongListDto dto = new SongListDto();
						BeanUtils.copyProperties(songList, dto);
						return dto;
					})
					.collect(Collectors.toList());
		} else if (loginState) {
			// 普通查询（普通用户查询）
			songListDtoList = songListMapper.selectByNameOrArtist(nameOrArtist).stream()
					.map(songList -> {
						final SongListDto dto = new SongListDto();
						BeanUtils.copyProperties(songList, dto);
						return dto;
					})
					.collect(Collectors.toList());
		} else {
			// 普通查询（登陆后的用户查询）
			songListDtoList = songListMapper.selectByNameOrArtist(nameOrArtist).stream()
					.map(songList -> {
						final PrivateSongListDto dto = new PrivateSongListDto();
						BeanUtils.copyProperties(songList, dto);
						return dto;
					})
					.collect(Collectors.toList());
		}
		totalPages = page.getTotal();

		if (songListDtoList.size() == 0) {
			log.error("查询参数有误");
			return Resp.failed();
		} else {
			return PageResp.succeed(ResultCode.OK, songListDtoList, totalPages);
		}
	}

	@Override
	public Resp getSingleSong(Long songId) {
		final SongList songList = songListMapper.getOneSongBySongId(songId);

		if (songList == null) {
			log.error("查询数据不存在");
			return Resp.failed();
		}

		final SongListDto songListDto = SongListDto.builder()
				.id(songId)
				.name(songList.getName())
				.artist(songList.getArtist())
				.language(songList.getLanguage())
				.build();

		return UsualResp.succeed(songListDto);
	}

	@Override
	public Resp editSongList(SongListDto songListDto) {
		final String currentUser = MyThreadLocal.get().get("userName");
		log.info("当前用户为：{}", currentUser);

		int songListResult = 0;
		if (songListDto.getId() == null || songListDto.getId() == 0) {
			// 添加一条歌单
			final SongList songList = new SongList();
			BeanUtils.copyProperties(songListDto, songList);
			songList.setId(null);
			songList.setCreateBy(currentUser);
			songList.setCreateTime(new Date());
			songList.setUpdateBy(currentUser);
			songList.setUpdateTime(new Date());

			songListResult = songListMapper.insert(songList);
		} else {
			// 编辑一条歌单
			SongList songList = songListMapper.getOneSongBySongId(songListDto.getId());

			// 判空处理后添加歌单
			if (dataUsableCheck(songListDto.getName())
			&& dataUsableCheck(songListDto.getArtist())
			&& dataUsableCheck(songListDto.getLanguage())) {
				songList.setName(songListDto.getName());
				songList.setArtist(songListDto.getArtist());
				songList.setLanguage(songListDto.getLanguage());
				songList.setUpdateBy(currentUser);
				songList.setUpdateTime(new Date());
				songListResult = songListMapper.updateOneSongBySongId(songList);
			}
		}

		return RespUtils.editData(songListResult);
	}

	@Override
	public Resp deleteSongList(Long songId) {
		final int songListResult = songListMapper.deleteOneSong(songId);

		return RespUtils.deleteData(songListResult);
	}
}
