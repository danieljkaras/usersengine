package com.isa.userengine.servlets;

import com.isa.userengine.dao.UserRepositoryDaoBean;
import com.isa.userengine.dao.UsersRepositoryDao;
import com.isa.userengine.domain.User;
import com.isa.usersengine.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao repositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int userId = Integer.parseInt(id);

        User user = repositoryDao.getUserById(userId);


        if (id == null || id.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }


        Map<String, User> dataModel = new HashMap<>();
        dataModel.put(id, user);

        Template template = TemplateProvider.createTemplate(getServletContext(), "find-user-by-id.ftlh");

        PrintWriter printWriter = resp.getWriter();

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e){
            e.getMessage();
        }

        // UsersRepositoryDao repositoryDao = new UserRepositoryDaoBean();


    }
}
