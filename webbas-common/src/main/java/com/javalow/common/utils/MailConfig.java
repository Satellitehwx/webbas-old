package com.javalow.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @anthor Satellite
 * MailConfig
 * 发送邮件配置工具类
 * http://www.javalow.com
 * @date 2018-06-01-14:26
 **/
public class MailConfig {

    private static final String PROPERTIES_DEFAULT = "mailConfig.properties";
    public static String host;
    public static Integer port;
    public static String userName;
    public static String passWord;
    public static String emailForm;
    public static String timeout;
    public static String personal;
    public static String enable;
    public static Properties properties;

    static {
        init();
    }

    /**
     * 初始化
     */
    private static void init() {
        properties = new Properties();
        try {
            InputStream inputStream = MailConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_DEFAULT);
            properties.load(inputStream);
            inputStream.close();
            //properties.setProperty("mailFrom",properties.getProperty("mailFrom"));
            host = properties.getProperty("mailHost");
            port = Integer.parseInt(properties.getProperty("mailPort"));
            userName = properties.getProperty("mailUsername");
            passWord = properties.getProperty("mailPassword");
            emailForm = properties.getProperty("mailFrom");
            timeout = properties.getProperty("mailTimeout");
            enable = properties.getProperty("enable");
            personal = properties.getProperty("personal");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
