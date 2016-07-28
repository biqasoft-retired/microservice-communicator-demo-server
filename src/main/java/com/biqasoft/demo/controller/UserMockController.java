/*
* Copyright (c) 2016 biqasoft.com




 */

package com.biqasoft.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Just for demo
 *
 * @author Nikita Bakaev, ya@nbakaev.ru
 *         Date: 10/5/2015
 *         All Rights Reserved
 */
@Controller
@RequestMapping("/domain/users/mock")
public class UserMockController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<UserAccountDTO> mockGetAllUsers(HttpServletResponse response) {
        List<UserAccountDTO> userAccounts = new ArrayList<>();
        userAccounts.add(new  UserAccountDTO());
        userAccounts.add(new UserAccountDTO());
        userAccounts.add(new UserAccountDTO());
        userAccounts.add(new UserAccountDTO());
        return userAccounts;
    }

    @RequestMapping(value = "one", method = RequestMethod.GET)
    public
    @ResponseBody
    UserAccountDTO mockOneUser(HttpServletResponse response) {
        return new UserAccountDTO();
    }


    @RequestMapping(value = "null", method = RequestMethod.GET)
    public
    @ResponseBody
    UserAccountDTO returnNull(HttpServletResponse response) {
        return null;
    }

}