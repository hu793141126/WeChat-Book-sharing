package com.mibook.top.control;

import com.mibook.top.model.User;
import com.mibook.top.model.UserAchieve;
import com.mibook.top.wx.OauthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信服务端带openid到UserLoginServlet
 * 此处进行用户处理后进入主页
 * 处理流程
 * 《
 * 1.通过微信openid找到用户信息
 * 2.数据查找该openid 若存在则提取该用户信息，若不存在，则存入该用户信息后取出该用户信息
 * 》
 */
@WebServlet(name = "UserLoginServlet", urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String openid = request.getParameter("openid");
        String userid=UserAchieve.isuserexist(openid);
        response.sendRedirect("index.jsp?userid=" + userid);

    }
}
