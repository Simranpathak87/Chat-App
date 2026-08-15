package com.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.chatapp.dto.UserStatusDto;
import com.chatapp.service.OnlineUserService;

@Controller
public class UserStatusController {

    @Autowired
    private OnlineUserService onlineUserService;

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/join")
    public void join(UserStatusDto dto, SimpMessageHeaderAccessor headerAccessor) {
        onlineUserService.addUser(dto.getUsername());
        headerAccessor.getSessionAttributes().put("username", dto.getUsername());
        template.convertAndSend("/topic/online-users", onlineUserService.getOnlineUsers());
    }

    @MessageMapping("/leave")
    public void leave(UserStatusDto dto) {
        onlineUserService.removeUser(dto.getUsername());
        template.convertAndSend("/topic/online-users", onlineUserService.getOnlineUsers());
    }
}