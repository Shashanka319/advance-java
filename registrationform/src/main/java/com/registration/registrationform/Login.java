package com.registration.registrationform;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        User user = userDao.getUserByName(name);
        String dbPassword=user.password();

        PrintWriter out = response.getWriter();
       // if(dbPassword.equals(password)){} ---->>>>> perform without encrypt data
        if(user == null){
            out.println("User Not Found");
        }

        try{
            if(dbPassword!= null && BCrypt.checkpw(password,dbPassword)){
                out.println("Login Succussfully WellCome "+user.name());
            }else{
                out.println("Login Failed ,Check password once....");
            }
        }catch(Exception e){
            out.println("Password is mismatch with databse,check once or re-register");
        }

    }
}
