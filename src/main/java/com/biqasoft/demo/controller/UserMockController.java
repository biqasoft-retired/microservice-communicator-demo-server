/*
* Copyright (c) 2016 biqasoft.com




 */

package com.biqasoft.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/domain/users/mock")
public class UserMockController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserAccountDTO> mockGetAllUsers() {
        List<UserAccountDTO> userAccounts = new ArrayList<>();
        userAccounts.add(new UserAccountDTO());
        userAccounts.add(new UserAccountDTO());
        userAccounts.add(new UserAccountDTO());
        userAccounts.add(new UserAccountDTO());
        return userAccounts;
    }

    @RequestMapping("one")
    public UserAccountDTO mockOneUser() {
        return new UserAccountDTO();
    }

    @RequestMapping("null")
    public UserAccountDTO returnNull() {
        return null;
    }

    @RequestMapping("send_invalid_request")
    public UserAccountDTO returnInvalidRequest(HttpServletResponse response) {
        response.setStatus(422);
        return new UserAccountDTO();
    }

    @RequestMapping("simulate_that_server_is_busy_and_can_not_process_current_request")
    public UserAccountDTO returnInvalidServerError(HttpServletResponse response) {
        response.setStatus(500);
        return new UserAccountDTO();
    }

    @RequestMapping("generate_500_http_error")
    public UserAccountDTO returnInvalidServerErrorShort(HttpServletResponse response) {
        response.setStatus(500);
        return new UserAccountDTO();
    }

    @RequestMapping(value = "authenticate", method = RequestMethod.POST)
    public UserAccountDTO returnInvalidServerError(@RequestBody AuthRequest authRequest) {
        UserAccountDTO accountDTO = new UserAccountDTO();
        accountDTO.setFirstname(authRequest.getUsername());
        accountDTO.setLastname(authRequest.getPassword());
        return accountDTO;
    }

    @RequestMapping(value = "echo", method = RequestMethod.POST)
    public JsonNode echoServer(@RequestBody JsonNode echo) {
        return echo;
    }

}