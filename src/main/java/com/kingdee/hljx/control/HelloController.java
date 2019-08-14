package com.kingdee.hljx.control;

import com.kingdee.hljx.config.DataSourceContextHodler;
import com.kingdee.hljx.entity.ext.TItem3001;
import com.kingdee.hljx.entity.item.TICItem;
import com.kingdee.hljx.entity.item.TItem;
import com.kingdee.hljx.entity.submessage.MeasureInType;
import com.kingdee.hljx.entity.submessage.TSubMessage;
import com.kingdee.hljx.entity.submessage.Team;
import com.kingdee.hljx.entity.user.TUser;
import com.kingdee.hljx.entity.user.TUserType;
import com.kingdee.hljx.repository.user.TUserTypeReposition;
import com.kingdee.hljx.service.TItemService;
import com.kingdee.hljx.service.TSubMessageService;
import com.kingdee.hljx.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HelloController {

    @Resource
    private TItemService itemService;
    @Resource
    private UserService userService;
    @Resource
    private TUserTypeReposition userTypeReposition;
    @Resource
    private TSubMessageService submsgService;
    @RequestMapping("/hello")
    public String hello(){
        return "hello hljx";
    }

    @RequestMapping("/ticitems")
    public List<TICItem> getTICItems(){
        DataSourceContextHodler.setDataSource("003");

//        return itemService.getAllTItems();
//        return itemService.getAllTICItems();
        return null;
    }

    @RequestMapping("/type")
    public List<TUserType> type(){
        DataSourceContextHodler.setDataSource("003");
        return userTypeReposition.findAll();
    }
    @RequestMapping("/admin")
    public String admin(){
        DataSourceContextHodler.setDataSource("003");
        TUser user = userService.getUserByUsernamePwd("孙艳",null);
        return new String(user.getPasswordHashValue());
    }
    @RequestMapping("/ban")
    public List<TItem3001> ban(){
        DataSourceContextHodler.setDataSource("003");
return null;
//        return itemService.findTItem3001("");

    }
    @RequestMapping("bang")
    public List<MeasureInType> bang(){
        DataSourceContextHodler.setDataSource("003");
        return submsgService.getMeasureInType();
    }
    @RequestMapping("team")
    public List<Team> team(){
        DataSourceContextHodler.setDataSource("003");
        return submsgService.getTeams();
    }
}
