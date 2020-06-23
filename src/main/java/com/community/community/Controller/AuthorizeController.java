package com.community.community.Controller;

import com.community.community.DTO.AccessTokenDTO;
import com.community.community.DTO.GithubUser;
import com.community.community.Provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String setRedirecturi;
    @GetMapping("/callback")
    public String callback(@RequestParam(name ="code") String code,
                           @RequestParam(name ="state") String state,
                            HttpServletRequest request
                            ){
        AccessTokenDTO accessTokenDTO =new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("github.redirect.uri");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("github.client.id");
        accessTokenDTO.setClient_secret("github.client.secret");

        String accessToken =githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user =githubProvider.getUser(accessToken);
        if(user != null){
            //登陆成功 写入cookies 和session
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else {
            return "redirect:/";
        }
        //System.out.println(user.getId());
    }
}
