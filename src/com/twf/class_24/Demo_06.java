package com.twf.class_24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName:Demo_06
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1620:18
 * @Version:1.0
 *
 * •try-with-resources语句的作用？
 **/
public class Demo_06 {

    public static void main(String[] args) throws IOException {
        String readTxt = new Demo_06().readFile("d:\\123.txt");
        System.out.println(readTxt);
    }

    public String readFile(String path) throws IOException {
        //资源在代码执行完自动释放
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(String.format("%n"));
            }
            return builder.toString();
        }
    }
}
