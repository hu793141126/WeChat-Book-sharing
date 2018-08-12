package com.mibook.top.wx;

import java.util.UUID;

import org.apache.http.ParseException;

import com.mibook.top.wx.WeixinUtil;

import net.sf.json.JSONObject;

import java.util.Map;  
import java.util.HashMap;  
import java.util.Formatter;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.io.IOException;  
import java.net.URLDecoder;  
  
import org.apache.http.HttpResponse;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
  
/** 
 * 官方给的使用js的验证工具
 * https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=jsapisign
 * 
 */  
public class JsSignUtil {
	static Logger logger = Logger.getLogger(JsSignUtil.class.getName());
	
    public static String accessToken = null;
    
    private static final String APPID = "wx550020d77e60b9be";//改为你自己公众号的APPID
	private static final String APPSECRET = "5e5b0e5ab6b3cec7516cdb14a106d5ee";//改为你自己公众号的APPSECRET
      
    public static Map<String, String> sign(String url) {
    	//微信一次性获取
        //accessToken = WeixinUtil.getAccessToken().getToken();
    	accessToken=new Access().saveAccess();

		//微信一次性获取js
        String jsapi_ticket = WeixinUtil.getJsApiTicket(accessToken);
        //String jsapi_ticket=new Jsapi().saveJsap();

        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";
  
        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket + 
                  "&noncestr=" + nonce_str + 
                  "&timestamp=" + timestamp + 
                  "&url=" + url;
        System.out.println("string1="+string1);
        System.out.println("--------------------------");
        
        try{  
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");  
            crypt.reset();  
            crypt.update(string1.getBytes("UTF-8"));  
            signature = byteToHex(crypt.digest());  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        String signature2 = SHA1(string1);
  
        ret.put("url", url);  
        ret.put("jsapi_ticket", jsapi_ticket);  
        ret.put("nonceStr", nonce_str);  
        ret.put("timestamp", timestamp);  
        ret.put("signature", signature2);
        ret.put("appId", APPID);
  
        System.out.println("1.ticket="+jsapi_ticket);
        System.out.println("2.url="+ret.get("url"));  
        System.out.println("3.jsapi_ticket="+ret.get("jsapi_ticket"));
        System.out.println("4.nonceStr="+ret.get("nonceStr"));  
        System.out.println("5.signature="+ret.get("signature"));  
        System.out.println("6.timestamp="+ret.get("timestamp"));  
          
        return ret;
    }
    
    public static String SHA1(String str) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1"); //如果是SHA加密只需要将"SHA-1"改成"SHA"即可
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexStr = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexStr.append(0);
                }
                hexStr.append(shaHex);
            }
            return hexStr.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /** 
     * 随机加密 
     * @param hash 
     * @return 
     */  
    private static String byteToHex(final byte[] hash) {  
        Formatter formatter = new Formatter();  
        for (byte b : hash)  
        {  
            formatter.format("%02x", b);  
        }  
        String result = formatter.toString();  
        formatter.close();  
        return result;  
    }  
  
    /** 
     * 产生随机串--由程序自己随机产生 
     * @return 
     */  
    private static String create_nonce_str() {  
        return UUID.randomUUID().toString();//int noncestr = new Random().nextInt();
    }  
  
    /** 
     * 由程序自己获取当前时间 
     * @return 
     */  
    private static String create_timestamp() {  
        return Long.toString(System.currentTimeMillis() / 1000);  
    }
    
    public static String httpPost(String url){
        DefaultHttpClient httpClient = new DefaultHttpClient();  
        HttpPost method = new HttpPost(url);  
        String str = "";  
        try {  
            HttpResponse result = httpClient.execute(method);  
            url = URLDecoder.decode(url, "UTF-8");  
            /**请求发送成功，并得到响应**/  
            if (result.getStatusLine().getStatusCode() == 200) {  
                try {  
                    /**读取服务器返回过来的json字符串数据**/  
                    str = EntityUtils.toString(result.getEntity());  
                } catch (Exception e) {  
                    System.out.println("post请求提交失败:" + e.getMessage());
                }  
            }  
        } catch (IOException e) {
        	System.out.println("post请求提交失败:" + e.getMessage());
        }  
        return str;
    }
    
    public static String httpGet(String url){
    	String strResult = null;  
        try {  
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);  
            HttpResponse response = client.execute(request);  
   
            /**请求发送成功，并得到响应**/  
            if (response.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {  
                /**读取服务器返回过来的json字符串数据**/  
                  strResult = EntityUtils.toString(response.getEntity());  
            } else {
            	System.out.println("get请求提交失败");
            }  
        } catch (IOException e) {
        	System.out.println("get请求提交失败:" + e.getMessage());
        }  
        return strResult;
    }
    
}
