package strategy3quiz;

import strategy3quiz.interfaces.GetSalary;
import strategy3quiz.interfaces.JobLec;

public class Lecturer extends Person {

	public String subject;

	public Lecturer(String id, String name, String subject) {
		super(id, name); // person에 있던 2가지 함수는 그대로 이어받음.
		setJob(new JobLec());
		setGet(new GetSalary());
		this.subject = subject;

	}

	@Override
	public void print() {
		super.print();
		System.out.println("[subject]" + subject);
	}

}
