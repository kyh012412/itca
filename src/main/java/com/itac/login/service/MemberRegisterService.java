package com.itac.login.service;


import com.itac.login.entity.user.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class MemberRegisterService {

    private final UserRepository userRepository;


    public int registerMember(String username,String password,String auth)  {
        return userRepository.registerUser(username,password,auth);

    }

}