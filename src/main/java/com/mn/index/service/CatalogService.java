package com.mn.index.service;

import com.mn.index.domain.dao.CatalogDao;
import com.mn.index.domain.dto.CatalogDto;
import com.mn.index.domain.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/5/5 13:42
 * DESC
 */
@Service
public class CatalogService {
    @Autowired
    private CatalogDao catalogDao;

    /**
     * DATE 2020/5/5 14:05
     * DESC
     */
    @Transactional
    public CatalogDto addCatalog(String name,
                                 String acg18Url,
                                 String hostUrl,
                                 String networkDiskCode) {
        Catalog catalog = Catalog.create(name, acg18Url, hostUrl, networkDiskCode);
        return getCatalogDto(catalog);
    }

    /**
     * DATE 2020/5/5 14:16
     * DESC
     */
    public List<CatalogDto> listCatalog() {
        List<Catalog> catalogList = catalogDao.findAllByIsDeletedFalse();
        return getCatalogDto(catalogList);
    }

    /**
     * DATE 2020/5/5 14:18
     * DESC
     */
    @Transactional
    public CatalogDto updateCatalog(String id,
                                    String name,
                                    String acg18Url,
                                    String hostUrl,
                                    String networkDiskCode) {
        Catalog catalog = catalogDao.findByIdAndIsDeletedFalse(id);
        if (name != null) {

            catalog.setName(name);
        }
        if (acg18Url != null) {
            catalog.setAcg18Url(acg18Url);
        }
        if (hostUrl != null) {
            catalog.setHostUrl(hostUrl);
        }
        if (networkDiskCode != null) {
            catalog.setNetworkDiskCode(networkDiskCode);
        }
        return getCatalogDto(catalog);
    }

    private CatalogDto getCatalogDto(Catalog catalog) {
        return new CatalogDto(
                catalog.getId(),
                catalog.getName(),
                catalog.getAcg18Url(),
                catalog.getHostUrl(),
                catalog.getNetworkDiskCode());
    }

    private List<CatalogDto> getCatalogDto(List<Catalog> catalogList) {
        return catalogList.stream()
                .map(this::getCatalogDto)
                .collect(Collectors.toList());
    }
}
