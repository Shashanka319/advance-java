package com.dispatcher.dispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/display")
public class Display extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sum =(int) req.getAttribute("mysum");
        int product =(int) req.getAttribute("myproduct");

        PrintWriter out = resp.getWriter();
        out.println("Sum: "+sum);
        out.println("Product: "+product);
    }
}
