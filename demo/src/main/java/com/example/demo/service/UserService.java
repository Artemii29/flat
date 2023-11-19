package com.example.demo.service;
import org.springframework.context.annotation.Bean;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.ArrayList;
import org.springframework.context.annotation.Configuration;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenUtil tokenUtil;

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByName(user.getName());

        if (userFromDB != null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public String loginUser(String username, String password) {
        User user = userRepository.findByName(username);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return tokenUtil.generateToken(username);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());

    }
}