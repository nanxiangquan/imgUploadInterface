package com.nanxiangquan.service.impl;

import com.nanxiangquan.common.imgUtils;
import com.nanxiangquan.service.ImgUploadService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.jws.WebService;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.*;

@WebService(serviceName = "ImgUploadService",//对外发布的服务名
        targetNamespace = "http://service.nanxiangquan.com",//指定你想要的名称空间，通常使用使用包名反转
        endpointInterface = "com.nanxiangquan.service.ImgUploadService")
//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
public class ImgUploadServiceImpl implements ImgUploadService {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String uploadImg(byte[] buf,String fileName) throws IOException {


//        List<String> urls = new ArrayList<String>();
//
//            FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());
//            InputStream input = new FileInputStream(file);
//            OutputStream os = fileItem.getOutputStream();
//            IOUtils.copy(input, os);
//            MultipartFile mulFile = new CommonsMultipartFile(fileItem);
//
//
//            //本地使用,上传位置
////        String rootPath ="/www/uploads/";
//            String rootPath = "C:\\apache-tomcat-8.5.40\\uploads\\";
//
//            //文件的完整名称,如spring.jpeg
//            String filename = mulFile.getOriginalFilename();
//            //文件名,如spring
//            String name = filename.substring(0, filename.indexOf("."));
//            //文件后缀,如.jpeg
//            String suffix = filename.substring(filename.lastIndexOf("."));
//
//            //创建年月文件夹
//            Calendar date = Calendar.getInstance();
//            File dateDirs = new File(date.get(Calendar.YEAR)
//                    + File.separator + (date.get(Calendar.MONTH) + 1));
//
//            //目标文件
//            File descFile = new File(rootPath + File.separator + dateDirs + File.separator + filename);
//            int i = 1;
//            //若文件存在重命名
//            String newFilename = filename;
//            while (descFile.exists()) {
//                newFilename = name + "(" + i + ")" + suffix;
//                String parentPath = descFile.getParent();
//                descFile = new File(parentPath + File.separator + newFilename);
//                i++;
//            }
//            //判断目标文件所在的目录是否存在
//            if (!descFile.getParentFile().exists()) {
//                //如果目标文件所在的目录不存在，则创建父目录
//                descFile.getParentFile().mkdirs();
//            }
//
//            //将内存中的数据写入磁盘
//            try {
//                mulFile.transferTo(descFile);
//            } catch (Exception e) {
//                e.printStackTrace();
//                LOGGER.error("上传失败，cause:{}", e);
//            }
//            //完整的url
//            String fileUrl = "/uploads/" + dateDirs + "/" + newFilename;
//            InetAddress address = InetAddress.getLocalHost();
//            String hostAddress = address.getHostAddress();//ip地址
//            String url = "http://"+hostAddress+":8080"+fileUrl;
//            urls.add(url);
        String url = null;
        try {
             url = imgUtils.byte2File(buf, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
}
