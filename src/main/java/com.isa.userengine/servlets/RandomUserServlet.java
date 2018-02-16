package com.isa.userengine.servlets;

import com.isa.userengine.cdi.RandomUserCDIApplicationDao;
import com.isa.userengine.cdi.RandomUserCDIRequestDao;
import com.isa.userengine.cdi.RandomUserCDISessionDao;
import com.isa.userengine.domain.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random-user")
public class RandomUserServlet extends HttpServlet {

    @Inject
    RandomUserCDIRequestDao randomUserCDIRequestDao;

    @Inject
    RandomUserCDISessionDao randomUserCDISessionDao;

    @Inject
    RandomUserCDIApplicationDao randomUserCDIApplicationDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();

        User userFromRequest = randomUserCDIRequestDao.getRandomUser();
        printWriter.write("Random User by request scoped: \n");
        printWriter.write("\n");
        printWriter.write("ID: " + userFromRequest.getId() + "\n");


        User userFromSession = randomUserCDISessionDao.getRandomUser();
        printWriter.write("Random User by session scoped: \n");
        printWriter.write("\n");
        printWriter.write("ID: " + userFromSession.getId() + "\n");

        User userFromApplication = randomUserCDIApplicationDao.getRandomUser();
        printWriter.write("Random User by application scoped: \n");
        printWriter.write("\n");
        printWriter.write("ID: " + userFromApplication.getId() + "\n");


    }
}
