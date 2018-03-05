package com.isa.userengine.servlets;

import com.isa.userengine.dao.UserRepositoryDaoBean;
import com.isa.userengine.dao.UsersRepositoryDao;
import com.isa.userengine.domain.Gender;
import com.isa.userengine.domain.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {

    @Inject
    UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();

        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setName(req.getParameter("name"));
        user.setLogin(req.getParameter("login"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setGender(Gender.valueOf(req.getParameter("gender")));


        String ID = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");

//        UsersRepositoryDao newUser = new UserRepositoryDaoBean();

//        user.setId(Integer.parseInt(ID));
//        user.setName(name);
//        user.setLogin(login);
//        user.setPassword(password);
//        user.setAge(Integer.parseInt(age));
//        user.setGender(Gender.valueOf(gender));
        usersRepositoryDao.addUser(user);


    }
}
