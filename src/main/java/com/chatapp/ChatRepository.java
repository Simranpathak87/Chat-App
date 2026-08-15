	package com.chatapp.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import com.chatapp.entity.ChatMessage;

	public interface ChatRepository extends JpaRepository<ChatMessage, Long> {
	}


