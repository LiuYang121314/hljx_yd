package com.kingdee.hljx.control;

import com.kingdee.hljx.config.DataSourceContextHodler;
import com.kingdee.hljx.entity.TAdKdAccountGl;
import com.kingdee.hljx.entity.user.TUser;
import com.kingdee.hljx.service.KDAccountService;
import com.kingdee.hljx.service.UserService;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private KDAccountService kdaService;
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session){
        session.setAttribute(session.getId(),"MAIN");
        return "/login.html";
    }

    @ResponseBody
    @RequestMapping("/getaccs")
    public Iterable<TAdKdAccountGl> getAll(){
        DataSourceContextHodler.setDataSource("MAIN");
        System.out.println(kdaService.getAllAccount());
        return kdaService.getAllAccount();
    }

    @RequestMapping("/getmsg")
    @ResponseBody
    public List<Iterable> getMsg(){
        List<Iterable> list = new ArrayList<>();
        list.add(kdaService.getAllAccount());
//        list.add();
        return list;
    }

    @ResponseBody
    @RequestMapping("/load")
    public String load(String fAcctID, String fName, String pwd, boolean remember, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        DataSourceContextHodler.setDataSource("DB_"+fAcctID);
        session.setAttribute( session.getId(),"DB_"+fAcctID);

        session.setAttribute(fName,fAcctID);
//        if(pwd == null || pwd.trim().equals("")) {
//            pwd = null;
//        }
        TUser user =  userService.getUserByUsernamePwd(fName,pwd);
        if(user == null) {
            DataSourceContextHodler.clearDataSource();
            DataSourceContextHodler.setDataSource("MAIN");
            return formatJson(false,"密码错误~");
        }else {
            session.setAttribute("user", user);
            if(remember) {
//                boolean flag = true;
//                for(Cookie coo : request.getCookies()){
//                    logger.info("cookie的name：{}",coo.getName());
//                    if(coo.getName().equalsIgnoreCase(fName)){
//                        flag = false;
//                        break;
//                    }
//                }
//                if(flag){
//                    Cookie cookie = new Cookie(fName, pwd);
//                    response.addCookie(cookie);
//                }
            }
            DataSourceContextHodler.setDataSource(fAcctID);
            return formatJson(true,"登陆成功");
        }
    }

    @RequestMapping("/index")
    public String index(){
//        return "/phoneindex.html";
        return "/index.html";
    }
    @RequestMapping("/weighing")
    public String weighing(){
        return "/weighing.html";
    }



    @ResponseBody
    @RequestMapping("/user")
    public List<TUser> getUser(HttpSession session){
        DataSourceContextHodler.setDataSource((String)session.getAttribute(session.getId()));
        return userService.getAllUsers();
    }
    @ResponseBody
    @RequestMapping("/user1")
    public Iterable<TUser> getUser1(){
        DataSourceContextHodler.setDataSource("001");
        return userService.getAllUsers();
    }
    @ResponseBody
    @RequestMapping("/user3")
    public TUser getUser3(){
        DataSourceContextHodler.setDataSource("003");
        logger.info(userService.getUserByFUserID(16415).toString());
        return userService.getUserByFUserID(16415);
//        return userService.getAllUsers();
    }

    @ResponseBody
    @RequestMapping("/session")
    public Object getValueByName(String parameName,HttpSession session){
        return session.getAttribute(parameName);
    }


    private String formatJson(boolean success,String msg){
        return "{\"data\":{\"success\":\""+success+"\",\"msg\":\""+msg+"\"}}";
    }
}