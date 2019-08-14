package com.kingdee.hljx.service;

import com.kingdee.hljx.dao.TBOS200000001Dao;
import com.kingdee.hljx.entity.ext.TBOS200000001;
import com.kingdee.hljx.repository.ext.TBOS200000001Entry2Reposition;
import com.kingdee.hljx.repository.ext.TBOS200000001Reposition;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

@Service
public class TBOS200000001Service {
    @Autowired
    private EntityManager em;

    @Resource
    private TBOS200000001Dao bosDao;

    public void addBill(TBOS200000001 bos){
        bosDao.addBill(bos);
    }

}
