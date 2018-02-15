package com.isa.userengine;

import com.isa.userengine.dao.UserRepositoryDaoBean;
import com.isa.userengine.dao.UsersRepositoryDao;
import com.isa.userengine.domain.User;

public class Main {

    public static void main (String [] args){

        UsersRepositoryDao daoBean = new UserRepositoryDaoBean();

        for (User user : daoBean.getUserList() ){
            System.out.println("Name is: " + user.getName());
        }
    }
}
