package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/operationresult")
public class OperationResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //Integer add =(Integer) req.getAttribute("sum");
    // Integer sub = (Integer) req.getAttribute("sub");

        HttpSession session = req.getSession();
       int sum=(int) session.getAttribute("sum");
        int sub =(int)session.getAttribute("sub");
        int mul =(int)session.getAttribute("mul");
        int div =(int)session.getAttribute("div");

        PrintWriter out = resp.getWriter();
        out.println("Addition:"+sum);
        out.println("Subtraction:"+sub);
        out.println("Mulision:"+mul);
        out.println("Division:"+div);

    }


}
