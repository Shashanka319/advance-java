package com.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name= req.getParameter("name");
       String password = req.getParameter("password");

       Cookie cookie = new Cookie("name",name);
       Cookie cookie2 = new Cookie("password",password);
       resp.addCookie(cookie);
       resp.addCookie(cookie2);
        System.out.println("Cookies added");

        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            System.out.println("Fetches the cookies from clint browser"+c.getName()+" "+c.getValue());
        }
       PrintWriter out= resp.getWriter();
       out.print("Login Succussfully ");
       out.print("Wellcome to Project "+name+" Your password is:"+password);
    }
}
