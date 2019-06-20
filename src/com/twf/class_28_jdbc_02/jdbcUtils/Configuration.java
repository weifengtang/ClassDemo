package com.twf.class_28_jdbc_02.jdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName:Configuration
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/208:12
 * @Version:1.0
 **/
public class Configuration {
    private static Configuration configuration;
    private Properties properties;

    private Configuration (){
        InputStream inputStream = this.getClass()
                .getClassLoader().getResourceAsStream("jdbc.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 懒汉式 单例模式
     * @return
     */
    public static Configuration getInstance(){
        if (configuration==null){
            configuration = new Configuration();
        }
        return  configuration;
    }

    /**
     *
     * @param key
     * @return value
     */
    public String getValue(String key){
        return  properties.getProperty(key);
    }


}
