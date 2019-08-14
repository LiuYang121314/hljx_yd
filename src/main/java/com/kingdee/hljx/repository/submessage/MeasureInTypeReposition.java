package com.kingdee.hljx.repository.submessage;

import com.kingdee.hljx.entity.submessage.MeasureInType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureInTypeReposition extends JpaRepository<MeasureInType,Integer> {
}
