package com.chatapp.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.dto.MessageDto;
import com.chatapp.entity.ChatMessage;
import com.chatapp.repository.ChatRepository;

@Service
public class ChatService {
		    @Autowired
	    private ChatRepository repo;

	    public ChatMessage save(MessageDto dto) {

	        ChatMessage msg = new ChatMessage();
	        msg.setSender(dto.getSender());
	        msg.setReceiver(dto.getReceiver());
	        msg.setMessage(dto.getMessage());
	        msg.setTime(LocalDateTime.now());

	        return repo.save(msg);
	    }
	        
	        public void deleteMessage(Long id) {
	            repo.deleteById(id);
	        
	    }
	}


