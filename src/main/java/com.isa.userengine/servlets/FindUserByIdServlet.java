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


@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");


        if (id == null || id.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        int userId = Integer.parseInt(id);

        UsersRepositoryDao repositoryDao = new UserRepositoryDaoBean();
        PrintWriter printWriter = resp.getWriter();
        String userData = null;

        userData = repositoryDao.getUserById(userId).getName() + " " + repositoryDao.getUserById(userId).getAge();

        printWriter.write(userData);

    }
}
