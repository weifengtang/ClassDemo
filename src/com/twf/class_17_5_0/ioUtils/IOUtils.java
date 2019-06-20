package com.twf.class_17_5_0.ioUtils;

import java.io.*;
import java.util.ResourceBundle;

/**
 * @ClassName:IOUtils
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/49:05
 * @Version:1.0
 **/
public class IOUtils {


    //读取"D:/temp/sources/source.txt"
    public static String readDatas(String pathName)  {
        String result = "";
        try {
            File file =  new File(pathName);
            if (!file.exists()){
                return  "上次成绩为 0";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = "";
            while ((str = bufferedReader.readLine())!=null){
                result+=str;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    //写入"D:/temp/sources/source.txt"
    public static void writerDatas(String datas,String pathName,Boolean bool)  {
        BufferedWriter bufferedWriter = null;
        String parent = pathName.substring(0,pathName.lastIndexOf('/'));
        File file=  new File(parent);
        if (!file.exists()) {
            file.mkdirs();
        }
        String path = pathName.substring(pathName.lastIndexOf('/')+1,pathName.length());

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(file,path),bool));
            bufferedWriter.write("\r\n");
            bufferedWriter.write(datas);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

  /*  public static void main(String[] args) throws IOException {
       // System.out.println( readDatas("D:/temp/sources/source.txt"));
        writerDatas("22222","D:/temp/sources/新建文本文档..txt",true);
    }*/
}
