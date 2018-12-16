package com.netcracker.travel.entity.enumeration;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, GUEST, CUSTOMER, TRAVELAGENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
