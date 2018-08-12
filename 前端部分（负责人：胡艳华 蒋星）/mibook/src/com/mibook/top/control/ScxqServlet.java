package com.mibook.top.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.mibook.top.model.Book;
import com.mibook.top.model.BookAchieve;
import com.mibook.top.model.Bookisbnhandler;
import com.mibook.top.model.User;
import com.mibook.top.wx.OauthUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ScxqServlet", urlPatterns = "/ScxqServlet")
public class ScxqServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取出书籍信息构造书籍对象
        //取得用户微信openid用于获取用户信息
        String userid=request.getParameter("userid");
        //取得用户上传的书籍isbn码和借让性质
        String bookisbn = request.getParameter("bookisbn");
        String booknote=request.getParameter("booknote");
        String bookneed = request.getParameter("need");
        String booknoneed = request.getParameter("noneed");
        int type = 1;//默认种类为1 需要归还 （2 无需归还）
        if (bookneed != null) {
            type = 1;
        } else {
            type = 2;
        }

        //构造书籍对象
        Book book = Bookisbnhandler.Getbookbyisbn(bookisbn);
        book.setBooktype(type);
        if(booknote!=null) {
            book.setBookNote(booknote);
        }
        book.setUserID(Integer.parseInt(userid));
        //将书上传至数据库返回
        String successflag=BookAchieve.saveBook(book);
        //存入书籍
        //bookAchieve.saveBook(book);

        //request.setAttribute("book", book);
         response.sendRedirect("bookshare.jsp?userid="+userid+"&successflag="+successflag);
       // request.getRequestDispatcher("bookshare.jsp?userid="+userid+"&successflag="+successflag).forward(request, response);

    }
}
