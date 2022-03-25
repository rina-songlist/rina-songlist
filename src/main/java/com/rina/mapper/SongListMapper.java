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

    /**
     * 条件搜索歌单
     * @param nameOrArtist 歌名或歌手名
     * @return 歌单内容
     */
    List<SongList> selectByNameOrArtist(String nameOrArtist);

    /**
     * 通过多ID搜索歌单
     * @param ids 多个歌曲ID
     * @return 歌单内容
     */
    List<SongList> selectByIds(Long[] ids);

    /**
     * 用户名更新时更新表中的创建者和更新者
     * @param newEditor 新的用户名
     * @return
     */
    int updateEditorName(String newEditor);
}