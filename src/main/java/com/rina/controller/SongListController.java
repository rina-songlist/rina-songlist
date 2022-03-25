package com.rina.controller;

import com.rina.domain.dto.SongListDto;
import com.rina.resp.Resp;
import com.rina.service.SongListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 歌单展示相关的controller
 *
 * @author arvin
 * @date 2022/02/09
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "歌单展示")
public class SongListController {

	private final SongListService songListService;

	@GetMapping("/song-list")
	@ApiOperation(value = "普通用户所看到的歌单信息", notes = "无需鉴权")
	public Resp publicUserSongList(@RequestParam(required = true) @ApiParam(value = "页面展示的数据量", required = true) Integer pageSize,
	                               @RequestParam(required = true) @ApiParam(value = "当前页数", required = true) Integer pageNum,
	                               @RequestParam(required = true) @ApiParam(value = "排序依据", required = true) String orderBy,
	                               @RequestParam(required = true) @ApiParam(value = "是否倒序排序", required = true) Boolean withDesc,
	                               @RequestParam(required = false) @ApiParam(value = "歌名或歌手名", required = false) String nameOrArtist,
	                               @RequestParam(required = false) @ApiParam(value = "歌曲IDs", required = false) Long... ids) {
		return songListService.listSongLists(pageSize, pageNum, orderBy, withDesc, nameOrArtist, ids);
	}

	@GetMapping("/private/system/song-list")
	@ApiOperation(value = "管理用户所看到的歌单信息", notes = "需要鉴权")
	public Resp privateUserSongList(@RequestParam(required = true) @ApiParam(value = "页面展示的数据量", required = true) Integer pageSize,
	                               @RequestParam(required = true) @ApiParam(value = "当前页数", required = true) Integer pageNum,
	                               @RequestParam(required = true) @ApiParam(value = "排序依据", required = true) String orderBy,
	                               @RequestParam(required = true) @ApiParam(value = "是否倒序排序", required = true) Boolean withDesc,
	                               @RequestParam(required = false) @ApiParam(value = "歌名或歌手名", required = false) String nameOrArtist) {
		return songListService.listSongLists(pageSize, pageNum, orderBy, withDesc, nameOrArtist,  null);
	}

	@GetMapping("/private/system/song-list/{id}")
	@ApiOperation(value = "获取单条歌单", notes = "需要授权")
	public Resp getSingleSong(@PathVariable(value = "id", required = true) @ApiParam(value = "歌曲ID", required = true) Long songId) {
		return songListService.getSingleSong(songId);
	}

	@PutMapping("/private/system/song-list")
	@ApiOperation(value = "添加（更改）歌单", notes = "需要授权")
	public Resp editSongList(@RequestBody(required = true) @ApiParam(value = "歌单详情", required = true) SongListDto songListDto) {
		return songListService.editSongList(songListDto);
	}

	@DeleteMapping("/private/system/song-list/{id}")
	@ApiOperation(value = "删除一条歌单", notes = "需要授权")
	public Resp deleteSongList(@PathVariable(value = "id", required = true) @ApiParam(value = "歌曲ID", required = true) Long songId) {
		return songListService.deleteSongList(songId);
	}

}
