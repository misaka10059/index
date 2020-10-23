package com.mn.index.common.component;


import ccsfr.core.util.StringUtil;
import com.github.tobato.fastdfs.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Component
public class FastDFSClient {

    @Autowired
    private FastFileStorageClient storageClient;

    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return getResAccessUrl(storePath);
    }

    public String uploadFileStorePath(MultipartFile file) throws IOException {
        return storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null).getFullPath();
    }

    @Autowired
    FdfsWebServer fdfsWebServer;

    // 封装文件完整URL地址
    private String getResAccessUrl(StorePath storePath) {
        return fdfsWebServer.getWebServerUrl() + "/" + storePath.getFullPath();
    }

    // 封装文件完整URL地址
    public String getAccessUrl(String path) {
        return fdfsWebServer.getWebServerUrl() + "/" + path;
    }

    public byte[] downloadFile(String filePath) throws IOException {
        byte[] bytes = null;
        if (!StringUtil.isNullOrEmpty(filePath)) {
            String group = filePath.substring(0, filePath.indexOf("/"));
            String path = filePath.substring(filePath.indexOf("/") + 1);
            DownloadByteArray byteArray = new DownloadByteArray();
            bytes = storageClient.downloadFile(group, path, byteArray);
        }
        return bytes;
    }
}
