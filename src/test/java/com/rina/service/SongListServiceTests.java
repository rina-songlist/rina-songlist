package com.rina.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rina.resp.Resp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 歌单展示相关的服务的测试类
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
	void testQuerySongListsWithNameAndArtist() throws JsonProcessingException {
		final Resp listPageResp = songListService.querySongLists(10, 1, "id", false,null,null);
		final String s = objectMapper.writeValueAsString(listPageResp);
		System.out.println(s);
	}

	@Test
	void testQuerySongListsWithIds() throws JsonProcessingException {
		final Resp listPageResp = songListService.querySongLists(10, 1, "name", true,null, 50L, 40L);
		final String s = objectMapper.writeValueAsString(listPageResp);
		System.out.println(s);
	}

}
