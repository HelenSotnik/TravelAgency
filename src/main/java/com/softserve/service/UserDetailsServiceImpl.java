package com.softserve.service;

import com.softserve.model.User;
import com.softserve.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
    private long id;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User dbUser = userRepository.findUserByEmail(username);
        if (dbUser == null) {
            return null;
        }

        setId(dbUser.getId());

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {

                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
                grantedAuthorityList.add(new SimpleGrantedAuthority(dbUser.getRole().getAuthority()));
                return grantedAuthorityList;
            }

            @Override
            public String getPassword() {
                return dbUser.getPassword();
            }

            @Override
            public String getUsername() {
                return dbUser.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}