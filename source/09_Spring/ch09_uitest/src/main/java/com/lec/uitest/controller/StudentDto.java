package com.lec.uitest.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int total;
	private double avg;
}
