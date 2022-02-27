package com.rina.controller;

import com.rina.resp.Resp;
import com.rina.service.SongListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 歌单展示相关的控制器
 *
 * @author arvin
 * @date 2022/02/09
 */
@RestController
@RequestMapping("/song-list")
@RequiredArgsConstructor
@Api(tags = "歌单展示")
public class SongListController {

	private final SongListService songListService;

	@GetMapping("/public-list")
	@ApiOperation(value = "普通用户所看到的歌单信息", notes = "无需鉴权")
	public Resp publicUserSongList(@RequestParam(required = true) @ApiParam(value = "页面展示的数据量", required = true) Integer pageSize,
	                               @RequestParam(required = true) @ApiParam(value = "当前页数", required = true) Integer pageNum,
	                               @RequestParam(required = true) @ApiParam(value = "排序依据", required = true) String orderBy,
	                               @RequestParam(required = true) @ApiParam(value = "是否倒序排序", required = true) Boolean withDesc,
	                               @RequestParam(required = false) @ApiParam(value = "歌名或歌手名", required = false) String nameOrArtist,
	                               @RequestParam(required = false) @ApiParam(value = "歌曲IDs", required = false) Long... ids) {
		return songListService.querySongLists(pageSize, pageNum, orderBy, withDesc, nameOrArtist, ids);
	}

}
