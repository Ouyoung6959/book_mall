package com.hnit.bmall.book.util;

import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;
import org.csource.fastdfs.ClientGlobal;

import java.io.IOException;


/**
 * @author Ouyoung
 * @date 2020/5/7
 **/
public class PmsUploadUtil {
    public static String uploadImage(MultipartFile multipartFile) {
        String imageUrl ="http://192.168.249.131";

        String file = PmsUploadUtil.class.getResource("/tracker.conf").getFile();
        try {
            ClientGlobal.init(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer= null;
        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StorageClient storageClient=new StorageClient(trackerServer,null);

        String originalFilename = multipartFile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            String[] upload_files = storageClient.upload_file(multipartFile.getBytes(), substring, null);

            for (String upload_file :upload_files ) {
                imageUrl += "/"+upload_file;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return imageUrl;
    }
}
