package com.softserve.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class WebAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private long id;

    public WebAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, long id) {
        super(principal, credentials, authorities);
        this.id = id;
    }

    public WebAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
