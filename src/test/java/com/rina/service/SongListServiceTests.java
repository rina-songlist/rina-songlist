package com.rina.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rina.domain.dto.SongListDto;
import com.rina.domain.vo.UserDetailsVo;
import com.rina.resp.Resp;
import com.rina.util.MyThreadLocal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 歌单展示相关的service的测试
 *
 * @author arvin
 * @date 2022/02/08
 */
@SpringBootTest
public class SongListServiceTests {

	@Autowired
	private SongListService songListService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testQuerySongListsWithNameAndArtist_withoutLogin() throws JsonProcessingException {
		final Resp listPageResp = songListService.listSongLists(10, 1, "id", false,null,null);
		final String s = objectMapper.writeValueAsString(listPageResp);
		System.out.println(s);
	}

	@Test
	void testQuerySongListsWithIds() throws JsonProcessingException {
		final Resp listPageResp = songListService.listSongLists(10, 1, "name", true,null, 50L, 40L);
		final String s = objectMapper.writeValueAsString(listPageResp);
		System.out.println(s);
	}

	@Test
	void testQuerySongListsWithNameAndArtist_withLogin() {
		MyThreadLocal.set(new UserDetailsVo("test", 1l));

		final Resp resp = songListService.listSongLists(10, 1, "id", false, null, null);
		System.out.println(JSON.toJSONString(resp));

		MyThreadLocal.unset();
	}

	@Test
	void testGetSingleSong() {
		final Resp resp = songListService.getSingleSong(1L);
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	void testEditSongListWithInsert() {
		MyThreadLocal.set(new UserDetailsVo("test", 1l));

		final Resp resp = songListService.editSongList(new SongListDto(null,
				"test",
				"teser",
				"JPN"));
		System.out.println(JSON.toJSONString(resp));

		MyThreadLocal.unset();
	}

	@Test
	void testEditSongListWithUpdate() {
		MyThreadLocal.set(new UserDetailsVo("tester", 1l));

		final Resp resp = songListService.editSongList(new SongListDto(231L,
				"test2",
				"teser",
				"JPN"));
		System.out.println(JSON.toJSONString(resp));

		MyThreadLocal.unset();
	}

	@Test
	void testDeleteSongList() {
		final Resp resp = songListService.deleteSongList(231L);
		System.out.println(JSON.toJSONString(resp));
	}
}
