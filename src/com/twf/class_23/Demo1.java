package com.twf.class_23;

import java.io.*;

/**
 * @ClassName:Demo1
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/149:45
 * @Version:1.0
 *
 * 文件操作
 *
 **/
public class Demo1 {

    public static void main(String[] args) throws IOException {
        // mkdirs()可以建立多级文件夹， mkdir()只会建立一级的文件夹
        File file =  new File("D:TTTTT","AA");
        File file2 =  new File("D:\\TTTTT");

        if (!file2.exists()){
            file2.mkdir();
        }
        // 第一种方法：根据文件路径和文件名
        String path = "D:\\TTTTT";
        String filename = "testAA.txt";
       // File myFile = new File(path,filename);
        File myFile = new File(file2,filename);

//        // 第二种方法
//        String fileName = "F:\\test\\test.txt";
//        File myFile = new File(fileName);
//
        if (!myFile.exists()) {
            // 创建文件(前提是目录已存在，若不在，需新建目录即文件夹)
            myFile.createNewFile();
            // 删除文件
            //myFile.delete();
        }


       /* if (!file.exists()){
            file.mkdirs();
        }
        if (!file2.exists()){
            file2.mkdir();
        }*/

       String content = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASDSDSD撒旦撒旦";
        // 第一种：字节流FileOutputStream
        FileOutputStream fop = new FileOutputStream(myFile);
        byte[] contentInBytes = content.getBytes();
        fop.write(contentInBytes);
        fop.flush();
        fop.close();

// 第二种：FileWriter(参数true为追加内容，若无则是覆盖内容)
        FileWriter fw = new FileWriter(myFile,true);
        fw.write(content);
        fw.close();

// 第三种：BufferedWriter
        BufferedWriter bw = new BufferedWriter(new FileWriter(myFile,true));
        bw.write(content);
        bw.flush();
        bw.close();

// 第四种：打印流PrintStream和PrintWriter
// 字节打印流：PrintStream
// 字符打印流：PrintWriter

        PrintWriter pw = new PrintWriter(new FileWriter(myFile,true));
        pw.println(content);      // 换行
        pw.print(content);        // 不换行
        pw.close();

// 常用BufferedWriter和PrintWrite

    }
}
