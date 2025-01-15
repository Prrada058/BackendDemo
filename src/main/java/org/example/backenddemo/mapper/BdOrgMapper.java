package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.backenddemo.dto.BdOrgFull;
import org.example.backenddemo.entity.BdOrg;

import java.util.List;

@Mapper
public interface BdOrgMapper extends BaseMapper<BdOrg> {
    List<BdOrgFull> getOrgWithCur(@Param("pk_org") String pk_org);

    BdOrg getOrgByPk(@Param("pk_org") String pk_org);
}
