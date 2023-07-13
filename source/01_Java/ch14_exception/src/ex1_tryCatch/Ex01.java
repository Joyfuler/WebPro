package ex1_tryCatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i,j ; // 사용자에게 입력받을 수를 저장
		System.out.print("첫번째 정수는 (사칙연산 결과를 위한)? ");
		i = scanner.nextInt();
		System.out.print("두 번째 정수는 (사칙연산 결과를 위한)? ");
		j = scanner.nextInt();
		try { // 아플 것 같은 부위에 대한 보험. try - catch
		System.out.println(" i / j = " + (i / j)); // 0으로 나눈 경우 예외가 발생할 수 있음. 반드시 x... 일부 상황에서
	
		} catch(ArithmeticException e) { // try에서 예외 발생 x시 catch는 넘어감. try에서 예외가 발생하면 catch로 감.
			// cat 안은 해당 에러명 + 변수로.
			// System.out.println(e.getMessage()); // 해당 예외의 메시지를 출력.
			e.printStackTrace();// 예외 메시지를 매우 자세하게 출력하기 위함. 해당 에러가 몇 번째 줄에 있는지를 확인할 수 있다는 장점.
			// 프로그램이 종료되지 않고, 에러 발생시 있던 메시지를 대신 출력한 후 이후를 실행하고 종료
		}
		System.out.println(" i + j = " + (i + j));
		System.out.println(" i - j = " + (i - j));
		System.out.println(" i * j = " + (i * j));
		
	
		System.out.println("DONE");
		scanner.close();
		
	
	}
}
