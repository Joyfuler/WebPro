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
				// System.out.println(i + "번째 xyz와 " + (i+1) + "번째 xyz 좌표 비교: " +
				// (xyz[i].equals(xyz[i+1])));
				System.out.println(i + "번째와" + j + "번째 좌표 비교: " + xyz[i].equals(xyz[j]));
			}
		}

		// System.out.println("xyz6의 각 배열속 값을 비교하는 방법 : " + xyz4.test());

	}

}
