package com.singfung.acl.service;

import com.singfung.acl.model.dto.UserDTO;
import com.singfung.acl.model.entity.User;
import com.singfung.acl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User addUser(UserDTO userDTO) {
        String appId = userDTO.getAppId();

        if(userRepository.findByAppId(appId) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "appId already exists");
        }

        User user = new User();
        user.setAppId(appId);
        user.setApiKey(bCryptPasswordEncoder.encode(userDTO.getApiKey()));
        user.setCreateTime(new Date());
        user.setTs(new Date());

        return userRepository.save(user);
    }
}
