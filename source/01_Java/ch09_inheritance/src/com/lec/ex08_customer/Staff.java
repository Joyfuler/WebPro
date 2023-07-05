package com.lec.ex08_customer;
// person에 name, tel, infostring이 존재. 
// 직원 데이터라면? 입사일..
public class Staff extends Person {
	private String hiredate; // 입사일 ("2020-12-01") 등으로.. 차후 date로 입력
	private String department; // 부서명. 회계부, 영업부...
	// Staff s = new Staff("홍사원", "9999-9999", "2023-01-01", "물류" 등으로 입력할 예정. 앞에껀 부모클래스에!)
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}
	@Override
	public String infoString() {
		return super.infoString() + "[입사일] " + hiredate + "[부서]" + department; 
		//공통점은 person에 모아서 infostring을 활용하엿음.
	}

}
