package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.backenddemo.entity.Account;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    @Select("select acc_password from account where acc_name = #{username}")
    String getPasswordByUsername(String username);

    @Select("select acc_profile_photo from account where acc_name = #{username}")
    String getProfilePhotoByUsername(String username);

    @Update("update account set acc_profile_photo = #{profilePhotoName} where acc_name = #{username}")
    void updateProfilePhoto(@Param("username") String username, @Param("profilePhotoName") String profilePhotoName);


}
