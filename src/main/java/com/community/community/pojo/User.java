package com.community.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
//序列化为了redis用
public class User implements Serializable {
    private int id;
    String username;
    String password;

}
