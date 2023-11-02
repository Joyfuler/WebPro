package com.lec.ch03;

import lombok.Data;

@Data
public class Family {
	private String papaName;
	private String mamiName;
	private String sisterName;
	private String broName;
	
	
	public Family(String papaName, String mamiName) {
		super();
		this.papaName = papaName;
		this.mamiName = mamiName;
	}
	
	
	
}
