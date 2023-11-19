package com.example.demo.service;

import java.util.Optional;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public List<User> getALL() {
        return userRepository.getAll();
    }

    public User loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
    public boolean deleteUser(Long ID){
        Optional<User> user = Optional.ofNullable(userRepository.findByID(ID));
        if(user.isPresent()){
            userRepository.deleteByID(ID);
            return true;
        };
        return false;
    }
    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByName(user.getName());

        if (userFromDB != null) {
            return false;
        }

        user.setPassword(BCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

}