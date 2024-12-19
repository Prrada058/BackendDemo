package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.backenddemo.entity.Account;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    @Select("select acc_password from account where acc_name = #{username}")
    String getPasswordByUsername(String username);
}
