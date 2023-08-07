package com.lec.ex2person_DtoDao;
// 필요재료 --> 1번기능 insert때 : 이름,직업명, 국, 영, 수
// 2,3번기능 : select - rank, 이름, 직업명, 국, 영, 수, 합계
public class PersonDto {
	private int rank;
	private String pname;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	
	// 입력용 : 이름, 직업명, 국, 영, 수로 입력하였음.
	
	public PersonDto(String pname, String jname, int kor, int eng, int mat) {		
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}		
	// 출력용: rank, 이름(홍길동(2)), 직업명, 국, 영, 수, 합
		
	public PersonDto(int rank, String pname, String jname, int kor, int eng, int mat, int sum) {		
		this.rank = rank;
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
	}

	@Override
	public String toString() {
		if (pname.length()>6) {
		return rank + "등\t" + pname + "\t" +jname + "\t" + kor + "\t" + eng
				+"\t" + mat + "\t" + sum;
		} else {
			return rank + "등\t" + pname + "\t\t" +jname + "\t" + kor + "\t" + eng
					+"\t" + mat + "\t" + sum;
		}
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
	
}
