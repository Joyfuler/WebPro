package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstobj = new FirstClass();
		SecondClass secondobj = new SecondClass(); // ������ 10�̾�����, �տ� firstclass �����ڸ� ������ 99�� �����Ǿ���.
													// �����ϰ� static INSTANCE�� return�� ���� �������Ƿ�, 
													// ��ġ�� ���������� ��.
		SingletonClass singobj = SingletonClass.getInstance();
		System.out.println("���� �Լ������� �̱��� ��ü i����? " + singobj.getI());
		// ���������� i���� 99.. �Ѱ��� ��ü�� ����ؼ� �������Ⱑ ������.
		
		
		
		
	}
}
