package com.community.community.Provider;

import com.alibaba.fastjson.JSON;
import com.community.community.DTO.AccessTokenDTO;
import com.community.community.DTO.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Component
@Slf4j
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().toString();


            String token = string.split("&")[0].split("=")[1];
            System.out.println("内容是"+string);
            System.out.println("内容是"+token);
            return token;
        } catch (Exception e) {
            log.error("getAccessToken error,{}", accessTokenDTO, e);
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string =response.body().string();
            GithubUser githubUser=JSON.parseObject(string,GithubUser.class);

            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
