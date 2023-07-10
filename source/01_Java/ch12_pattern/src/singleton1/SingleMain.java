package singleton1;

public class SingleMain {
	public static void main(String[] args) {
		Single obj1 = Single.getInstance();
		Single obj2 = Single.getInstance(); // �Ϲ������� ��ü�� new �� ��ŭ �������. �̱�����...?
		obj1.setI(99); 						// Single���� ������� ��ü INSTANCE�� ��ȯ�Ͽ���.
		System.out.println(obj1.getI());    // obj1���� 99�� set�ص� obj2�� ���������� 99 �� ��µ�.
		System.out.println(obj2.getI());
	}
}
