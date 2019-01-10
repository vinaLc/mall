package com.macro.mall.portal.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author vnaLc
 * @version 2019/1/9
 */
@Configuration
@ConfigurationProperties(prefix = "mall.key")
@Data
public class CodeConfigProperties {

    /**
     * 配置http信息
     */
    private Integer http_port;
    private String http_protocol;

    /**
     * redis参数
     */
    private String redis_key_prefix_authCode;
    private String redis_key_prefix_orderId;

    /**
     * RabbitMQ参数
     */
    private String rabbitmq_queue_name_cancelOrder;
    /**
     * 认证失效时间
     */
    private Long authCode_expire_seconds;

}
