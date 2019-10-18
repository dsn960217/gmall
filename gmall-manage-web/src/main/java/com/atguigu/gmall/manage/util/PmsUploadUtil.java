package com.atguigu.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PmsUploadUtil {
    public static String uploadImage(MultipartFile multipartFile){
        String imgUrl="http://192.168.147.128";
        // 配置fdfs的全局链接地址
        String tracker = null;
        try {
            tracker = ResourceUtils.getFile("classpath:tracker.conf").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TrackerClient trackerClient = new TrackerClient();

        // 获得一个trackerServer的实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 通过tracker获得一个Storage链接客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);


        try {
            byte[] bytes=multipartFile.getBytes();//获得上传迟到二进制
            String originalFilename=multipartFile.getOriginalFilename();//a.jpg
            System.out.println(originalFilename);
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i+1);

            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);


            for (String uploadInfo : uploadInfos) {
                imgUrl += "/"+uploadInfo;


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imgUrl;
    }
}
