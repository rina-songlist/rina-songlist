package com.rina.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * song_list表所对应的实体类
 * @author arvin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SongList extends AbstractDomainTable {

    private static final long serialVersionUID = -5514114779942724772L;

    private String name;

    private String artist;

    private String language;

    public SongList(String createBy, Date createTime, String updateBy, Date updateTime, Long id, String name, String artist, String language) {
        super(id, createBy, createTime, updateBy, updateTime);
        this.name = name;
        this.artist = artist;
        this.language = language;
    }

}