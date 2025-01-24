package com.xiaoming.gpursbackend.service;

import com.xiaoming.gpursbackend.dao.User;
import com.xiaoming.gpursbackend.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public String getUserName(int userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        return user.getName();
    }
}
