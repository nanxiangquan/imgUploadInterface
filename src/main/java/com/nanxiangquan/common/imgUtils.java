package com.nanxiangquan.common;

import java.io.*;
import java.net.InetAddress;
import java.util.Calendar;

public class imgUtils {
    public static String byte2File(byte[] buf,String fileName) throws Exception {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        String rootPath = "/usr/webapp/apache-tomcat-8.5.40/uploads";

            //文件名,如spring
            String name = fileName.substring(0, fileName.indexOf("."));
            //文件后缀,如.jpeg
            String suffix = fileName.substring(fileName.lastIndexOf("."));

            //创建年月文件夹
            Calendar date = Calendar.getInstance();
            File dateDirs = new File(date.get(Calendar.YEAR)
                    + File.separator + (date.get(Calendar.MONTH) + 1));

            //目标文件
            File descFile = new File(rootPath + File.separator + dateDirs + File.separator + fileName);
            int i = 1;
            //若文件存在重命名
            String newFilename = fileName;
            while (descFile.exists()) {
                newFilename = name + "(" + i + ")" + suffix;
                String parentPath = descFile.getParent();
                descFile = new File(parentPath + File.separator + newFilename);
                i++;
            }

            //判断目标文件所在的目录是否存在
            if (!descFile.getParentFile().exists()) {
                //如果目标文件所在的目录不存在，则创建父目录
                descFile.getParentFile().mkdirs();
            }

            fos = new FileOutputStream(descFile);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
            //完整的url
            String fileUrl = "/uploads/" + dateDirs + "/" + newFilename;
            InetAddress address = InetAddress.getLocalHost();
            String hostAddress = address.getHostAddress();//ip地址
            String url = "http://"+"111.230.57.73"+":8099"+fileUrl;
            return url;

    }
    public static byte[] File2byte(File file)
    {
        byte[] buffer = null;
        try
        {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return buffer;
    }
}
