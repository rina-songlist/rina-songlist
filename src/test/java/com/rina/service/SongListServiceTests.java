package com.rina.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rina.domain.dto.SongListDto;
import com.rina.resp.PageResp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
	void TestQuerySongListsWithNameAndArtist() throws JsonProcessingException {
		final PageResp<List<SongListDto>> listPageResp = songListService.querySongLists(10, 1, "id", false,null,null);
		final String s = objectMapper.writeValueAsString(listPageResp);
		System.out.println(s);
	}

	@Test
	void TestQuerySongListsWithIds() throws JsonProcessingException {
		final PageResp<List<SongListDto>> listPageResp = songListService.querySongLists(10, 1, "name", true,null, new Long[]{50L, 40L});
		final String s = objectMapper.writeValueAsString(listPageResp);
		System.out.println(s);
	}

}
