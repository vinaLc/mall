package com.macro.mall.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author vnaLc
 * @version 2019/1/9
 */
@Configuration
@ConfigurationProperties(prefix = "mall.security.jwt")
@Data
public class JwtTokenProperties {
    private String secret;
    private Long expiration;
    private String tokenHeader;
    private String tokenHead;
}
