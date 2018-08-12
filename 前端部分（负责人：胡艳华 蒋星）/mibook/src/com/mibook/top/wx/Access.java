package com.mibook.top.wx;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Access{
	public Database data;
    public static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";// 获取access url                                                                                          
    public static final String APP_ID = "wx550020d77e60b9be";
    public static final String SECRET = "5e5b0e5ab6b3cec7516cdb14a106d5ee";

    // 获取token
    public static String getToken(String apiurl, String appid, String secret)
    {
        String turl = String.format(
                "%s?grant_type=client_credential&appid=%s&secret=%s", apiurl,
                appid, secret);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(turl);
        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
        String result = null;
        try
        {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 响应内容
            HttpEntity entity = res.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            JsonObject json = jsonparer.parse(responseContent)
                    .getAsJsonObject();
            // 将json字符串转换为json对象
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            {
                if (json.get("errcode") != null)
                {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
                }
                else
                {// 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
                    result = json.get("access_token").getAsString();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
            return result;
        }
    }
    
    public int select(){
    	int i=0;
    	data=new Database();
    	String access=null;
    	String sql="select * from access ;";
    	try{    		
    		Statement stat=data.con.createStatement();
    		ResultSet rst=stat.executeQuery(sql);
    		while(rst.next()){
    			access=rst.getString(2);
    		}
    		data.con.close();
    		rst.close();
    		stat.close();
    	}catch(Exception e){
    		System.out.println("数据库连接异常");
		}
    	if(access!=null){
    		//if(access.equals("")){
    			i=1;
    		//}
    	}
    	return i;
    }
    
    public int time(){
    	data=new Database();
    	int y=0;
    	long i=0;
		String sql=new String();
		sql="select * from access;";
		Timestamp value;
		try{  
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String date1 = df1.format(new Date());		
			Date dt1 = df1.parse(date1);		
			Statement stat=data.con.createStatement();
			ResultSet rst=stat.executeQuery(sql);
			while(rst.next()){
				value = rst.getTimestamp(1);
				SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String date2 = df2.format(value);
				Date dt2 = df2.parse(date2);				
				i=(dt1.getTime()-dt2.getTime())/1000;
			}
			data.con.close();
			rst.close();
			stat.close();
		}catch(Exception e){}
		if(i>7000){
			y=1;
			System.out.println("数据库查询秘钥过期");
		}
		return y;
	}
       
    public String saveAccess(){
    	Date now=new Date();
    	if(select()==0){
        	System.out.println("数据库无数据");
        	String accessToken = getToken(GET_TOKEN_URL, APP_ID, SECRET);// 获取token
        	if (accessToken != null)
        		data=new Database();
        		String sql="insert into access values(now(),'"+accessToken+"');";
        		try{
        			Statement stat1=data.con.createStatement();
        			stat1.executeUpdate(sql);
        			stat1.close();
        			data.con.close();
        		}catch(Exception e){}
        		return accessToken;
    		}else{
    			if(time()==1){
    				System.out.println("秘钥过期");
    	        	String accessToken = getToken(GET_TOKEN_URL, APP_ID, SECRET);// 获取token
    	        	if (accessToken != null)
    	        		data=new Database();
    	        		String sql1="delete from access;";
    	        		try{
    	        			Statement stat1=data.con.createStatement();
    	        			stat1.executeUpdate(sql1);
    	        			stat1.close();
    	        			data.con.close();
    	        		}catch(Exception e){}
    	        		String sql="insert into access values(now(),'"+accessToken+"');";
    	        		try{
    	        			Database data1=new Database();
    	        			Statement stat1=data1.con.createStatement();
    	        			stat1.executeUpdate(sql);
    	        			stat1.close();
    	        			data1.con.close();
    	        		}catch(Exception e){}
    	        		return accessToken;
    			}else{
    				System.out.println("秘钥未过期");
    				String accessToken=new String();
    				data=new Database();
    				String sql=new String();
    		    	sql="select * from access;";
    		    	try{    		
    		    		Statement stat=data.con.createStatement();
    		    		ResultSet rst=stat.executeQuery(sql);
    		    		while(rst.next()){
    		    			accessToken=rst.getString("access");
    		    		}
    		    		data.con.close();
    		    		rst.close();
    		    		stat.close();
    		    	}catch(Exception e){}
    		    	return accessToken;
    			}
    		} 	
    }
    
    public static void main(String[] args) throws Exception
    {
    	Access q=new Access();
    	System.out.print(q.saveAccess());
    }
}