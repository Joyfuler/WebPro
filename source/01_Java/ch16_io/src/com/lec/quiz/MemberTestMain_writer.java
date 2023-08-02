package com.lec.quiz;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;


// Writer는 2바이트이므로 String. 따라서 byte배열로 바꿔주는 getbytes() 를 넣지 않고 그냥 tostring()만 해도 출력이 가능함.
public class MemberTestMain_writer {
	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String name, tel, address, date;
		Date birthday;
		Writer writer = null;
		while (true) {
			System.out.println("회원 가입을 진행하겠습니까? (Y/N) - N 입력시 회원 리스트를 출력합니다 : ");
			String answer = scanner.nextLine().trim();
			if (answer.equalsIgnoreCase("n"))
				break;
			if (answer.equalsIgnoreCase("y"))
				System.out.println("당신의 이름을 입력해주세요. : ");
			else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요");
				continue;
			}
			name = scanner.nextLine();
			System.out.println("당신의 전화번호를 입력해주세요. : ");
			tel = scanner.nextLine().trim();
			System.out.println("당신의 주소를 입력해주세요 : ");
			address = scanner.nextLine();
			System.out.println("당신의 생년월일을 입력해주세요 : (형식은 (1995-12-20))");
			date = scanner.nextLine();
			birthday = birthChk(name, date);
			list.add(new Member(name, tel, address, birthday));
		}
		try {
			writer = new FileWriter("D:/WebPro/source/01_Java/ch16_io/src/com/lec/quiz/Member_writer.txt");
			for (Member member : list) {
				System.out.println(member);
				writer.write(member.toString());
			}
			String msg = "\t\t\t\t .. 이하" + list.size() + " 명 가입";
			System.out.print(msg);
			writer.write(msg.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}

	private static Date birthChk(String name, String date) { // 매개변수로 들어온 날짜 스트링을 Date형으로 변환하고, 오늘이 생일인 지 확인한 후 return.
		Date result = null; // date가 null일 최악의 상황을 가정해 return. void 함수가 아니라면 반드시 null을 미리 초기화한 후 return해주자.
		StringTokenizer tokenizer = new StringTokenizer(date, "-");
		if (tokenizer.countTokens() == 3) {
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day = Integer.parseInt(tokenizer.nextToken());
			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			if (sdf.format(new Date()).equals(sdf.format(result))) {
				System.out.println(name + " 님, 생일을 축하드립니다!");
			} else {
				System.out.println("오늘은 생일이 아니시네요.");
			} 
		}
		return result;
	}
}
