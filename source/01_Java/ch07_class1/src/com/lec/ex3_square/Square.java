package com.lec.ex3_square;
 // �Ӽ�����, �ν��Ͻ� ���� �� + ������ + �޼ҵ� + setter(���ʱ�ȭ) getter(��������)
 // ���ο��� Square s = new Square(){ ������ ����ų� --> ������
 // Square s = new Square(1){ ������ ������ �� --> setter getter 

public class Square {
		private int side;
		public Square() { // �Ű������� ���� �� ����Ʈ ������. (Ŭ���� �̸��� �����ϰ� ��������)
			System.out.println("(�Ű� ������ ���� ������ �Լ� ȣ��)");
		}
		public Square (int side) {
		this.side = side; // side��� 1���� �Լ��� ���� �ʱ�ȭ�ϴ� �޼ҵ�
		System.out.println("�Ű������� �ִ� ������ �Լ� ȣ��");
		}
		
		public int area() {
		return side * side; // ���簢���� ���̸� ���ϴ� �޼ҵ� area	
		}
		
		public void setSide (int side) {
			this.side = side;
					
		}
		public int getSide() {
			return side;
		}
			
	
}
