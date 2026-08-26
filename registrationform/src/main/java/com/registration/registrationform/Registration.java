package com.registration.registrationform;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");

        String encrypt=BCrypt.hashpw(password, BCrypt.gensalt(12));

        User user = new User(name, email, address, encrypt, gender);
        UserDao userDao = new UserDao();
        userDao.save(user);

        PrintWriter out = resp.getWriter();
        out.println("Registration Successful");
    }
}
