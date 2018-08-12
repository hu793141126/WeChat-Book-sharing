package com.mibook.top.control;
import com.mibook.top.model.Book;
import com.mibook.top.model.Bookisbnhandler;
import com.mibook.top.wx.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AjaxurlServlet")
public class AjaxurlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String str = request.getParameter("isbn");
        String userid=request.getParameter("userid");
        String []str2=str.split(",");
        Book book=Bookisbnhandler.Getbookbyisbn(str2[1]);
        request.setAttribute("book",book);
        request.getRequestDispatcher("scxq.jsp?userid="+userid).forward(request,response);
    }
}
