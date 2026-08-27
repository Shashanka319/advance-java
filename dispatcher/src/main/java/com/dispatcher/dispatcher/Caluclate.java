package com.dispatcher.dispatcher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/caluclate")
public class Caluclate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 =Integer.parseInt(req.getParameter("FN"));
        int num2 =Integer.parseInt(req.getParameter("SN"));

        int sum =num1+num2;
        int product =num1*num2;

        req.setAttribute("mysum",sum);
        req.setAttribute("myproduct",product);

        RequestDispatcher rd= req.getRequestDispatcher("display");
        rd.forward(req,resp);

    }
}
