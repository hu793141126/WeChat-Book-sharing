package com.mibook.top.model;

public class User {                //用户类
    private int UserID;            //ID（主键
    private String UserWCID;        //用户WeChatiD
    private String UserName = "未设置昵称";    //昵称
    private String UserHP = "未上传头像";        // 头像
    private String UserDate = "未知";    //生日
    private String UserSex = "未知";        //性别
    private String UserSgin = "未写个性签名";    //个性签名
    private String UserPhone = "未手机认证";    // 手机认证
    private int UserCi = 100;            // 诚信值
    private String country, province, city;    //微信位置
    private int lat;       //位置获取的经度
    private int lng;        //位置获取的纬度

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserWCID() {
        return UserWCID;
    }

    public void setUserWCID(String userWCID) {
        UserWCID = userWCID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserHP() {
        return UserHP;
    }

    public void setUserHP(String userHP) {
        UserHP = userHP;
    }

    public String getUserDate() {
        return UserDate;
    }

    public void setUserDate(String userDate) {
        UserDate = userDate;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    public String getUserSgin() {
        return UserSgin;
    }

    public void setUserSgin(String userSgin) {
        UserSgin = userSgin;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public int getUserCi() {
        return UserCi;
    }

    public void setUserCi(int userCi) {
        UserCi = userCi;
    }

}
