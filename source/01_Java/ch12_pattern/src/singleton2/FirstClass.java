package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass ������ ���� ��");
		SingletonClass singletonobj = SingletonClass.getInstance();
		// private�̹Ƿ� new�� �Ұ�. SingletonClass�� �ִ� Instance �޼ҵ带 ��ȸ�ϴ� �������.
		System.out.println("�̱��� ��ü�� i����? = " + singletonobj.getI()); // i�� 10���� �ʱ�ȭ�Ǿ����Ƿ� ����� 10
		singletonobj.setI(99); // i���� 99�� ����. (private�̹Ƿ� set���� ��ȸ)
		System.out.println("�̱��� ��ü i�� ���� �� = " + singletonobj.getI());
		System.out.println("first ������ ���� ��------------------------");
		
	}
}
