package com.lec.ex03_point;

// x,y�� private��, infoprint(x,y ��ǥ���), getset�� �� Point�� ��ӹ޾���.
// �����Լ������� Point3D p = new Point3D(1,2,3); ���� �� ����.
public class Point3D extends Point {
	private int z; // 3������ �� z��ǥ�� �߰��Ͽ���.

	public Point3D(int x, int y, int z) { // �ִ��� ����Ŭ���������� �Ű����� ���� ������ ó���ǹǷ� x,y���� ���� �־�� ��.
		super(x,y);
		System.out.println("�Ű����� x,y,z�� �ʱ�ȭ�ϴ� Point 3D ������");
		 // this.x�� �Ұ���. �ֳ��ϸ� �θ�Ŭ�������� private�̹Ƿ� ��ȸ�� �ʿ�
		this.z = z;

	}
	// @Override
	// public void infoPrint() {
	// System.out.println("��ǥ (x,y,z) :" + getX() + "," + getY() + "," + z); // set��
	// x���� �״�� ������. getX()
	// z�� �� Ŭ�������� ���������� �״�� ����� ����.

	@Override
	public void infoPrint() {
		System.out.println("��ǥ (x,y,z) : " + getX() + ", " + getY() + "," + z);

	}

}
