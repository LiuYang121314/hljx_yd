package com.kingdee.hljx.dao;


import com.kingdee.hljx.entity.ext.TItem3001;
import com.kingdee.hljx.entity.item.TICItem;

import java.util.List;

public interface ItemDao  {
    public List<TItem3001> getTItem3001();

    public List<TICItem> getICItemsByFNumber(String fNumber);
}
