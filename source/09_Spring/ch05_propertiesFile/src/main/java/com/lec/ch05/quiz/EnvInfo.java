package com.lec.ch05.quiz;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EnvInfo {
	private String ipNum;
	private String portNum;
	private String userId;
	private String userPw;
}
