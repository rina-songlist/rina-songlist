package com.rina.mapper;

import com.rina.domain.SongList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * mapper的测试类
 * @author arvin
 * @date 2022/02/07
 */
@SpringBootTest
public class SongListMapperTests {

	@Autowired
	private SongListMapper songListMapper;

	@Test
	public void testSelectByNameOrArtist() {
		final List<SongList> songList = songListMapper.selectByNameOrArtist("影炎");
		System.out.println(songList);
	}

	@Test
	public void testSelectByIds() {
		final List<SongList> songList = songListMapper.selectByIds(new Long[]{50L, 40L});
		System.out.println(songList);
	}

}
