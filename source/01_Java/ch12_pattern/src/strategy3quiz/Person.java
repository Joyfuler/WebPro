package strategy3quiz;

import strategy3quiz.interfaces.GetImpl;
import strategy3quiz.interfaces.JobImpl;

public class Person {

	private JobImpl job;
	private GetImpl get;
	private String id;
	private String name;

	public Person(String id, String name) { // person������ 2���� �ް� 2���� ���. �ڽ�Ŭ�������� 3���� �޴� �����ڸ� ���� ������ָ� ��.
		this.id = id;
		this.name = name;
	}

	public void print() {
		System.out.print("[ID]" + id + "[NAME]" + name);
	}
	
	public void job() {
		job.job();
	}

	public void get() {
		get.get();
	}

	public JobImpl getJob() {
		return job;
	}

	public void setJob(JobImpl job) {
		this.job = job;
	}

	public GetImpl getGet() {
		return get;
	}

	public void setGet(GetImpl get) {
		this.get = get;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
