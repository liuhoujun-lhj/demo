package com.lemon.lemon.Provider;

import com.alibaba.fastjson.JSON;
import com.lemon.lemon.Entity.AccessTokenEntity;
import com.lemon.lemon.Entity.GithubUser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;

/**
  * 功能描述: 创建登录类
  * 作    者: liuhoujun
  * 创建时间: 2019/10/28 15:16
  */

/**
 * 将此类交给Spring容器来管理
 */
@Component
@Slf4j
public class GithubProvider {
    public String getAccesstoken(AccessTokenEntity accessTokenEntity){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenEntity));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            log.error("getAccessToken error,{}", accessTokenEntity, e);
        }
        return null;
    }
    public GithubUser getUser(String  accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (Exception e) {
            log.error("getUser error,{}", accessToken, e);
        }
        return null;
    }
}
