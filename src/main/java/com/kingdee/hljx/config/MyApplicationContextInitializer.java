package com.kingdee.hljx.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("Bean的个数：{}"+applicationContext.getBeanDefinitionCount());
        for(String temp : applicationContext.getBeanDefinitionNames()){
            log.info("Bean: name:{}",temp);
        }

    }
}
