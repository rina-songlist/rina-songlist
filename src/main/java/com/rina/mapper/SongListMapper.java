package com.rina.mapper;

import com.rina.domain.SongList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * song_list表所对应的mapper
 * @author arvin
 */
@Mapper
public interface SongListMapper {
    int deleteByPrimaryKey(Long songId);

    int insert(SongList record);

    SongList selectByPrimaryKey(Long songId);

    List<SongList> selectAll();

    int updateByPrimaryKey(SongList record);
}