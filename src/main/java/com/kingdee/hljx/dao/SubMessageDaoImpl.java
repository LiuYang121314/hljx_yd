package com.kingdee.hljx.dao;

import com.kingdee.hljx.entity.submessage.MeasureInType;
import com.kingdee.hljx.entity.submessage.Team;
import com.kingdee.hljx.repository.submessage.MeasureInTypeReposition;
import com.kingdee.hljx.repository.submessage.TeamReposition;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SubMessageDaoImpl implements SubMessageDao {
    @Resource
    private MeasureInTypeReposition measureReposition;
    @Resource
    private TeamReposition tempReposition;

    @Override
    public List<MeasureInType> getMeasureInType() {
        return measureReposition.findAll();
    }

    @Override
    public List<Team> getTeams() {
        return tempReposition.findAll();
    }

}
