package com.kingdee.hljx.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceContextHodler {
    private static final ThreadLocal<String> CONTEXT_HODLER = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(DataSourceContextHodler.class);

    public static void setDataSource(String dataSourceName) {
        logger.info("设置数据源：{}",dataSourceName);
        CONTEXT_HODLER.set(dataSourceName);
    }

    public static String getDataSource(){
        logger.info("获取数据源：{}",CONTEXT_HODLER.get());
        return CONTEXT_HODLER.get();
    }

    public static void clearDataSource(){
        logger.info("清除数据：{}",CONTEXT_HODLER.get());
        CONTEXT_HODLER.remove();
    }
}
