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
 * DATE 2020/5/5 13:25
 * DESC
 */

@Entity
@Table
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class Catalog extends BaseEntity {


    @Column
    private String name;

    @Column(name = "acg18_url")
    private String acg18Url;

    @Column
    private String hostUrl;

    @Column
    private String networkDiskCode;

    public static Catalog create(String name,
                                 String acg18Url,
                                 String hostUrl,
                                 String networkCode) {
        Catalog catalog = new Catalog(name, acg18Url, hostUrl, networkCode);
        session().persist(catalog);
        return catalog;
    }

}
