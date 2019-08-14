package com.kingdee.hljx.service;

import com.kingdee.hljx.dao.SubMessageDao;
import com.kingdee.hljx.entity.submessage.MeasureInType;
import com.kingdee.hljx.entity.submessage.Team;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TSubMessageService {

    @Resource
    private SubMessageDao subMsgDao;

    public List<MeasureInType> getMeasureInType(){
        return subMsgDao.getMeasureInType();
    }

    public List<Team> getTeams(){
        return subMsgDao.getTeams();
    }
}
