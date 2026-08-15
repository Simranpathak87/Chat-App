package com.chatapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import com.chatapp.dto.MessageDto;
import com.chatapp.entity.ChatMessage;
import com.chatapp.service.ChatService;

	@Controller
	public class ChatController {

	    @Autowired
	    private ChatService service;

	    @Autowired
	    private SimpMessagingTemplate template;

	    @MessageMapping("/send")
	    public void sendMessage(MessageDto dto) {

	        ChatMessage saved = service.save(dto);

	        template.convertAndSend("/topic/messages", saved);
	    }
	}


