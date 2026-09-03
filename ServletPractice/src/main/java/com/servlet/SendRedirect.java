package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/operation")
public class SendRedirect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int fn = Integer.parseInt(req.getParameter("firstnumber"));
            int sn = Integer.parseInt(req.getParameter("secondnumber"));

            int sum = fn + sn;
            int sub = sum - fn;
            int mul = sum * sn;
            int div = sum / fn;

            PrintWriter out = resp.getWriter();
            out.println("Multiplication:"+mul);
            out.println("Division:"+div);

            HttpSession session = req.getSession();
            session.setAttribute("sum", sum);
            session.setAttribute("sub", sub);
            session.setAttribute("mul", mul);
            session.setAttribute("div", div);

            resp.sendRedirect("operationresult");



    }
}
