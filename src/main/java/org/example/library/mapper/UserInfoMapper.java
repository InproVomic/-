package org.example.library.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.library.module.UserInfo;

@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where delete_flag=#{deleteFlag} and user_name=#{userName}")
    public UserInfo queryUserInfoByUserName(String userName);
}
