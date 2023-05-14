package com.yangkids.model.service;

import java.util.Random;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public String sendSimpleMessage(String to) throws Exception {
		// 인증코드 생성하기
		String ePw = createKey();

		// 이메일으로 보낼 메세지 준비
		String msgg = "";
		msgg += "<div style='margin:100px;'>";
		msgg += "<h1> 안녕하세요👋 YangKids입니다. </h1>";
		msgg += "<br>";
		msgg += "<p>🌟YangKids에 오신 것을 환영합니다🌟<p>";
		msgg += "<br>";
		msgg += "<p>아래 인증 코드를 회원가입 창으로 돌아가 입력해주세요!<p>";
		msgg += "<br>";
		msgg += "<p>감사합니다💕<p>";
		msgg += "<br>";
		msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
		msgg += "<h3 style='color:#6464FF;'>회원가입 인증 코드입니다.</h3>";
		msgg += "<div style='font-size:130%'>";
		msgg += "CODE : <strong>";
		msgg += ePw + "</strong><div><br/> ";
		msgg += "</div>";

		// 이메일 발신될 데이터 적재
		MimeMessage message = javaMailSender.createMimeMessage();

		message.addRecipients(RecipientType.TO, to); // 보내는 대상
		message.setSubject("YangKids 회원가입 이메일 인증📧"); // 제목
		message.setText(msgg, "utf-8", "html"); // 내용
		message.setFrom(new InternetAddress("ssafy9yangkids@gmail.com", "YangKids"));// 보내는 사람
		
		// 이메일 발신
		javaMailSender.send(message);

		// 인증코드 일치 여부를 비교하기 위해 인증코드 반환
		return ePw;
	}

	public static String createKey() {
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();

		for (int i = 0; i < 8; i++) { // 인증코드 8자리
			int index = rnd.nextInt(3); // 0~2 까지 랜덤

			switch (index) {
			case 0:
				key.append((char) ((int) (rnd.nextInt(26)) + 97));
				// a~z (ex. 1+97=98 => (char)98 = 'b')
				break;
			case 1:
				key.append((char) ((int) (rnd.nextInt(26)) + 65));
				// A~Z
				break;
			case 2:
				key.append((rnd.nextInt(10)));
				// 0~9
				break;
			}
		}

		return key.toString();
	}
}
