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
		msgg += "인증 코드 : <strong>";
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
	
	@Override
	public String sendNewPw(String to) throws Exception {
		// 새로운 임시 비밀번호 생성하기
		String newPw = getTempPassword();
		
		// 이메일으로 보낼 메세지 준비
		String msgg = "";
		msgg += "<div style='margin:100px;'>";
		msgg += "<h1> 안녕하세요👋 YangKids입니다. </h1>";
		msgg += "<br>";
		msgg += "<p>로그인을 위한 임시 비밀번호가 새로 발급되었습니다.<p>";
		msgg += "<br>";
		msgg += "<p>아래 비밀번호를 이용해 로그인해주세요.<p>";
		msgg += "<br>";
		msgg += "<p>로그인 후에 마이페이지에서 비밀번호를 수정할 수 있습니다.<p>";
		msgg += "<br>";
		msgg += "<p>감사합니다💕<p>";
		msgg += "<br>";
		msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
		msgg += "<h3 style='color:#6464FF;'>'YangKids' 임시 비밀번호입니다.</h3>";
		msgg += "<div style='font-size:130%'>";
		msgg += "비밀번호 : <strong>";
		msgg += newPw + "</strong><div><br/> ";
		msgg += "</div>";

		// 이메일 발신될 데이터 적재
		MimeMessage message = javaMailSender.createMimeMessage();

		message.addRecipients(RecipientType.TO, to); // 보내는 대상
		message.setSubject("'YangKids' 비밀번호 찾기📧"); // 제목
		message.setText(msgg, "utf-8", "html"); // 내용
		message.setFrom(new InternetAddress("ssafy9yangkids@gmail.com", "YangKids"));// 보내는 사람

		// 이메일 발신
		javaMailSender.send(message);

		// 비밀번호 저장을 위해 반환
		return newPw;
	}

	// 랜덤함수로 임시비밀번호 구문 만들기
	public String getTempPassword() {
		char[] charSet1 = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] charSet2 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char[] charSet3 = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		char[] charSet4 = new char[] { '~', '․', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '=',
				'[', ']', '[', ']', '|', '\\', ';', ':', '‘', '“', '<', '>', ',', '.', '?', '/' };

		StringBuffer sb = new StringBuffer();

		// 문자 랜덤으로 10개 뽑아서 임시 비밀번호 구성하기
		int idx = 0;
		// 숫자에서 3개
		for (int i = 0; i < 3; i++) {
			idx = (int) (charSet1.length * Math.random());
			sb.append(charSet1[idx]);
		}
		// 영어 대문자에서 3개
		for (int i = 0; i < 3; i++) {
			idx = (int) (charSet2.length * Math.random());
			sb.append(charSet2[idx]);
		}
		// 영어 소문자에서 3개
		for (int i = 0; i < 3; i++) {
			idx = (int) (charSet3.length * Math.random());
			sb.append(charSet3[idx]);
		}
		// 특수문자에서 1개
		for (int i = 0; i < 1; i++) {
			idx = (int) (charSet4.length * Math.random());
			sb.append(charSet4[idx]);
		}
		return sb.toString();
	}
}
