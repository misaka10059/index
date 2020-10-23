package com.mn.index.controller;

import com.mn.index.service.CatalogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/5/5 14:19
 * DESC
 */
@RestController
@Api(value = "catalog")
@RequestMapping(value = "catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestParam("name") String name,
                      @RequestParam("acg18Url") String acg18Url,
                      @RequestParam("hostUrl") String hostUrl,
                      @RequestParam("networkDiskCode") String networkDiskCode) {
        return catalogService.addCatalog(name, acg18Url, hostUrl, networkDiskCode);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() {
        return catalogService.listCatalog();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(@RequestParam("id") String id,
                         @RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "acg18Url", required = false) String acg18Url,
                         @RequestParam(value = "hostUrl", required = false) String hostUrl,
                         @RequestParam(value = "networkDiskCode", required = false) String networkDiskCode) {
        return catalogService.updateCatalog(id, name, acg18Url, hostUrl, networkDiskCode);
    }
}
