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
		return "��ǥ�� [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Point3D) {
			Point3D other = (Point3D)obj;
			//boolean xcheck = (x == other.x);
			//boolean ycheck = (y == other.y);
			//boolean zcheck = (z == other.z);
			return x==other.x && y==other.y && z==other.z; // �� �� ���� �����ϰ� �ѹ����� ����
		}
		return false;
	}
// ���� �� �迭 ���� ������ �������� Ȯ���ϰ� �ʹٸ�? - �������� �˷��ּ���
//	public String test() {
//		if(x==y && y==z) {
//			return "�� ����";
//		}else {
//			return "�� �� ����";
		
	}
	
	
	
	

