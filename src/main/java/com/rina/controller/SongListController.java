package com.rina.controller;

import com.rina.domain.dto.SongListDto;
import com.rina.resp.PageResp;
import com.rina.service.SongListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public PageResp<List<SongListDto>> publicUserSongList(@RequestParam(required = true) @ApiParam(value = "页面展示的数据量", required = true) Integer pageSize,
	                                                      @RequestParam(required = true) @ApiParam(value = "当前页数", required = true) Integer pageNum,
	                                                      @RequestParam(required = false) @ApiParam(value = "歌曲IDs", required = false) Long[] ids,
	                                                      @RequestParam(required = false) @ApiParam(value = "歌名或歌手名", required = false) String nameOrArtist) {
		return songListService.querySongLists(pageSize, pageNum, ids, nameOrArtist);
	}

}
