package com.mn.index.domain.entity;

import ccsfr.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/23 16:48
 * DESC
 */
@Table
@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class File extends BaseEntity {

    @Column
    private String name;

    @Column
    private long size;

    @Column
    private String extension;

    @Column
    private String path;

    @Column
    private String url;

    @Column
    private String thumbnailUrl;

    public static File create(String name, long size, String path, String url, String thumbnailUrl) {
        String[] split = name.split("\\.");
        String extension = split.length == 1 ? "" : split[split.length - 1].toLowerCase();
        File file = new File(name, size, extension, path, url, thumbnailUrl);
        session().persist(file);
        return file;
    }
}
