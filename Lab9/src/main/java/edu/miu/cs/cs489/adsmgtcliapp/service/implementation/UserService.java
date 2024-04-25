package edu.miu.cs.cs489.adsmgtcliapp.service.implementation;

import edu.miu.cs.cs489.adsmgtcliapp.model.User;
import edu.miu.cs.cs489.adsmgtcliapp.repository.UserRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.UsersInterface;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UsersInterface {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElse(null);
    }

    @Override
    public User registerNewUser(User user) {
        return userRepository.save(user);
    }
}
