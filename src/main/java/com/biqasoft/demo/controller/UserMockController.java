/*
* Copyright (c) 2016 biqasoft.com




 */

package com.biqasoft.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "send_invalid_request", method = RequestMethod.GET)
    public
    @ResponseBody
    UserAccountDTO returnInvalidRequest(HttpServletResponse response) {
       response.setStatus(422);
        return new UserAccountDTO();
    }

    @RequestMapping(value = "simulate_that_server_is_busy_and_can_not_process_current_request", method = RequestMethod.GET)
    public
    @ResponseBody
    UserAccountDTO returnInvalidServerError(HttpServletResponse response) {
        response.setStatus(500);
        return new UserAccountDTO();
    }

    @RequestMapping(value = "authenticate", method = RequestMethod.POST)
    public
    @ResponseBody
    UserAccountDTO returnInvalidServerError(@RequestBody AuthRequest authRequest) {
        UserAccountDTO accountDTO = new UserAccountDTO();
        accountDTO.setFirstname(authRequest.getUsername());
        accountDTO.setLastname(authRequest.getPassword());
        return accountDTO;
    }

    @RequestMapping(value = "echo", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonNode echoServer(@RequestBody JsonNode echo) {
       return echo;
    }

}