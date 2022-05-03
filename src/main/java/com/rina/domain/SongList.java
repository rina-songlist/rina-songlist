package com.rina.domain;

import lombok.*;

import java.io.Serializable;
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
public class SongList implements Serializable {

    private static final long serialVersionUID = -5514114779942724772L;

    private Long id;

    private String name;

    private String artist;

    private String language;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}