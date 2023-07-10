package singleton1;

public class Single {
	private int i;
	private static Single INSTANCE = new Single(); // instance ������ null�� �ƴ϶� �ٷ� single ��ü�� �����
	private Single() {}
	public static Single getInstance() {
		return INSTANCE;
	}
	// public static Single INSTANCE; // instance��� single Ÿ�� ��ü�� �����ϰ� null�� �ʱ�ȭ
							    	// ������ ���� �����Ƿ� null�̸� ���� ������ �Ǵ���.
	
	//public static Single getInstance() { // getinstance��� �޼ҵ�� static�̹Ƿ�, 
										 // Single.getInstance(); ��� ���·� ȣ���� ���� (Ŭ����.�޼ҵ� ����)
	// Single�� ��ü�� ������ ���� ������ ��ü�� �������. �׷��� ��ü ������ ���� ��� �Ǵ���? if null��
		//if (INSTANCE == null) { // ������ ���� ���� ���� �Ǵ�������, �� �ȿ����� ���Ӱ� ��ü�� ���� �� ����.
			//INSTANCE = new Single(); // Single�̶�� ��ü�� ������.
		
		// ���� �߰��� obj2�� ����������, INSTANCE�� �̹� null�� �ƴ� (obj1�� �ּҰ��� �����Ƿ�)
		// ���� single�̶�� ��ü�� �߰��� �������� �ʰ�, ������ �ּҸ� ����Ű�� ��.
		
		//return INSTANCE; // ���� �ܺ� ȣ��� INSTANCE�� ��ȯ��.
		
		//���� - 1) ������ �Լ� privateȭ,  2) ���� �̱��� ������ static���� �ϳ� ����. 
		// 3) static�� getInstance()��� �޼ҵ带 ����� if == null �Ǵ��ϴ� �� ��ü�� ����. 4) �ش� ���� return
	
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	
		
}
