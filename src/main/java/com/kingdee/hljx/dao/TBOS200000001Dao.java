package com.kingdee.hljx.dao;

import com.kingdee.hljx.entity.ext.TBOS200000001;
import com.kingdee.hljx.repository.ext.TBOS200000001Reposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

public interface TBOS200000001Dao  {
    public void addBill(TBOS200000001 tbos);
}
