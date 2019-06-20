package com.twf.class_24;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName:Demo_05
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1611:29
 * @Version:1.0
 *
 * 两者的参数都是路径串，但：
 *
 * mkdir只能创建父目录存在的目录，而mkdirs不论要创建目录的父目录是否存在都能创建成功。
 * 例如：假设目录d:/home/nginx/file不存在，，
 * 现在要创建d:/home/nginx目录，由于home不存在，所以用mkdir会创建目录失败，而用mkdirs则可以成功
 *
 * 两者创建失败都不会抛出异常：除非是安全性异常SecurityException - 如果存在安全管理器 不允许创建
 **/

public class Demo_05 {
    public static void main(String[] args)  {
        String path="d:/home/nginx/file";
        String path2="d:/home/nginx";
        String path3="home.java";
        try{
            new File(path2).mkdir(); //只创建根目录
            // File file =  new File(path);
            // file.mkdirs(); //创建 根目录及子目录


            /**createNewFile()可能抛出：
             * IOException - 如果发生 I/O 错误
             * SecurityException - 如果存在安全管理器，
             * 且其 SecurityManager.checkWrite(java.lang.String) 方法拒绝对文件进行写访问
             */
            // new File(file,path3).createNewFile();//创建文件

        }catch (Exception e){
            System.out.println("创建失败");
        }

    }
}
