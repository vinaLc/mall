package com.macro.mall.portal.config;

import com.macro.mall.portal.properties.CodeConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * tomcat相关配置
 * Created by macro on 2018/8/7.
 */
@Profile("dev")
@Configuration
@Slf4j
public class TomcatConfig {



    @Autowired
    private CodeConfigProperties codeConfigProperties;

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector()); // 添加http
        return tomcat;
    }

    //配置http
    private Connector createStandardConnector() {
        log.info(" HTTP参数信息 http_port={} <-> http_protocol={}",codeConfigProperties.getHttp_port(),
                codeConfigProperties.getHttp_protocol());
        Connector connector = new Connector(codeConfigProperties.getHttp_protocol());
        connector.setPort(codeConfigProperties.getHttp_port());
        return connector;
    }
}
