package com.isa.userengine.servlets;

import com.isa.userengine.domain.User;
import com.isa.userengine.repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printerWriter = resp.getWriter();
        printerWriter.write("Hello World from my first Servlet!" + "\n");
        printerWriter.write("Happy After Valentine Day :D ");


        for (User user : UsersRepository.getRepository()) {
            printerWriter.write(user.getId());
            printerWriter.write(user.getName());
            printerWriter.println(user.getId() + " " + user.getName());
        }

    }
}
