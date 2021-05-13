package com.example.lab11.services;

import com.example.lab11.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lab11.repository.UserRepository;

import java.util.List;

/**
 * <h3> Clasa UserService </h3>
 * <p> Se creaza functii cu ajutorul metodelor din interfata UserRepository pentru cerintele din enunt. </p>
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User changeName(short id, String nume) {
        User user = userRepository.getUserByIdUser(id);
        user.setName(nume);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(short id) {
        User user = userRepository.getUserByIdUser(id);
        userRepository.deleteUserByIdUser(user.getIdUser());
    }
}
