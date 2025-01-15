package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.backenddemo.entity.BdAccount;

@Mapper
public interface BdAccountMapper extends BaseMapper<BdAccount> {
    BdAccount getAccountByPk(@Param("pk_account") String pk_account);

}
