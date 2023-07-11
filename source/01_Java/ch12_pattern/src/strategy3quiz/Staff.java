package strategy3quiz;

import strategy3quiz.interfaces.GetSalary;
import strategy3quiz.interfaces.JobMng;

public class Staff extends Person {
	public String part;

	public Staff(String id, String name, String part) { // 생성자 함수 만들기!
		super(id, name); // 슈퍼클래스에 있는 형식을 그대로 사용하면 되므로..
		setJob(new JobMng());
		setGet(new GetSalary());
		this.part = part;

	}
	@Override
	public void print() {
		super.print();
		System.out.println("[part]" + part);

	}

}
