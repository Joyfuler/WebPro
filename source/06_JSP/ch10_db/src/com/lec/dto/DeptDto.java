package com.lec.dto;

public class DeptDto {
	private int detpno;
	private String dname;
	private String loc;
	// varchar는 string으로.
	
	public DeptDto() {
		
	}
	public DeptDto(int detpno, String dname, String loc) {		
		this.detpno = detpno;
		this.dname = dname;
		this.loc = loc;
	}
	public int getDetpno() {
		return detpno;
	}
	public void setDetpno(int detpno) {
		this.detpno = detpno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "DeptDto [detpno=" + detpno + ", dname=" + dname + ", loc=" + loc + "]";
	}	
}
