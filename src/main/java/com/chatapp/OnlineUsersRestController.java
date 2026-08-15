package com.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.service.OnlineUserService;

import java.util.Set;

@RestController
public class OnlineUsersRestController {

    @Autowired
    private OnlineUserService onlineUserService;

    @GetMapping("/online-users")
    public Set<String> getOnlineUsers() {
        return onlineUserService.getOnlineUsers();
    }
}