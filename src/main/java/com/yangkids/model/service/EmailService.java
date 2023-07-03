package com.yangkids.model.service;

import javax.mail.MessagingException;

public interface EmailService {
	String sendSimpleMessage(String to) throws Exception;
	
	String sendNewPw(String to) throws Exception;

	void sendStudentId(String to, String id) throws Exception;
}
