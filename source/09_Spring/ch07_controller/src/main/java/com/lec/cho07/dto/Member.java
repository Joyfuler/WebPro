package com.lec.cho07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Member {
	private String id;
	private String pw;
	@Override
	public String toString() {
		return "회원 [아이디=" + id + ", 비번=" + pw + "]";
	}
	
}
