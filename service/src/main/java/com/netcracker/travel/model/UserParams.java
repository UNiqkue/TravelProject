package com.netcracker.travel.model;

import com.netcracker.travel.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserParams implements UserDetails {

    private Admin admin;

    public Admin getUser() {
        return admin;
    }

    public void setUser(Admin admin) {
        this.admin = admin;
    }

    public UserParams(Admin admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRole = admin.getRole().name();
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole);
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
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
}
