package com.lec.ex03_point.copy;

public class TestMain {
	public static void main(String[] args) {
		Point point1 = new Point(); // 매개변수 x
		Point point2 = new Point(1, 2); // x,y좌표가 각각 1,2
		point1.infoPrint();
		point2.infoPrint();
		System.out.println("point1과 point2가 같은지 여부: " + point1.equals(point2));
		System.out.println("------------------------------------------");
		// equals는 java.lang에 내장된 기능이므로 굳이 import를 하거나 따로 작성하지 않아도 됨.

		Point3D point3d = new Point3D(10, 20, 30);
		point3d.infoPrint(); // infoPrint를 오버라이드했으므로 infoPrint(); 로 x,y,z 출력이 가능해짐.
		
	} // 디폴트 생성자를 만들지 않았기 때문에 각 변수에 수를 대입한 값으로만 만들수가 있음.
		// point3d.infoprint(); 현재는 super를 배우지 않았으므로...

}
