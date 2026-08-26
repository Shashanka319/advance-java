package com.example.demoproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("WellCome to Servlet");
        String request =req.getParameter("name");
        System.out.println("Welcome "+ request +" to Servlet");

        PrintWriter response = resp.getWriter();
        response.print("Welcome "+ request +" For  Servlet Web Application");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter get = resp.getWriter();
       get.println("Executing the get Method");
       get.println("Welcome "+ req.getParameter("name"));
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter post = resp.getWriter();
        post.println("Executing the post Method");

    }
}
