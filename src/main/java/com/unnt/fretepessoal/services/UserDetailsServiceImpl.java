package com.unnt.fretepessoal.services;

import com.unnt.fretepessoal.model.User;
import com.unnt.fretepessoal.repository.UserRepository;
import com.unnt.fretepessoal.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getProfiles());
    }

}