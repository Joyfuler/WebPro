package com.lec.ex11_account;

public class Account {
	// 은행계좌 (account) 클래스 설계
	// 데이터 (속성) : 계좌번호, 예금주, 잔액
	// 메소드: 예금하다, 인출하다 + 계좌 정보 출력. 계좌 정보를 문자열로 return *

	private String accountNo; // 통장번호는 - 도 있고, 맨 앞이 0으로 시작하는 경우 날아가므로 String으로 써줄것.
	private String ownerName; // 통장주명
	private int balance; // 잔액

	public Account(String accountNo, String ownerName) { // 잔액없이 개설하는 경우의 Account 메소드
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		// 잔액은 기본값인 0 (balance = 0);
		System.out.println(ownerName + "님 계좌 개설 감사합니다. 남은 잔액은 " + balance);
		// 혹은 source --> ~ field로 생성
	}

	public Account(String accountNo, String ownerName, int balance) { // 잔액넣으면서 개설하는 경우의 Account 메소드
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName + "님 계좌 개설 진심으로 감사합니다. 잔액은 : " + balance);
	}

	public void deposite(int money) { // 입금시
		balance += money; // balance = balance + money; 돈 예금하면 잔액이 늘어난다는 것.
		System.out.println(accountNo + ":" + money + "원 예금하여, 잔액은 :" + balance);
		System.out.printf("%s : %d 원 예금하여, 잔액은 %d\n", accountNo, money, balance);

	}

	public void withdraw(int money) { // 잔액이 있을 경우에만 인출이 가능. 잔액 부족시 떼끼 출력
		if (money <= balance) {
			balance -= money;
			System.out.println(ownerName + "님, " + money + "원을 출금하여, 잔액은 " + balance + "입니다.");
		} else {
			System.out.println(ownerName + "님, 잔액이 부족하여 출금할 수 없습니다.");
			// 나중에는 강제 예외가 발생하는 것을 배울 예정...
		}

	}

	public void infoPrint() { // "101-1234", 홍길동님 잔액 : 1000원 식으로 출력을 원함)
		System.out.println("\"" + accountNo + "\"" + ownerName + "님 잔액: " + balance + " 원");
		System.out.printf("\" %s \"%s님 잔액 : %d 원", accountNo, ownerName, balance);
	}

	public String infoString() { // "101-1234", 홍길동님 잔액 : 1000원 데이터가 return됨. (String이므로 return값 필요)
		// return "\"" + accountNo + "\"" + ownerName + "님 잔액: " + balance + " 원";
		return String.format("\" %s \" %s님 잔액 : %d 원", accountNo, ownerName, balance);
		// 내가 string을 만들고자 하는 format을 지정.

		// 위의 sysout과 동일한 문장을 리턴시켜줌. 이후 메인메소드에서 sout (hong) 하는 경우 위와 같이 출력됨.
	}
	// getter & setter 추가. 단 잔액을 함부로 변조하지 않기 위해 balance는 set에서 제외. 계좌번호도 변경될 일이 없으니
	// username만 set

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}

// new Account("110-98", "홍길동");
// 돈도 넣어야 한다면 new Account ("110-98", "홍길동", 200000) 등으로 생성가능.
// 통장번호 110-98, 통장주명 홍길동
