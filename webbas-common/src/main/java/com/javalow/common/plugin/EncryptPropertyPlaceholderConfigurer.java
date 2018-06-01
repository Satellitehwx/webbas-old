package com.javalow.common.plugin;

import com.javalow.common.utils.AESUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @anthor Satellite
 * EncryptPropertyPlaceholderConfigurer
 * 数据库配置文件解密 插件类
 * http://www.javalow.com
 * @date 2018-06-01-14:17
 **/
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private String[] propertyNames = {
            "master.jdbc.password", "slave.jdbc.password", "generator.jdbc.password", "master.redis.password"
    };

    /**
     * 解密指定propertyName的加密属性值
     *
     * @param propertyName
     * @param propertyValue
     * @return
     */
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        for (String p : propertyNames) {
            if (p.equalsIgnoreCase(propertyName)) {
                return AESUtil.AESDecode(propertyValue);
            }
        }
        return super.convertProperty(propertyName, propertyValue);
    }

}
