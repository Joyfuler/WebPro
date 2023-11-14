package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.repository.MemberDao;
import com.lec.ch19.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		int result = memberDao.joinMember(member);		
		if (result == 1) {
	        httpSession.setAttribute("mid", member.getMid());
	        MimeMessagePreparator message = 
	        		new MimeMessagePreparator() {
						String content = "<div style=\"width:500px; margin: 0 auto;\">\n" + 
								"	<h1>"+ member.getMname() +"님의 회원가입 감사합니다.</h1>\n" + 
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
							mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail()));
							mimeMessage.setFrom(new InternetAddress("jpju99@gmail.com"));
							mimeMessage.setSubject(member.getMname()+ "님 회원가입 감사합니다");
							mimeMessage.setText(content, "utf-8", "html");
						}
					};
					mailSender.send(message);
		}
		return result;
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String msg = "";
		Member member = memberDao.getDetailMember(mid);	
		if(member == null) {
			msg = "유효하지 않은 아이디입니다.";		
		} else if (!member.getMpw().equals(mpw)){
			msg = "비밀번호가 일치하지 않습니다.";
		} else {	
			msg = "로그인 되었습니다";
			httpSession.setAttribute("member", member);
		}		
		return msg;
	}

	@Override
	public Member getDetailMember(String mid) {
		return memberDao.getDetailMember(mid);
	}

	@Override
	public int modifyMember(Member member, HttpSession httpSession) {
		int result = memberDao.modifyMember(member);
		if (result ==1) {
			httpSession.setAttribute("member", member);
		}
		return result;
	}
}
