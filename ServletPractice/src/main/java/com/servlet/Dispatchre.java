package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/caluclate")
public class Dispatchre extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fn= Integer.parseInt(req.getParameter("firstnumber"));
        int sc = Integer.parseInt(req.getParameter("secondnumber"));

        int sum = sc+fn;
        int product = sc*fn;
        int sub = sc-fn;

        PrintWriter out= resp.getWriter();
        out.println("Substraction:"+sub);
        //out.println("Product:"+product);

        req.setAttribute("mysum",sum);
        req.setAttribute("myproduct",product);
        RequestDispatcher rd=req.getRequestDispatcher("result");
        rd.forward(req,resp);
        //rd.include(req,resp);
    }
}
