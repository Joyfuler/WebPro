package com.lec.ex4_object;



public class Point3DMain {
	public static void main(String[] args) {
		Point3D[] xyz = { new Point3D(), new Point3D(0, 0, 1), new Point3D(1, 2, 3), new Point3D(2, 3, 0),
				new Point3D(3, 3, 3), new Point3D(3, 3, 3) };
		for (Point3D point3d : xyz) {
			System.out.println(point3d);
		}

		int i, j;

		for (i = 0; i < xyz.length - 1; i++) {
			for (j = i + 1; j < xyz.length; j++) {
				// System.out.println(i + "��° xyz�� " + (i+1) + "��° xyz ��ǥ ��: " +
				// (xyz[i].equals(xyz[i+1])));
				System.out.println(i + "��°��" + j + "��° ��ǥ ��: " + xyz[i].equals(xyz[j]));
			}
		}

		// System.out.println("xyz6�� �� �迭�� ���� ���ϴ� ��� : " + xyz4.test());

	}

}
