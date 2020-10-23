package com.mn.index.service;

import ccsfr.core.web.ServiceException;
import ccsfr.file.SavedFile;
import ccsfr.file.fastdfs.FastDFSClient;
import com.mn.index.domain.dao.FileDao;
import com.mn.index.domain.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/23 17:03
 * DESC
 */
@Service
public class FileService {

    @Autowired
    private FileDao fileDao;

    @Autowired
    private FastDFSClient fastDFSClient;

    @Autowired
    private com.mn.index.common.component.FastDFSClient localDFSClient;

    /**
     * DATE 2020/10/23 17:34
     * DESC 上传文件
     */
    @Transactional
    public File saveFile(MultipartFile file) {
        SavedFile savedFile;
        try {
            savedFile = fastDFSClient.uploadFile(file);
        } catch (IOException e) {
            throw new ServiceException(501, "文件存储失败：" + e.getMessage());
        }
        return File.create(file.getOriginalFilename(), file.getSize(), savedFile.getAccessPath(), savedFile.getAccessUrl(), "");
    }

    /**
     * DATE 2020/10/23 17:34
     * DESC 下载文件
     */
    public void downloadFileById(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        File file = fileDao.findOne(id);
        byte[] bytes = localDFSClient.downloadFile(file.getPath());
        String fileName = file.getName();
        response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''"
                + URLEncoder.encode(fileName, "UTF-8"));
        OutputStream stream = response.getOutputStream();
        stream.write(bytes);
        stream.close();
    }
}
