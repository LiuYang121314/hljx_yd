package com.kingdee.hljx.control;

import com.kingdee.hljx.config.DataSourceContextHodler;
import com.kingdee.hljx.config.DataSourceContextUtil;
import com.kingdee.hljx.entity.ext.TBOS200000007;
import com.kingdee.hljx.entity.ext.TItem3001;
import com.kingdee.hljx.entity.item.TEmp;
import com.kingdee.hljx.entity.item.TICItem;
import com.kingdee.hljx.service.BOSService;
import com.kingdee.hljx.service.TItemService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.DataContentHandler;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    private TItemService itemService;
    @Resource
    private BOSService bosService;

    @RequestMapping("/hello")
    public String hello (){
        return "hello";
    }
    @RequestMapping(value = "/icitems")//,method = RequestMethod.POST
    public Map<String, Object> getAllICItem(String fNumber){
        Map<String, Object> map = new HashMap<>();
        System.out.printf("!!!!!!!!!!!"+fNumber);
        List<String> list = new ArrayList<>();
        List<Map<String, String>> listMap = new ArrayList<>();

        String query = "\"query\": \""+fNumber+"\"";
        String sug = "\"suggestions\": ";
        for(TICItem icitem :  itemService.getICItems(fNumber)){
            Map<String, String> te = new HashMap<>();
            te.put("data",icitem.getfFullNumber());
            te.put("value",icitem.getfName()+"|"+icitem.getfModel());
            listMap.add(te);
        }
        String res = "{"+query+","+sug+list+"}";
        map.put("query",fNumber);
        map.put("suggestions", listMap);

        return map;

    }
//
//    @RequestMapping("/emps")
//    public List<TEmp> getEmps(){
//        return itemService.getAllTEmp();
//    }

    @RequestMapping("/item3001")
    public List<TItem3001> getItem3001s(){
        return itemService.getTItem3001();
    }

    @RequestMapping("/packageType")
    public List<TBOS200000007> getPageageTypes(){
        return bosService.getPackageTypes();
    }

}
