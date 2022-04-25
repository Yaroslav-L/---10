package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService/* implements UserDetailsService */{

    private final UserRepo userRepo;


    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findById(Integer id){
        return userRepo.getOne(id);
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public User saveUser(User user){
        user.setRoles(Collections.singleton(Role.USER));
        user.setRole("ROLE_USER");
        user.setActive(true);
        return  userRepo.save(user);
    }

    public void deleteById(Integer id){
        userRepo.deleteById(id);
    }

   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUser_name(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return (UserDetails) user;
    }*/
}
