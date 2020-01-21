package com.xxy.community.community.provider;

import com.alibaba.fastjson.JSON;
import com.xxy.community.community.dto.AccessTokenDTO;
import com.xxy.community.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName GitHubProvider
 * @Description TOOO
 * @Authot 胡小宇
 * @Date 2019/11/8 14:40
 * @Vrrsion 1.0
 **/
@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
         MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String assessToken=string.split("&")[0].split("=")[1];
            return assessToken;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public GitHubUser getUsert(String accessToken)  {
        OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+accessToken)
                    .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String string =response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
            return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
