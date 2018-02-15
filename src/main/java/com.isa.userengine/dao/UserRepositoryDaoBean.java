package com.isa.userengine.dao;

import com.isa.userengine.domain.User;
import com.isa.userengine.repository.UsersRepository;

import java.util.List;


public class UserRepositoryDaoBean implements UsersRepositoryDao {

    @Override
    public void addUser(User user) {
        UsersRepository.getRepository();
    }

    @Override
    public User getUserById(int id) {
        for (User user : UsersRepository.getRepository()) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        for (User user : UsersRepository.getRepository()) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUserList() {

        return UsersRepository.getRepository();
    }
}
