package com.lec.ex4_object;

public class Point3D {
	private double x;
	private double y;
	private double z;
	
	public Point3D() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}
	
	public Point3D(double x, double y, double z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "좌표값 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Point3D) {
			Point3D other = (Point3D)obj;
			//boolean xcheck = (x == other.x);
			//boolean ycheck = (y == other.y);
			//boolean zcheck = (z == other.z);
			return x==other.x && y==other.y && z==other.z; // 위 세 줄을 생략하고 한번에도 가능
		}
		return false;
	}
// 만일 각 배열 안의 값들이 같은지를 확인하고 싶다면? - 선생님이 알려주셨음
//	public String test() {
//		if(x==y && y==z) {
//			return "다 같다";
//		}else {
//			return "다 안 같다";
		
	}
	
	
	
	

