package com.lec.ex03_point;

// x,y는 private로, infoprint(x,y 좌표출력), getset이 든 Point를 상속받았음.
// 메인함수에서는 Point3D p = new Point3D(1,2,3); 으로 할 예정.
public class Point3D extends Point {
	private int z; // 3차원이 될 z좌표를 추가하였음.

	public Point3D(int x, int y, int z) { // 넣더라도 슈퍼클래스에서는 매개변수 없는 것으로 처리되므로 x,y값을 따로 넣어야 함.
		super(x,y);
		System.out.println("매개변수 x,y,z를 초기화하는 Point 3D 생성자");
		 // this.x는 불가능. 왜냐하면 부모클래스에서 private이므로 우회가 필요
		this.z = z;

	}
	// @Override
	// public void infoPrint() {
	// System.out.println("좌표 (x,y,z) :" + getX() + "," + getY() + "," + z); // set한
	// x값을 그대로 가져옴. getX()
	// z는 본 클래스에서 설정했으니 그대로 출력이 가능.

	@Override
	public void infoPrint() {
		System.out.println("좌표 (x,y,z) : " + getX() + ", " + getY() + "," + z);

	}

}
