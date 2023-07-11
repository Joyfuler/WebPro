package strategy3quiz;

import strategy3quiz.interfaces.GetStudentPay;
import strategy3quiz.interfaces.JobStudy;

public class Student extends Person {

	public String ban;

	public Student(String id, String name, String ban) {
		super(id, name); // �����ִ� �������Լ� �μ��ΰ� - �ڽ�Ŭ������ �������Լ� 3����.
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
