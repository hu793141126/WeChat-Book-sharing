package com.mibook.top.control;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mibook.top.model.Address;
import com.mibook.top.model.Locationhandler;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LocationServlet", urlPatterns = "/LocationServlet")
public class LocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String lat = request.getParameter("lat");
        String lng = request.getParameter("lng");
        String userid = request.getParameter("userid");
        String url = "http://api.map.baidu.com/geocoder/v2/?ak=nR6QbTKUEKCIwagbSRbGs5kADlzsapjA&output=json&coordtype=gcjo211&location="+lat+","+lng;
        Address address=Locationhandler.getlocation(url);
        request.getRequestDispatcher("index.jsp?userid="+userid+"&address="+address.getPosition()).forward(request,response);
    }
}
