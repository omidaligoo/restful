package com.java.ticket.enums;

import org.springframework.security.core.GrantedAuthority;

    public enum UserRoles implements GrantedAuthority {

        USER,SUPPORT,ADMIN,TESTER;

        @Override
        public String getAuthority() {
            return this.name();
        }
    }