package com.mibook.top.wx;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Jsapi {
	public Database data;
	   public String getJSApiTicket(){ //获取jsapi_ticket
	    	String acess_token= new Access().saveAccess();
	    	 String turl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+acess_token+"&type=jsapi";  
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
	             result = json.get("ticket").getAsString();
	             //System.out.println("=="+result);
	         }
	         catch (Exception e){}
	        	 return result;		         
	    }
	   
	   public int select(){//判断数据库是否有值
	    	int i=1;
	    	data=new Database();
	    	String jsap=null;
	    	String sql=new String();
	    	sql="select * from jsap;";
	    	try{    		
	    		Statement stat=data.con.createStatement();
	    		ResultSet rst=stat.executeQuery(sql);
	    		while(rst.next()){
	    			jsap=rst.getString(2);
	    		}
	    		data.con.close();
	    		rst.close();
	    		stat.close();
	    	}catch(Exception e){}
	    	if(jsap!=null){
	    			i=0;
	    	}
	    	return i;
	    }
	    
	   public int time(){//判断ticket是否过期
	    	data=new Database();
	    	int y=0;
	    	long i=0;
			String sql=new String();
			sql="select * from access;";
			Timestamp value;
			try{  
				SimpleDateFormat df1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//规定时间格式
				String date1 = df1.format(new Date());	//将时间转换成字符串	
				Date dt1 = df1.parse(date1);		//将字符串转换成时间
				Statement stat=data.con.createStatement();
				ResultSet rst=stat.executeQuery(sql);
				while(rst.next()){
					value = rst.getTimestamp(1);
					SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//规定时间格式
					String date2 = df2.format(value);//将时间转换成字符串	
					Date dt2 = df2.parse(date2);		//将字符串转换成时间		
					i=(dt1.getTime()-dt2.getTime())/1000;//时间格式要一致方能比较
				}
				data.con.close();
				rst.close();
				stat.close();
			}catch(Exception e){}
			if(i>7000){
				y=1;
			}
			return y;
		}
	       
	    public String saveJsap(){//存储ticket并返回其值
	    	Date now=new Date();
	    	if(select()==1){
	        	System.out.println("=========1获取token=========");
	        	String jsap = getJSApiTicket();// 获取token
	        	if (jsap != null)
	        		data=new Database();
	        		String sql="insert into jsap values(now(),'"+jsap+"');";
	        		try{
	        			Statement stat1=data.con.createStatement();
	        			stat1.executeUpdate(sql);
	        			stat1.close();
	        			data.con.close();
	        		}catch(Exception e){}
	        		return jsap;

	    		}else{
	    			if(time()==1){
	    				System.out.println("=========j过期========");
	    	        	String jsap = getJSApiTicket();// 获取token
	    	        	if (jsap != null)
	    	        		data=new Database();
	    	        		String sql1="delete from jsap;";
	    	        		try{
	    	        			Statement stat1=data.con.createStatement();
	    	        			stat1.executeUpdate(sql1);
	    	        			stat1.close();
	    	        			data.con.close();
	    	        		}catch(Exception e){}
	    	        		String sql="insert into jsap values(now(),'"+jsap+"');";
	    	        		try{
	    	        			Database data1=new Database();
	    	        			Statement stat1=data1.con.createStatement();
	    	        			stat1.executeUpdate(sql);
	    	        			stat1.close();
	    	        			data1.con.close();
	    	        		}catch(Exception e){}
	    	        		return jsap;
	    			}else{
						System.out.println("j未过期");
	    				String jsap=new String();
	    				data=new Database();
	    				String sql=new String();
	    		    	sql="select * from jsap;";
	    		    	try{    		
	    		    		Statement stat=data.con.createStatement();
	    		    		ResultSet rst=stat.executeQuery(sql);
	    		    		while(rst.next()){
	    		    			jsap=rst.getString(2);
	    		    		}
	    		    		data.con.close();
	    		    		rst.close();
	    		    		stat.close();
	    		    	}catch(Exception e){}
	    		    	return jsap;
	    			}
	    		} 	
	    }
	   	/*
	     public static void main(String[] args) {
	    	 Jsapi n=new Jsapi();	       
	        System.out.println("调用微信jsapi的凭证票为："+n.saveJsap());

	   }*/
	}


