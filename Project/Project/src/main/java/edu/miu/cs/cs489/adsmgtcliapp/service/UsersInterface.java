package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.model.User;

public interface UsersInterface {
    User getUserByUsername(String username);

    User registerNewUser(User user);
}
