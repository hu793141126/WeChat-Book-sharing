package com.mibook.top.wx;

import com.mibook.top.model.Book;
import com.mibook.top.model.User;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 微信网页授权获取用户信息
 * 此处通过微信snsapi_base获取用户基本信息，跳过用户授权操作，通过得到用户OPENID获取用户信息
 * （微信未授权的用户信息较为简单，但跳过了授权界面，便捷方便）
 */
public class OauthUtil {

    //微信信息
    private String APPID = "wx550020d77e60b9be";//自己公众号的APPID
    private String APPSECRET = "5e5b0e5ab6b3cec7516cdb14a106d5ee";//自己公众号的APPSECRET
    //获取网页授权的Accesstoken URL
    public String Oauth_AccesssTokenURl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    //第一步：用code换取accesstoken和用户openid （getopenid(code)）
    public String getopenid(String code) {
        System.out.println(code);
        String openid = null;
        String url = String.format(Oauth_AccesssTokenURl, APPID, APPSECRET, code);//格式化url
        System.out.println(url);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        JsonParser jsonparer = new JsonParser();
        try {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 响应内容
            HttpEntity entity = res.getEntity();
            responseContent = EntityUtils.toString(entity, "utf-8");
            JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
            //取除json对象中的用户的信息
            //书名
            if (json.get("openid").getAsString() != null) {
                openid = json.get("openid").getAsString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
            System.out.println(openid);
            return openid;
        }
    }

    public static User getuserinfo(String openid) {
        User user = new User();
        String accessToken;
        //测试使用的一次性秘钥
        // accessToken = WeixinUtil.getAccessToken().getToken();
        accessToken=new Access().saveAccess();
        String infourl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
        String url = String.format(infourl, accessToken, openid);//格式化url
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        JsonParser jsonparer = new JsonParser();
        try {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 响应内容
            HttpEntity entity = res.getEntity();
            responseContent = EntityUtils.toString(entity, "utf-8");
            JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
            //取除json对象中的用户的信息

            //微信openid
            String content = json.get("openid").getAsString();
            if (content != null) {
                user.setUserWCID(content);
            }
            //用户昵称
            content = json.get("nickname").getAsString();
            if (content != null) {
                user.setUserName(content);
            }
            //用户性别
            content = json.get("sex").getAsString();
            if (content != null) {
                if ("1".equals(content)) {
                    user.setUserSex("男");
                } else if ("2".equals(content)) {
                    user.setUserSex("女");
                }
            }
            //用户头像
            content = json.get("headimgurl").getAsString();
            if (content != null) {
                user.setUserHP(content);
            }
            //微信地址 国家 省份 城市
            content = json.get("country").getAsString();
            if (content != null) {
                user.setCountry(content);
            }
            content = json.get("province").getAsString();
            if (content != null) {
                user.setProvince(content);
            }
            content = json.get("city").getAsString();
            if (content != null) {
                user.setCity(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
            return user;
        }

    }

    //通过code取得一本书的详细信息
    public static User getUserInfobyCode(String code) {
        /**
         * 第一步：用code换取accesstoken和用户openid （getopenid(code)）
         * 第二步，用openid换取用户信息并解析          (getuserinfo(openid))
         * */
        User user;
        OauthUtil oauthUtil = new OauthUtil();
        String openid = oauthUtil.getopenid(code);
        System.out.println(openid);
        user = oauthUtil.getuserinfo(openid);
        return user;
    }
/*测试主方法
    public static void main(String args[]){
       // User user=getUserInfobyCode("021FfL7s1GjvYm0SDs9s1PCV7s1FfL7K");
        OauthUtil oauthUtil=new OauthUtil();
        String id=oauthUtil.getopenid("001Vz81k1vc70m03XQ1k1I031k1Vz81-");
        System.out.println(id);
    }*/
}
