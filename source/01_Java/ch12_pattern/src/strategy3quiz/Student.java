package strategy3quiz;

import strategy3quiz.interfaces.GetStudentPay;
import strategy3quiz.interfaces.JobStudy;

public class Student extends Person {

	public String ban;

	public Student(String id, String name, String ban) {
		super(id, name); // 위에있던 생성자함수 인수인계 - 자식클래스는 생성자함수 3개로.
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());

	}

	@Override
	public void print() {
		super.print();
		System.out.println("[ban]" + ban);
	}

}
