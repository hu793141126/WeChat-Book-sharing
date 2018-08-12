package com.mibook.top.model;

public class Business {			//商家类
	private int BusID;			//商家Id
	private String BusName;		//商家名称
	private String BusPlace;	//商家地点
	private String BusSide;		// 商家留言
	private String BusPicture;	//商家图片
	
	public int getBusID() {
		return BusID;
	}
	public void setBusID(int busID) {
		BusID = busID;
	}
	public String getBusName() {
		return BusName;
	}
	public void setBusName(String busName) {
		BusName = busName;
	}
	public String getBusPlace() {
		return BusPlace;
	}
	public void setBusPlace(String busPlace) {
		BusPlace = busPlace;
	}
	public String getBusSide() {
		return BusSide;
	}
	public void setBusSide(String busSide) {
		BusSide = busSide;
	}
	public String getBusPicture() {
		return BusPicture;
	}
	public void setBusPicture(String busPicture) {
		BusPicture = busPicture;
	}
	
}
