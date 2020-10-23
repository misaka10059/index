package com.mn.index.controller;

import ccsfr.core.web.BaseApiController;
import ccsfr.core.web.ResponseData;
import com.mn.index.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/23 17:06
 * DESC
 */
@Api(description = "api", tags = "文件")
@RestController
@RequestMapping(value = "/file")
public class FileController extends BaseApiController {

    @Autowired
    private FileService fileService;

    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object upload(@RequestParam MultipartFile file) {
        return ResponseData.ok(fileService.saveFile(file));
    }

    @ApiOperation("下载文件")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(@RequestParam String id,
                         HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        fileService.downloadFileById(id, request, response);
    }
}
