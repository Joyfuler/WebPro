package strategy3quiz;

import strategy3quiz.interfaces.GetSalary;
import strategy3quiz.interfaces.JobMng;

public class Staff extends Person {
	public String part;

	public Staff(String id, String name, String part) { // ������ �Լ� �����!
		super(id, name); // ����Ŭ������ �ִ� ������ �״�� ����ϸ� �ǹǷ�..
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
