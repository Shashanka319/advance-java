package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class Result extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sum = (int) request.getAttribute("mysum");
        int mul = (int) request.getAttribute("myproduct");

        PrintWriter out = response.getWriter();
        out.println("Sum: "+sum);
        out.println("Product: "+mul);
    }
}
