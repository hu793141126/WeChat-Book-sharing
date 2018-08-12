package com.mibook.top.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDate.now;


public class BookAchieve {
    private static Database data;
    private static Statement stat = null;
    private static ResultSet rst = null;
    private static Book book;
    private static int bookid;

    //测试主类
        public static void main(String args[]) {
           // ArrayList<Book> books=getbooksAroundUser("1");
            /*for (Book book:books){
                System.out.println(book.getBookName());
            }*/
            Map<String,ArrayList> bookresources = BookAchieve.getbooksAroundUser("1");
            ArrayList<Book> books=bookresources.get("books");
            ArrayList<String> headurl=bookresources.get("headurl");
            for (int i=0;i<books.size();i++){
                System.out.println(books.get(i).getBookName()+"url"+headurl.get(i));
            }
        }

    public static String saveBook(Book book) {        //添加书籍
        data = new Database();
        String sql;
        if (book.getBookAuthor().equals("")) {
            book.setBookAuthor("未知");
        }
        if (book.getBookTime().equals("")) {
            book.setBookTime("未知");
        }
        if (book.getBookPrice().equals("")) {
            book.setBookPrice("未知");
        }
        if (book.getBookConcern().equals("")) {
            book.setBookConcern("未知");
        }
        if (book.getBookData().equals("")) {
            book.setBookData("未知");
        }
        if (book.getBookisbn().equals("")) {
            book.setBookisbn("未知");
        }
        if (book.getBookPicture().equals("")) {
            book.setBookPicture("未知");
        }
        if (book.getBookAbstract().equals("")) {
            book.setBookAbstract("此书未上传阅读笔记");
        }

        if (book.getBookNote().equals("")) {
            book.setBookNote("此书未上传阅读笔记");
        }
        try {
            sql = "insert into book values(null," + book.getUserID() + ",'" + book.getBookName() + "','" + book.getBookAuthor() + "','" + book.getBookPrice() + "','" + book.getBookConcern() + "','" + book.getBookData() + "','2018'," + book.getBookNumber() + "," + book.getBookD() + ",'" + book.getBookReturn() + "','" + book.getBookisbn() + "','" + book.getBookPicture() + "','" + book.getBookAbstract() + "','" + book.getBookNote() + "'," + book.getBooktype() + ")";
            stat = data.con.createStatement();
            stat.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rst = stat.getGeneratedKeys(); //获取插入的主键
            if (rst.next()) {
                bookid = rst.getInt(1);
            }
            data.con.close();
            stat.close();
            rst.close();
            return "yes";
        } catch (Exception e) {
            System.out.println("数据库插入异常");
            return "no";
        }
    }

    public void saveBookType(BookType book1) {
        data = new Database();
        String sql = "insert into book_type values(" + bookid + "," + book1.getLiterature() + "," + book1.getTextbook() + "," + book1.getNovel() + "," + book1.getHistory() + "," + book1.getLife() + "," + book1.getNature() + "," + book1.getEconomiccontrol() + "," + book1.getMasterpiece() + "," + book1.getScience() + "," + book1.getOthers() + ");";
        try {
            stat = data.con.createStatement();
            stat.executeUpdate(sql);
            data.con.close();
            stat.close();
        } catch (Exception e) {
        }
    }

    public static void select(int id) {
        int i = 0;
        data = new Database();
        String sql = "slect * from book where BookID='" + id + "';";
        try {
            rst = stat.executeQuery(sql);
            while (rst.next()) {
                book.setBookID(rst.getInt("BookID"));
                book.setBookName(rst.getString("BookN"));
                book.setBookConcern(rst.getString("BookConcern"));
                book.setBookData(rst.getString("BookData"));
                book.setBookNumber(rst.getInt("BookNumber"));
                book.setBookPrice(rst.getString("BookPrice"));
                book.setBookPicture(rst.getString("BookPicture"));
                book.setBookD(rst.getInt("BookD"));
                book.setBookisbn(rst.getString("Bookisbn"));
                book.setBookAbstract(rst.getString("BookAbstract"));
                book.setBookNote(rst.getString("BookNote"));
                book.setBookReturn(rst.getString("BookReturn"));
                i++;
            }
            rst.close();
            stat.close();
            data.con.close();
        } catch (Exception ee) {
        }


    }

    public static  Map<String,ArrayList> getbooksAroundUser(String userid){
        ArrayList<Book> books=new ArrayList<Book>();
        ArrayList<String> headurl=new ArrayList<String>();
        Map<String,ArrayList> bookresources=new HashMap<String, ArrayList>();
        data = new Database();
        try {
            String sql="SELECT  * FROM book";
            stat = data.con.createStatement();
            rst=stat.executeQuery(sql);
            while (rst.next()){
                Book book=new Book();
                book.setBookID(rst.getInt(1));
                book.setUserID(rst.getInt(2));
                book.setBookName(rst.getString(3));
                book.setBookAuthor(rst.getString(4));
                book.setBookPrice(rst.getString(5));
                book.setBookConcern(rst.getString(6));
                book.setBookData(rst.getString(7));
                book.setBookTime(rst.getString(8));
                book.setBookNumber(rst.getInt(9));
                book.setBookD(rst.getInt(10));
                book.setBookReturn(rst.getString(11));
                book.setBookisbn(rst.getString(12));
                book.setBookPicture(rst.getString(13));
                book.setBookAbstract(rst.getString(14));
                book.setBookNote(rst.getString(15));
                book.setBooktype(rst.getInt(16));
                books.add(book);
                String url=UserAchieve.getHeadUrlbyid(book.getUserID());
                headurl.add(url);
            }
            bookresources.put("books",books);
            bookresources.put("headurl",headurl);

            return bookresources;
        }catch (Exception e){
            System.out.println("数据库查询书籍异常");
        }
        return  bookresources;
    }

}
