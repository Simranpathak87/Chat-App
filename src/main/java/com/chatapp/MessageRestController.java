package com.chatapp.controller;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.chatapp.entity.ChatMessage;
	import com.chatapp.repository.ChatRepository;
import com.chatapp.service.ChatService;

import java.time.LocalDateTime;
import java.util.List;

	@RestController
	@RequestMapping("/messages")
	public class MessageRestController {

	    @Autowired
	    private ChatRepository repo;
	    
	    @Autowired
	    private ChatService service;
	    
	    
	    @PostMapping
	    public ChatMessage save(@RequestBody ChatMessage msg) {
	    	msg.setTime(LocalDateTime.now());
	        return repo.save(msg);
	    }

	    @GetMapping
	    public List<ChatMessage> getAll() {
	        return repo.findAll();
	    }
	    
	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable Long id) {
	        service.deleteMessage(id);
	        return "Message deleted successfully";
	    }
	}


