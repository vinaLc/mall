package com.macro.mall.config;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * aliyun配置文件
 * Created by macro on 2018/5/17.
 */
@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "mall.security.aliyun.oss")
public class OssConfig {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private Long expire;
    private Long maxSize;
    private String callback;
    private String prefix;

    @Bean
    public OSSClient ossClient(){
        log.info(" -> oss参数 endpoint={} <-> accessKeyId={} <-> accessKeySecret={}",endpoint,
                accessKeyId,accessKeySecret);
        return new OSSClient(endpoint,accessKeyId,accessKeySecret);
    }
}
