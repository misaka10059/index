package com.mn.index.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/5/5 14:08
 * DESC
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDto {

    private String id;

    private String name;

    private String acg18Url;

    private String hostUrl;

    private String networkCode;
}
