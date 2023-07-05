package com.lec.ex03_point.copy;

public class TestMain {
	public static void main(String[] args) {
		Point point1 = new Point(); // �Ű����� x
		Point point2 = new Point(1, 2); // x,y��ǥ�� ���� 1,2
		point1.infoPrint();
		point2.infoPrint();
		System.out.println("point1�� point2�� ������ ����: " + point1.equals(point2));
		System.out.println("------------------------------------------");
		// equals�� java.lang�� ����� ����̹Ƿ� ���� import�� �ϰų� ���� �ۼ����� �ʾƵ� ��.

		Point3D point3d = new Point3D(10, 20, 30);
		point3d.infoPrint(); // infoPrint�� �������̵������Ƿ� infoPrint(); �� x,y,z ����� ��������.
		
	} // ����Ʈ �����ڸ� ������ �ʾұ� ������ �� ������ ���� ������ �����θ� ������� ����.
		// point3d.infoprint(); ����� super�� ����� �ʾ����Ƿ�...

}
