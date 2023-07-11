package strategy3quiz;

import strategy3quiz.interfaces.GetSalary;
import strategy3quiz.interfaces.JobLec;

public class Lecturer extends Person {

	public String subject;

	public Lecturer(String id, String name, String subject) {
		super(id, name); // person�� �ִ� 2���� �Լ��� �״�� �̾����.
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
