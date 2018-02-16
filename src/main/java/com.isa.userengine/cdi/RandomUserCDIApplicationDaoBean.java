package com.isa.userengine.cdi;

import com.isa.userengine.dao.UsersRepositoryDao;
import com.isa.userengine.domain.User;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;


@ApplicationScoped

public class RandomUserCDIApplicationDaoBean implements RandomUserCDIApplicationDao, Serializable {


    int index = Math.abs(new Random().nextInt()) % 3;

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Override
    public User getRandomUser() {

        return usersRepositoryDao.getUserList().get(index);
    }
}
