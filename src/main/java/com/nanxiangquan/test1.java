package com.nanxiangquan;

import com.nanxiangquan.common.imgUtils;
import com.nanxiangquan.interceptor.LoginInterceptor;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test1 {
    public static void main(String[] args) {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
       // Client client = dcf.createClient("http://127.0.0.1:8099/soap/imgUpload?wsdl");
        Client client = dcf.createClient("http://127.0.0.1:8099/soap/imgUpload?wsdl");

        // 需要密码的情况需要加上用户名和密码
        client.getOutInterceptors().add(new LoginInterceptor("admin", "@Yac123456@"));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            File file = new File("C:\\Users\\南香权\\Desktop\\7c08f23e4cd6d184a7a283033c2e5442_8800276_184927469000_2.png");

            byte[] bytes = imgUtils.File2byte(file);
            objects = client.invoke("uploadImg",bytes,file.getName());
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }



}
