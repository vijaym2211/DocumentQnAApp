package org.example.user_check.services;


import org.example.user_check.Exception.UserAlreadyPresent;
import org.example.user_check.Exception.UserNotPresent;
import org.example.user_check.model.User;
import org.example.user_check.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

    private UserRepository userRepository;
    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String name, String email, String password, String role) throws UserAlreadyPresent {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new UserAlreadyPresent("User already present");
        }

        User dbuser = new User();
        dbuser.setEmail(email);
        dbuser.setName(name);
        dbuser.setPassword(bcryptPasswordEncoder.encode(password));

        // Ensure the role is stored as uppercase (e.g., "ADMIN")
        dbuser.setRoles(Arrays.asList(role.toUpperCase()));
        return userRepository.save(dbuser);
    }

    public Page<User> getAllList(int pageSize, int pageNum){
        Page<User> users = userRepository.findAll(PageRequest.of(pageNum,pageSize));
        return users;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(String currentEmail, String name, String newEmail, String password) throws UserNotPresent {
        Optional<User> dbuser = userRepository.findByEmail(currentEmail);
        if(dbuser.isEmpty()){
            throw new UserNotPresent("User not present");
        }
        User user = dbuser.get();
        dbuser.get().setEmail(newEmail);
        dbuser.get().setName(name);
        dbuser.get().setPassword(bcryptPasswordEncoder.encode(password));
        return userRepository.save(dbuser.get());
    }
}
