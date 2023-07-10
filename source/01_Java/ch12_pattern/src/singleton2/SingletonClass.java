package singleton2;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE = new SingletonClass(); // Ÿ�� �̸��� Ŭ���� �̸��� �����ϰ�.

	private SingletonClass() {
		i = 10;
	} // i�� ������ 10���� �ʱ�ȭ�ϴ� Ŭ������ ����.

	public static SingletonClass getInstance() {
    // �̱����� INSTANCE ���� -- getInstance�� ����..
		return INSTANCE;
		// Ȥ��
		// if (INSTANCE == null){
		// INSTANCE = new SingletonClass(); 
		// return INSTANCE; �ε� ����
		
	} 

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
