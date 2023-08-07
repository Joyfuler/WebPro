package com.lec.ex2person_DtoDao;

import java.util.ArrayList;

// dao들이 잘 작동하는지 test
public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance(); // new가 불가이므로, new를 빼고 getinstance를 가져온다.
		// persondao의 메소드를 불러올 수 있도록 getinstance로 객체를 생성하고, 객체.메소드 형식으로 기능을 불러옴.
		System.out.println("직업명들 : " + dao.jnameList());
		System.out.println("1번기능 insert test");
		PersonDto dto = new PersonDto("홍길동", "개그맨", 80, 79, 90);
		int result = dao.insertPerson(dto); // 제대로 insert됐는지를 확인.
		// System.out.println(result == PersonDao.SUCCESS? "성공":"실패");

		System.out.println("2번기능. 직업별 출력");
		ArrayList<PersonDto> dtos = dao.selectJname("배우"); // persondto 타입으로 하는 arraylist 생성. select jname을 가진 쿼리를 소환하고
															// 매개변수는 배우로.
		if (dtos.isEmpty()) { // 만일 dtos 배열에 값이 없다면
			System.out.println("배우에 해당하는 데이터가 없습니다.");
		} else {
			for (PersonDto personDto : dtos) { // Arraylist의 타입을 맞춘 반복문.
				System.out.println(personDto);
			}
			System.out.println("총" + dtos.size() + "명");
		}
		System.out.println("2번기능. 개그맨출력");
		dtos = dao.selectJname("개그맨");
		if (dtos.size() == 0) {
			System.out.println("개그맨이 없습니다");
		} else {
			for (int idx = 0; idx < dtos.size(); idx++) {
				System.out.println(dtos.get(idx)); // 위 foreach와 동일. 해당 배열 길이만큼 1번/ 2번 / 한줄한줄 출력
			}
		}

		System.out.println("3번기능. 전체출력테스트");
		dtos = dao.selectAll();
		if (dtos.isEmpty()) {
			System.out.println("해당 데이터가 없습니다.");

		} else {
			for (int idx = 0; idx < dtos.size(); idx++) {
				System.out.println(dtos.get(idx)); // 배열 전체를 그대로 출력할때는 확장for문. 몇 줄마다 선을 긋거나 4개씩 정렬이라든가 하고싶다면
				if (idx % 3 == 2) {
					System.out.println("----------------------------------------------------------------------------");
					// 3줄마다 밑줄출력하도록 조정
				}
			}
			System.out.println("총" + dtos.size() + "명");
		}
	}
}
