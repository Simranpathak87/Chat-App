package com.chatapp.dto;
import jakarta.validation.constraints.NotBlank;

	public class MessageDto {

	    @NotBlank(message = "Sender is required")
	    private String sender;

	    @NotBlank(message = "Receiver is required")
	    private String receiver;

	    @NotBlank(message = "Message cannot be empty")
	    private String message;

	    public String getSender() {
	        return sender;
	    }
	    public void setSender(String sender) {
	        this.sender = sender;
	    }
	    public String getReceiver() {
	        return receiver;
	    }
	    public void setReceiver(String receiver) {
	        this.receiver = receiver;
	    }
	    public String getMessage() {
	        return message;
	    }
	    public void setMessage(String message) {
	        this.message = message;
	    }
	}