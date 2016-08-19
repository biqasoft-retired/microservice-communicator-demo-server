/*
 * Copyright 2016 the original author or authors.
 */

package com.biqasoft.demo.controller;

/**
 * @author Nikita Bakaev, ya@nbakaev.ru
 *         Date: 7/31/2016
 *         All Rights Reserved
 */
public class AuthRequest {

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
