package com.mibook.top.model;

import com.mibook.top.wx.OauthUtil;

import java.sql.*;

public class UserAchieve {
    public static Database data;
    public static Statement stat = null;
    public static ResultSet rst = null;
    public static String sql;
    public static int userid;

   /*测试主类
    public static void main(String args[]){
    System.out.println(getHeadUrlbyid(5));
    }*/
    public static void saveUser(User user) {        //添加用户
        data = new Database();
        if (user.getUserName().equals("")) {
            user.setUserName("未设置昵称");
        }
        if (user.getUserHP().equals("")) {
            user.setUserHP("未上传头像");
        }
        if (user.getUserDate().equals("")) {
            user.setUserDate("未知");
        }
        if (user.getUserSex().equals("")) {
            user.setUserSex("未知");
        }
        if (user.getUserSgin().equals("")) {
            user.setUserSgin("未写个性签名");
        }
        if (user.getUserPhone().equals("")) {
            user.setUserPhone("未手机认证");
        }
        try {
            sql = "insert into user values(null,'" + user.getUserWCID() + "','" + user.getUserName() + "','" + user.getUserHP() + "','" + user.getUserDate() + "','" + user.getUserSex() + "','" + user.getUserSgin() + "','" + user.getUserPhone() + "'," + user.getUserCi() + ",'" + user.getCountry() + "','" + user.getProvince() + "','" + user.getCity() + "');";
            stat = data.con.createStatement();
            stat.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rst = stat.getGeneratedKeys();
            if (rst.next()) {
                userid = rst.getInt(1);
            }
            data.con.close();
            stat.close();
            rst.close();
        } catch (Exception e) {
            System.out.println("插入用户异常");
        }
    }

    //通过openid取出数据库中该用户
    public static User getUserbyopenid(String openid) {
        User user = new User();
        return user;
    }

    public static User getUserbyid(String id) {
        User user = new User();
        data = new Database();
        try {
            sql = "SELECT * FROM user WHERE  UserID=" + id;
            stat = data.con.createStatement();
            rst = stat.executeQuery(sql);
            if (rst.next()) {
                user.setUserID(rst.getInt(1));
                user.setUserWCID(rst.getString(2));
                user.setUserName(rst.getString(3));
                user.setUserHP(rst.getString(4));
                user.setUserDate(rst.getString(5));
                user.setUserSex(rst.getString(6));
                user.setUserSgin(rst.getString(7));
                user.setUserPhone(rst.getString(8));
                user.setUserCi(rst.getInt(9));
                user.setCountry(rst.getString(10));
                user.setProvince(rst.getString(11));
                user.setCity(rst.getString(12));
            }
            data.con.close();
            stat.close();
            rst.close();
            return user;
        } catch (Exception e) {
            System.out.println("查询用户异常");
        }
        return user;
    }

    //判断用户是否存在  若存在返回该用户id若不存则存入后返回该用户id
    public static String isuserexist(String openid) {
        String userid;
        User user;
        data = new Database();
        try {
            sql = "SELECT * FROM user WHERE UserWCID='" + openid + "'";
            stat = data.con.createStatement();
            rst = stat.executeQuery(sql);
            if (rst.next()) {
                //用户存在 取出该用户id

                userid = rst.getInt(1) + "";
                data.con.close();
                stat.close();
                rst.close();
                return userid;
            } else {


                //用户不存在
                user = OauthUtil.getuserinfo(openid);
                saveUser(user);
                data = new Database();
                sql = "SELECT * FROM user WHERE UserWCID='" + openid + "'";
                stat = data.con.createStatement();
                rst = stat.executeQuery(sql);
                if (rst.next()) {
                    userid = rst.getInt(1) + "";
                    data.con.close();
                    stat.close();
                    rst.close();
                    return userid;
                }
            }
        } catch (Exception e) {
            System.out.println("查询数据库异常");
        }
        return null;
    }

    public static String getHeadUrlbyid(int userid){
        String url=null;
        data = new Database();
        try {
            sql = "SELECT UserHP FROM user WHERE UserID="+userid;
            stat = data.con.createStatement();
            rst = stat.executeQuery(sql);
            if (rst.next()){
                url=rst.getString(1);
                data.con.close();
                stat.close();
                rst.close();
                return url;
            }
        }catch (Exception e){

        }
        return url;
    }
}
