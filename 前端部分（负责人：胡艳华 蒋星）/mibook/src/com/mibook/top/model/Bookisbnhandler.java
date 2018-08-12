package com.mibook.top.model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Bookisbnhandler {
    public static final String DouBan_IsbnApi = "https://api.douban.com/v2/book/isbn";// 获取豆瓣查isbn的url
    public static final String ISBN = "9787302359388";

    //通过Isbn取得一本书的详细信息
    public static Book Getbookbyisbn(String isbn) {
        Book book = new Book();
        String url = String.format(DouBan_IsbnApi + "/:%s", isbn);//格式化url
        System.out.println("doubanapi:" + url);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        JsonParser jsonparer = new JsonParser();
        try {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 响应内容
            HttpEntity entity = res.getEntity();
            responseContent = EntityUtils.toString(entity, "utf-8");
            JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
            // 将json字符串转换为json对象
            System.out.println(json);

            //取除json对象中的书的信息
            System.out.println("nihao");
            //书名
            String content = json.get("title").getAsString();
            if (content != null) {
                book.setBookName(content);
            }
            //作者
            content = json.get("author").getAsString();
            if (content != null) {
                book.setBookAuthor(content);
            }
            //出版社
            content = json.get("publisher").getAsString();
            if (content != null) {
                book.setBookConcern(content);
            }
            //出版时间
            content = json.get("pubdate").getAsString();
            if (content != null) {
                book.setBookData(content);
            }
               /* //价格
                content = json.get("price").getAsString();
                if (content != null) {
                    book.setBookPrice(content);
                }*/
            //图片URL
            content = json.get("image").getAsString();
            if (content != null) {
                book.setBookPicture(content);
            }
            //isbn
            content = json.get("isbn13").getAsString();
            if (content != null) {
                book.setBookisbn(content);
            }
            //内容简介
            content = json.get("summary").getAsString();
            if (content != null) {
                book.setBookAbstract(content);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
            return book;
        }
    }
}
