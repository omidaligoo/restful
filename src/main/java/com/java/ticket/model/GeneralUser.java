package com.java.ticket.model;

import com.java.ticket.basic.model.GeneralDomain;

import javax.persistence.*;

import com.java.ticket.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralUser extends com.java.ticket.basic.model.GeneralDomain implements Serializable, UserDetails {


    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    private Role role;

    @ManyToMany
    private List<Issue> issuesList;

    public enum Role {
        USER, SUPPORT, ADMIN, TESTER
    }

    private Boolean enabled = true;


    @ManyToMany
    private List<Roles> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (roles != null && !roles.isEmpty()) {
            for (Roles roles : roles)
                authorities.addAll(roles.getAuthorities());
        } else {
            authorities.add(Authority.OP_ACCESS_USER);
        }
        return authorities;
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
        return enabled;
    }

}

