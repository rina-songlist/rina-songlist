package com.rina.controller;

import com.rina.domain.dto.SongListDto;
import com.rina.resp.Resp;
import com.rina.service.SongListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 歌单展示相关的controller
 *
 * @author arvin
 * @date 2022/02/09
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "歌单展示")
public class SongListController {

	private final SongListService songListService;

	@GetMapping("/song-list")
	@Operation(summary = "普通用户所看到的歌单信息")
	public Resp publicUserSongList(@RequestParam @Parameter(name = "页面展示的数据量", in = ParameterIn.QUERY, required = true) Integer pageSize,
	                               @RequestParam @Parameter(name = "当前页数", in = ParameterIn.QUERY, required = true) Integer pageNum,
	                               @RequestParam @Parameter(name = "排序依据", in = ParameterIn.QUERY, required = true) String orderBy,
	                               @RequestParam @Parameter(name = "是否倒叙排序", in = ParameterIn.QUERY, required = true) Boolean withDesc,
	                               @RequestParam(required = false) @Parameter(name = "歌手或歌手名", in = ParameterIn.QUERY) String nameOrArtist,
	                               @RequestParam(required = false) @Parameter(name = "歌曲IDs", in = ParameterIn.QUERY) Long... ids) {
		return songListService.listSongLists(pageSize, pageNum, orderBy, withDesc, nameOrArtist, ids);
	}

	@GetMapping("/private/system/song-list")
	@PreAuthorize("hasAuthority('sys:songlist:view')")
	@Operation(summary = "管理用户所看到的歌单信息", security = {@SecurityRequirement(name = "Authorization")})
	public Resp privateUserSongList(@RequestParam @Parameter(name = "页面展示的数据量", in = ParameterIn.QUERY, required = true) Integer pageSize,
	                                @RequestParam @Parameter(name = "当前页数", in = ParameterIn.QUERY, required = true) Integer pageNum,
	                                @RequestParam @Parameter(name = "排序依据", in = ParameterIn.QUERY, required = true) String orderBy,
	                                @RequestParam @Parameter(name = "是否倒叙排序", in = ParameterIn.QUERY, required = true) Boolean withDesc,
	                                @RequestParam(required = false) @Parameter(name = "歌手或歌手名", in = ParameterIn.QUERY) String nameOrArtist) {
		return songListService.listSongLists(pageSize, pageNum, orderBy, withDesc, nameOrArtist, null);
	}

	@GetMapping("/private/system/song-list/{id}")
	@Operation(summary = "获取单条歌单", security = {@SecurityRequirement(name = "Authorization")})
	public Resp getSingleSong(@PathVariable(value = "id") @Parameter(name = "歌曲ID", in = ParameterIn.PATH, required = true) Long songId) {
		return songListService.getSingleSong(songId);
	}

	@PutMapping("/private/system/song-list")
	@Operation(summary = "添加（更改）歌单", security = {@SecurityRequirement(name = "Authorization")})
	public Resp editSongList(@RequestBody @Parameter(name = "歌单详情", in = ParameterIn.DEFAULT, required = true) SongListDto songListDto) {
		return songListService.editSongList(songListDto);
	}

	@DeleteMapping("/private/system/song-list/{id}")
	@Operation(summary = "删除一条歌单", security = {@SecurityRequirement(name = "Authorization")})
	public Resp deleteSongList(@PathVariable(value = "id") @Parameter(name = "歌曲ID", in = ParameterIn.PATH, required = true) Long songId) {
		return songListService.deleteSongList(songId);
	}

}
