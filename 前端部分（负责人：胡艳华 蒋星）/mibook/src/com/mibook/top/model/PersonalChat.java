package com.mibook.top.model;

public class PersonalChat {		//私聊记录类
	private int UserID1;		//用户1id
	private int UserID2;		//用户2id
	private String ChatInfo;	//聊天内容
	private String ChatTime;	//聊天时间
	private String ImgInfo;		//聊天图片信息
	public int getUserID1() {
		return UserID1;
	}
	public void setUserID1(int userID1) {
		UserID1 = userID1;
	}
	public int getUserID2() {
		return UserID2;
	}
	public void setUserID2(int userID2) {
		UserID2 = userID2;
	}
	public String getChatInfo() {
		return ChatInfo;
	}
	public void setChatInfo(String chatInfo) {
		ChatInfo = chatInfo;
	}
	public String getChatTime() {
		return ChatTime;
	}
	public void setChatTime(String chatTime) {
		ChatTime = chatTime;
	}
	public String getImgInfo() {
		return ImgInfo;
	}
	public void setImgInfo(String imgInfo) {
		ImgInfo = imgInfo;
	}
}
