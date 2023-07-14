package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1; // 사용자에게 입력받을 수를 저장. 단, 예외처리시 int 계산에서 문법적 오류가 발생할 수 있으니 일단 1로 초기화..

		do {
			try { // 이중try는 피하고, catch { } catch로 이을것.
				System.out.print("첫번째 정수는 (사칙연산 결과를 위한)? ");
				i = scanner.nextInt();
				break;
				// 제대로 정수를 입력한 경우 밑으로 나갈 수 있도록.
			} catch (InputMismatchException e) {
				System.out.println("수에 문자를 넣지 마세요.");
				scanner.nextLine(); // 가져오는 것이 아니라, 남아있는 버퍼를 지우기 위함. (i에 a등을 넣으면 버퍼에 남아 무한반복을 하므로)
				// 순서에 유의하고 에러발생시에는 순서를 바꿔주자.
			}

		} while (true);
		System.out.print("두 번째 정수는 (사칙연산 결과를 위한)? ");

		try {

			j = scanner.nextInt();
			 // 예외가 발생했기 때문...

		} catch (ArithmeticException e) { // try에서 예외 발생 x시 catch는 넘어감. try에서 예외가 발생하면 catch로 감.
			// cat 안은 해당 에러명 + 변수로.
			System.out.println(e.getMessage()); // 해당 예외의 메시지를 출력.
			e.printStackTrace();// 예외 메시지를 매우 자세하게 출력하기 위함. 해당 에러가 몇 번째 줄에 있는지를 확인할 수 있다는 장점.
			// 프로그램이 종료되지 않고, 에러 발생시 있던 메시지를 대신 출력한 후 이후를 실행하고 종료

		} catch (Exception e) {
			System.out.println(e.getMessage()); // 예외 메시지가 없음.
			System.out.println("두 번쨰 정수를 잘못 입력하시면 무조건 1로 처리합니다.");

			// 아플 것 같은 부위에 대한 보험. try - catch
			// 0으로 나눈 경우 예외가 발생할 수 있음. 반드시 x... 일부 상황에서

			// catch (Exception e) 혹시모를 모든예외처리메시지. 따라서 부모예외는 되도록 아래로 둘것..

		}
		System.out.println(" i / j = " + (i / j));
		System.out.println(" i + j = " + (i + j));
		System.out.println(" i - j = " + (i - j));
		System.out.println(" i * j = " + (i * j));

		System.out.println("DONE");
		scanner.close();

	}
}
