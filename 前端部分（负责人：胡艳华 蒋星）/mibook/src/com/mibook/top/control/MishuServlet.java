package com.mibook.top.control;

import com.mibook.top.model.Book;
import com.mibook.top.model.BookAchieve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "MishuServlet", urlPatterns = "/MishuServlet")
public class MishuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        Map<String,ArrayList> bookresources = BookAchieve.getbooksAroundUser(userid);
        request.setAttribute("bookresources",bookresources);
        request.getRequestDispatcher("mishu.jsp?userid="+userid).forward(request,response);
    }
}
