package com.mibook.top.model;

import com.google.gson.JsonObject;
import com.mibook.top.wx.WeixinUtil;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Locationhandler {
    public static Address getlocation(String url) {
        Address address = new Address();
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            JSONObject jsonObject = null;
            HttpResponse httpResponse = null;
            httpResponse = client.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                jsonObject = JSONObject.fromObject(result);
            }
            String resultpos = jsonObject.optString("result");
            jsonObject = JSONObject.fromObject(resultpos);
            address.setPosition(jsonObject.getString("formatted_address"));
            String location = jsonObject.optString("location");
            jsonObject = JSONObject.fromObject(location);
            address.setLat(jsonObject.getDouble("lat"));
            address.setLng(jsonObject.getDouble("lng"));
            return address;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

/*
    public static  void main(String args[]){
        String url="http://api.map.baidu.com/geocoder/v2/?ak=nR6QbTKUEKCIwagbSRbGs5kADlzsapjA&output=json&coordtype=gcjo211&location=22.539968,113.954980";
        Address address=Locationhandler.getlocation(url);
        System.out.println(address.getLat()+"\n"+address.getLng()+"\n"+address.getPosition());
    }
    */
}
