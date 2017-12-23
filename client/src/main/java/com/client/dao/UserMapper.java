package com.client.dao;

import com.client.entity.User;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liuenxi on 2017/12/12.
 */
public interface UserMapper {

    @Select({"select * from sys_site_user where f_userName = #{userName}"})
    @ResultMap("BaseResultMap")
    User findUserByUserName(String userName);
}
