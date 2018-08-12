package com.mibook.top.model;

public class BookType {			//书籍类型类
	private int BookID;			//书籍ID
	private int Literature;		//文学类
	private int Textbook;		//教材
	private int Novel;			//小说
	private int History;		//历史
	private int Life;			//生活
	private int Nature;			//自然
	private int Economiccontrol;//经管
	private int Masterpiece;	//名著
	private int Science;		//科技
	private int Others;			//其他
	
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public int getLiterature() {
		return Literature;
	}
	public void setLiterature(int literature) {
		Literature = literature;
	}
	public int getTextbook() {
		return Textbook;
	}
	public void setTextbook(int textbook) {
		Textbook = textbook;
	}
	public int getNovel() {
		return Novel;
	}
	public void setNovel(int novel) {
		Novel = novel;
	}
	public int getHistory() {
		return History;
	}
	public void setHistory(int history) {
		History = history;
	}
	public int getLife() {
		return Life;
	}
	public void setLife(int life) {
		Life = life;
	}
	public int getNature() {
		return Nature;
	}
	public void setNature(int nature) {
		Nature = nature;
	}
	public int getEconomiccontrol() {
		return Economiccontrol;
	}
	public void setEconomiccontrol(int economiccontrol) {
		Economiccontrol = economiccontrol;
	}
	public int getMasterpiece() {
		return Masterpiece;
	}
	public void setMasterpiece(int masterpiece) {
		Masterpiece = masterpiece;
	}
	public int getScience() {
		return Science;
	}
	public void setScience(int science) {
		Science = science;
	}
	public int getOthers() {
		return Others;
	}
	public void setOthers(int others) {
		Others = others;
	}
	
}
