package com.mibook.top.model;

public class Book {                        //书籍类
    private int BookID;                    //书籍ID
    private int UserID;                    //上传ID
    private String BookName;            //书名
    private String BookAuthor = "未知";    //作者
    private String BookPrice = "未知";        //价格
    private String BookConcern = "未知";    //出版社
    private String BookData = "未知";        //出版时间
    private String BookTime = "未知";        //上传时间
    private int BookNumber = 1;            //数量
    private int BookD = 0;                //被借阅次数
    private String BookReturn = "否";        //是否借出
    private String Bookisbn = "未知";        //isbn码
    private String BookPicture = "未知";   //书籍图片名称URL
    private String BookAbstract = "此书未上传阅读笔记";    //内容简介
    private int Booktype = 1;            //借让性质 默认种类为1 需要归还 （2 无需归还）
    private String BookNote = "此书未上传阅读笔记";    //阅读笔记（推荐理由)

    public int getBooktype() {
        return Booktype;
    }

    public void setBooktype(int booktype) {
        Booktype = booktype;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        BookAuthor = bookAuthor;
    }

    public String getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(String bookPrice) {
        BookPrice = bookPrice;
    }

    public String getBookConcern() {
        return BookConcern;
    }

    public void setBookConcern(String bookConcern) {
        BookConcern = bookConcern;
    }

    public String getBookData() {
        return BookData;
    }

    public void setBookData(String bookData) {
        BookData = bookData;
    }

    public int getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(int bookNumber) {
        BookNumber = bookNumber;
    }

    public int getBookD() {
        return BookD;
    }

    public void setBookD(int bookD) {
        BookD = bookD;
    }

    public String getBookReturn() {
        return BookReturn;
    }

    public void setBookReturn(String bookReturn) {
        BookReturn = bookReturn;
    }

    public String getBookisbn() {
        return Bookisbn;
    }

    public void setBookisbn(String bookisbn) {
        Bookisbn = bookisbn;
    }

    public String getBookPicture() {
        return BookPicture;
    }

    public void setBookPicture(String bookPicture) {
        BookPicture = bookPicture;
    }

    public String getBookAbstract() {
        return BookAbstract;
    }

    public void setBookAbstract(String bookAbstract) {
        BookAbstract = bookAbstract;
    }

    public String getBookNote() {
        return BookNote;
    }

    public void setBookNote(String bookNote) {
        BookNote = bookNote;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getBookTime() {
        return BookTime;
    }

    public void setBookTime(String bookTime) {
        BookTime = bookTime;
    }
}
