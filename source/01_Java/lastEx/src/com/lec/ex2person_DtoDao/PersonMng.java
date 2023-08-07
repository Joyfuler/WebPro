package com.lec.ex2person_DtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn; // 유저입력번호
		ArrayList<String> jobs = dao.jnameList(); // 직업리스트 출력하는 PersonDao클래스타입의 배열
		
		do {
			System.out.print("1:입력, 2:직업별출력, 3:전체출력, 기타입력:종료");
			fn = scanner.next();
			
			switch (fn) {
			case "1": // 사용자로부터 이름,직업명,국,영,수 입력받아 insertPerson호출
				System.out.println("입력할 이름은?");
				String pname = scanner.next();
				System.out.println("입력할 직업이름은? : (" + jobs + ")");
				String jname = scanner.next();
				System.out.println("입력할 국어성적은?");
				int kor = scanner.nextInt();
				System.out.println("입력할 영어성적은?");
				int eng = scanner.nextInt();
				System.out.println("입력할 수학성적은?");
				int mat = scanner.nextInt();								
			dao.insertPerson(new PersonDto(pname,jname,kor,eng,mat)); // insertperson 할 시 꼭 타입주의! new PersonDto				
			break;			
			case "2": System.out.println("2번 기능");
				System.out.println("출력을 원하는 직업을 입력하세요. : (" + jobs + ")");
				jname = scanner.next();
				ArrayList<PersonDto> dtos = dao.selectJname(jname); // 해당 직업이름 가진사람들 출력하는 sql 메소드. 출력은 arraylist
				if (dtos.isEmpty()) {
					System.out.println(jname +" 직업을 가진 사람이 없습니다.");
				} else {
					for (PersonDto dto : dtos) {
						System.out.println(dto);						
					}				
				}
			break;						
			case "3":
			dtos = dao.selectAll();
			if (dtos.isEmpty()) {
				System.out.println("출력할 데이터가 없습니다.");
			} else {
				for (int idx = 0; idx<dtos.size(); idx++) {
					System.out.println(dtos.get(idx)); // arraylist배열이므로 [idx]가 아닌, get(idx)를 사용하여 출력함.					
				}
				System.out.println("총" + dtos.size() + "명");
			}
			break;
			}			
		} while(fn.equals("1")||fn.equals("2")||fn.equals("3")); // 1,2,3이면 반복, 다른키면 종료
		System.out.println("BYE");
			
		
	}
}
