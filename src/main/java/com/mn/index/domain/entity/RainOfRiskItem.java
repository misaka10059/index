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
public class RainOfRiskItem extends BaseEntity {

    @Column
    private String name;

    @Column
    private String color;

    @Column
    private String detail;

    public static RainOfRiskItem create(String name, String color, String detail) {
        RainOfRiskItem rainOfRiskItem = new RainOfRiskItem(name, color, detail);
        session().persist(rainOfRiskItem);
        return rainOfRiskItem;
    }
}
