package com.community.community.Service;


import com.community.community.mapper.Usermapper;
import com.community.community.pojo.User;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Usermapper usermapper;
    public User querybyId(int id) {
        return usermapper.querybyId(id);
    }
    public User querybyUsername(String username) {
        return usermapper.querybyUserName(username);

    }
    public Boolean sign(String username,String password) {
        return usermapper.signin(username,password);

    }
}
