package com.lec.ch18;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired
	private JavaMailSender mailSender;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "join";
	}
	
	@RequestMapping(value = "textMail.do", method = RequestMethod.GET)
	public String textMail(String name, String email, Model model) {
		SimpleMailMessage message = new SimpleMailMessage();
		// message.setFrom(from); -- 적지 않아도 mailsender에서 자동으로 설정
		message.setTo(email);
		message.setSubject("[TEXT] 가입인사 - " + name + "님 회원가입 감사합니다.");
		String content =  name + " 님 회원가입 감사합니다\n <h1>태그안먹음</h1>";
		message.setText(content);
		mailSender.send(message);
		model.addAttribute("mailSendResult", "TEXT메일 발송완료");
		return "sendResult";
	}
	
	@RequestMapping(value = "htmlMail.do", method = RequestMethod.GET)
	public String htmlMail(final String name, final String email, Model model) {
		MimeMessagePreparator message = new MimeMessagePreparator() {			
			String content = 
					"<div style=\"width:500px; margin: 0 auto;\">\n" + 
					"	<h1>"+name+"님의 회원가입 감사합니다.</h1>\n" + 
					"	<div>\n" + 
					"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다</p>\n" + 
					"       <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\" />\n" + 
					"		<hr color=\"red\">\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"		<p style=\"color:blue\">파란 글씨 부분</p>\n" + 
					"		<img src=\"http://localhost:8090/ch18/img/coupon.jpg\">\n" + 
					"	</div>\n" + 
					"	<p>서울시 어떤구 몰라17길 51 어떤빌딩 4층</p>\n" + 
					"</div>";

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				// 수신하는 사람 설정
				mimeMessage.setFrom(new InternetAddress("jpju99@gmail.com"));
				// 발신하는 사람 설정
				mimeMessage.setSubject(name + "님 회원가입 감사합니다!");
				// 제목 설정
				mimeMessage.setText(content, "utf-8", "html");
				// 이메일 내용 설정. 인코딩은 utf-8, html형식으로 전달.				
			}
		}; //message
		mailSender.send(message);
		model.addAttribute("mailSendResult", "html 메일 발송이 완료되었습니다");
		return "sendResult";
		
	}
	
	
	
}
