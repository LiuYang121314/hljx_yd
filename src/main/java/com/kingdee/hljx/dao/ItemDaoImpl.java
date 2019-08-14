package com.kingdee.hljx.dao;

import com.kingdee.hljx.entity.ext.TItem3001;
import com.kingdee.hljx.entity.item.TICItem;
import com.kingdee.hljx.entity.item.TICItem_;
import com.kingdee.hljx.repository.ext.TItem3001Reposition;
import com.kingdee.hljx.repository.item.TEmpReposition;
import com.kingdee.hljx.repository.item.TICItemReposition;
import com.kingdee.hljx.repository.item.TItemReposition;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Resource
    private TICItemReposition ticItemReposition;
    @Resource
    private TEmpReposition tEmpReposition;
    @Autowired
    private EntityManager em;
    @Resource
    private TItemReposition tItemReposition;
    @Resource
    private TItem3001Reposition item3001Reposition;

    @Override
    public List<TItem3001> getTItem3001() {
        return item3001Reposition.findAll();
    }

    public List<TICItem> getICItemsByFNumber(String fNumber){
        Query query = em.createQuery("SELECT ic FROM TICItem ic WHERE ic.fNumber like ?0 or ic.fName like ?0 or ic.fHelpCode like ?0 or ic.fModel like ?0");
        query.setParameter(0, "%"+fNumber+"%");
        return query.getResultList();
    }
}
