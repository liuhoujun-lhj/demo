package com.lemon.lemon.Controller.AutorizeController;

import com.lemon.lemon.Entity.AccessTokenEntity;
import com.lemon.lemon.Entity.GithubUser;
import com.lemon.lemon.Provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright (C) 2014-2016 东华软件股份公司
 * 功能描述: 主页功能登录操作
 * 作    者: liuhoujun
 * 创建时间: 2019/10/28 14:48
 * 修改记录:
 *      <时间>                <作者>        <版本>        <描述>
 *      2019/10/28 14:48        liuhoujun         1.0          初始创建
 *
 */
@Controller
public class AuthorizeController {
    /**
  * 功能描述: 登录
  * 作    者: liuhoujun
  * 创建时间: 2019/10/28 14:48
  */
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String ClientId;
    @Value("${github.client.secret}")
    private String ClientSecret;
    @Value("${github.redirect.uri}")
    private String RedirectURI;

    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenEntity accessTokenEntity = new AccessTokenEntity();
        accessTokenEntity.setClient_id(ClientId);
        accessTokenEntity.setClient_secret(ClientSecret);
        accessTokenEntity.setCode(code);
        accessTokenEntity.setRedirect_uri(RedirectURI);
        accessTokenEntity.setState(state);
        //得到accesstoken
        String accesstoken= githubProvider.getAccesstoken(accessTokenEntity);
        System.out.println(accesstoken);
        GithubUser githubUser = githubProvider.getUser(accesstoken);
        /*if (githubUser != null && githubUser.getId()!=null){
            User
        }*/
        return "index";
    }
}
