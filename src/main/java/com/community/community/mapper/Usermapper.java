package com.community.community.mapper;

import com.community.community.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Usermapper {
    User querybyId(int id);
    User querybyUserName(String username);
    Boolean signin(String username,String password);
}
