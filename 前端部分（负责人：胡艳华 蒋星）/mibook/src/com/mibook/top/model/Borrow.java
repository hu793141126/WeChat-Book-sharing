package com.mibook.top.model;

public class Borrow {				//借书记录表
	private int UserID;				//用户id
	private int BookID;				//书id
	private String StartTime;		//开始借阅时间
	private String EndTime;			//结束时间
	private String IsReturn;		//是否归还
	private String BorrowPlace;		//借书地点
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getIsReturn() {
		return IsReturn;
	}
	public void setIsReturn(String isReturn) {
		IsReturn = isReturn;
	}
	public String getBorrowPlace() {
		return BorrowPlace;
	}
	public void setBorrowPlace(String borrowPlace) {
		BorrowPlace = borrowPlace;
	}
}
