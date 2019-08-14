package com.kingdee.hljx.service;

import com.kingdee.hljx.dao.BOSDao;
import com.kingdee.hljx.entity.ext.TBOS200000007;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BOSService  {
    @Resource
    private BOSDao bosDao;

    public List<TBOS200000007> getPackageTypes(){
        return bosDao.findPackageTypes();
    }
}
