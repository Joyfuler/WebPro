package com.lec.ex11_quiz;

public class Person {
	
	
	private String no;
	private String id;
	private String name;
	private static int count;
	private String info;
	
	
	public Person(String id, String name, String info) {
		this.id = id;
		this.name = name;
		this.info = info;
		
		
	}
	
	public String infoString() {
	return String.format("%d\t %s\t %s\t %s\n", no, id, name); 
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







	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	

}
