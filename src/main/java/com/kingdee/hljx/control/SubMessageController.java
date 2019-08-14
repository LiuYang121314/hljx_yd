package com.kingdee.hljx.control;

import com.kingdee.hljx.config.DataSourceContextHodler;
import com.kingdee.hljx.entity.submessage.MeasureInType;
import com.kingdee.hljx.service.TSubMessageService;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.DataContentHandler;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/submsg")
public class SubMessageController {
    @Resource
    private TSubMessageService submsgService;

    @RequestMapping(path = {"/measureInType"})
    public List<MeasureInType> getTypes(HttpServletResponse response, HttpSession session){
        System.out.printf("1234567890-");
        return submsgService.getMeasureInType();
    }

}
