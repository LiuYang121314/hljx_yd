package com.kingdee.hljx.config;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class SessionInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String MAIN_DATASOURCE = "MAIN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        logger.info("当前uri为：{}",uri);
        if(uri.contains("/test/") ){
            return true;
        }else{
            HttpSession session = request.getSession();
            String dataSourceName = (String) session.getAttribute(session.getId());
            if (dataSourceName == null || dataSourceName.equals("")) {
                if(uri.equals("/login")){
                    DataSourceContextHodler.setDataSource("MAIN");
                    return true;
                }
                response.sendRedirect("/login");
                return false;
            } else {
                DataSourceContextHodler.setDataSource(dataSourceName);
                return true;
            }
        }
    }
}
