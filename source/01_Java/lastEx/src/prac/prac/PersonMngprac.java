package prac.prac;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMngprac {
	public static void main(String[] args) {
		PersonDaoprac daoprac = PersonDaoprac.getInstance();
		ArrayList<String> jobs = daoprac.jnamelist();		
		Scanner scanner = new Scanner(System.in);
		String fn = null;
		
		
		do {
			System.out.println("원하는 기능을 선택하세요. 1:입력 2:직업별출력 3:전체출력");
			fn = scanner.next();
			
		switch (fn) {
		case "1":
			System.out.println("입력할 이름은?");
			String pname = scanner.next();
			System.out.println("입력할 직업명은? : (" + jobs + ")");
			String jname = scanner.next();
			System.out.println("입력할 국어성적은?");
			int kor = scanner.nextInt();
			System.out.println("입력할 영어성적은?");
			int eng = scanner.nextInt();
			System.out.println("입력할 수학성적은?");
			int mat = scanner.nextInt();
			daoprac.insertPerson(new PersonDtoprac(pname,jname,kor,eng,mat));
			break;
			
		case "2": 
			System.out.println("출력을 원하는 직업을 입력하세요. (" + jobs + ")");
			jname = scanner.next();
			ArrayList<PersonDtoprac> dtos = daoprac.selectJname(jname);
			if (dtos.isEmpty()) {
				System.out.println("해당 직업을 가진 사람이 없습니다.");				
			} else {
				for (PersonDtoprac personDtoprac : dtos) {
					System.out.println(personDtoprac);
				}
				System.out.println("총 " + dtos.size() + "명");
			}
			break;
			
		case "3":
			dtos = daoprac.selectAll();
			if (dtos.isEmpty()) {
				System.out.println("데이터가 출력되지 않았습니다.");
			} else {
				for (PersonDtoprac personDtoprac : dtos) {
					System.out.println(personDtoprac);
				}
				System.out.println("총 " + dtos.size() + "명");
			}
			
			break;
		}
		
		
		} while (fn.equals ("1") || fn.equals ("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}
