package com.mindlink.forum.services.serviceImpl;

import com.mindlink.forum.models.user.User;
import com.mindlink.forum.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String[] parts = username.split(" ");
        if (parts.length < 2) {
            throw new UsernameNotFoundException("Invalid username format");
        }

        Optional<User> user = userRepository.findByFirstNameAndLastName(parts[0], parts[1]);
        return user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
