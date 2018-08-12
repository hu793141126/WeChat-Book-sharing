package com.mibook.top.model;

public class BookRing {				//书圈类
	private int RingID;				//书圈ID
	private int RingOwerID;			//圈主id
	private String RingName;		// 书圈名称
	private String RingNature;		//书圈性质
	private int RingX;				//书圈位置(x int y int 
	private int RingY;
	private String RingAbstract;	//书圈简介
	
	public int getRingID() {
		return RingID;
	}
	public void setRingID(int ringID) {
		RingID = ringID;
	}
	public int getRingOwerID() {
		return RingOwerID;
	}
	public void setRingOwerID(int ringOwerID) {
		RingOwerID = ringOwerID;
	}
	public String getRingName() {
		return RingName;
	}
	public void setRingName(String ringName) {
		RingName = ringName;
	}
	public String getRingNature() {
		return RingNature;
	}
	public void setRingNature(String ringNature) {
		RingNature = ringNature;
	}
	public int getRingX() {
		return RingX;
	}
	public void setRingX(int ringX) {
		RingX = ringX;
	}
	public int getRingY() {
		return RingY;
	}
	public void setRingY(int ringY) {
		RingY = ringY;
	}
	public String getRingAbstract() {
		return RingAbstract;
	}
	public void setRingAbstract(String ringAbstract) {
		RingAbstract = ringAbstract;
	}
	
}
