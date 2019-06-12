package com.nanxiangquan.service;

import javax.jws.WebService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebService(targetNamespace="http://service.nanxiangquan.com")
public interface ImgUploadService {
    public String uploadImg(byte[] buf,String fileName) throws IOException;
}
