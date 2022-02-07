package com.rina.domain;

import lombok.*;

import java.util.Date;

/**
 * song_list表所对应的实体类
 * @author arvin
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class SongList {
    private Long songId;

    private String songName;

    private String songArtist;

    private String songLanguage;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}