package com.ch.controller;

import org.apache.commons.io.IOUtils;
import com.ch.config.FastDFSClient;
import com.ch.ffmpeg.Ffmpeg;
import com.ch.models.Result;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/uploadfile")
public class UploadFileController {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;//文件服务器地址

    @RequestMapping("/upload")
    public Result upload(MultipartFile file){
        //1、取文件的扩展名
        String originalFilename = file.getOriginalFilename(); // 获取文件名
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); // 获取文件后缀
        System.out.println(originalFilename);
        System.out.println(extName);
        try {
            //2.视频转码
            String filePath = "F:\\input\\" + originalFilename;
            file.transferTo(new File(filePath)); // 将MultipartFile转为File存入磁盘
            Ffmpeg.ffmpeg(originalFilename); // 将File转码为MP4
            MultipartFile multipartFile = this.fileToMultipartFile(originalFilename);
            //3、创建一个 FastDFS 的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:fdfs_client.conf");
            //4、执行上传处理
            String path = fastDFSClient.uploadFile(multipartFile.getBytes(), "mp4");
            //5、拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = FILE_SERVER_URL + path;
            System.out.println(url);
            return new Result(true, url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }

    @PostMapping("/uploadimg")
    public Result uploadImg(MultipartFile file) {
        //1、取文件的扩展名
        String originalFilename = file.getOriginalFilename(); // 获取文件名
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); // 获取文件后缀
        System.out.println(originalFilename);
        System.out.println(extName);
        try {
            //2、创建一个 FastDFS 的客户端
            FastDFSClient fastDFSClient
                    = new FastDFSClient("classpath:fdfs_client.conf");
            //3、执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);
            //4、拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = FILE_SERVER_URL + path;
            System.out.println(url);
            return new Result(true, url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }


    private MultipartFile fileToMultipartFile(String originalFilename) {
        File file = new  File("F:\\output\\" + originalFilename.substring(0, originalFilename.lastIndexOf(".")) + ".mp4");
        FileItem fileItem = new DiskFileItem(
                "file",
                "text/plain", // 文件类型
                false,
                file.getName(), // 文件名
                1,
                new File("F:\\output\\") // 文件存储位置
        );
        try {
            IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        return multipartFile;
    }

}
