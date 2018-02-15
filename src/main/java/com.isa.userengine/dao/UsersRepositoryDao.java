package com.isa.userengine.dao;

import com.isa.userengine.domain.User;

import java.util.List;

public interface UsersRepositoryDao {

    public void addUser (User user);  // zrobione

    public User getUserById(int id); // zrobione

    public User getUserByLogin(String login); // zrobione

    public List<User> getUserList (); // zrobione :D

}
