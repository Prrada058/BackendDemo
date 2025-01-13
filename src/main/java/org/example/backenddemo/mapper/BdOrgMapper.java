package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.backenddemo.entity.BdOrg;

import java.util.List;
import java.util.Map;

@Mapper
public interface BdOrgMapper extends BaseMapper<BdOrg> {
    List<org.example.backenddemo.dto.BdOrg> getOrgWithCur(@Param("pk_org") String pk_org);
}
