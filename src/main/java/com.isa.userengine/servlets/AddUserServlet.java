package com.isa.userengine.servlets;

import com.isa.userengine.dao.UserRepositoryDaoBean;
import com.isa.userengine.dao.UsersRepositoryDao;
import com.isa.userengine.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();

        String ID = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");

        UsersRepositoryDao newUser = new UserRepositoryDaoBean();

        user.setId(Integer.parseInt(ID));
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setAge(Integer.parseInt(age));

        newUser.addUser(user);









    }
}
