package com.yangkids.model.service;

public interface EmailService {
	String sendSimpleMessage(String to) throws Exception;
	
	String sendNewPw(String to) throws Exception;
}
