package com.mibook.top.control;

import com.mibook.top.model.Book;
import com.mibook.top.model.Bookisbnhandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HandShareServlet", urlPatterns = "/HandShareServlet")
public class HandShareServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn=request.getParameter("handisbn");
        String userid=request.getParameter("userid");
        Book book=Bookisbnhandler.Getbookbyisbn(isbn);
        request.setAttribute("book",book);
        request.getRequestDispatcher("scxq.jsp?userid="+userid).forward(request,response);
    }
}
