package com.spring.pneu.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class AuthenticationResponse {
    private int id;
    private String jwt;
    private String username;
    private Collection roles;
    public AuthenticationResponse(String jwt, String username,Collection<?> roles)
    {
        this.jwt=jwt;
        this.username=username;
        this.roles=roles;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Collection getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }


}
