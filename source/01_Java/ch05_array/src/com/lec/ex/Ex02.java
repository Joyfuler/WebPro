package com.lec.ex;
// 일반 for문  vs 확장for문 (Array, ArrayList)
public class Ex02 {
	public static void main(String[] args) {
		double [] arr = {1.1, 2.2, 3.3}; // double인 경우 {0.0, 0.0, 0.0} 으로 변경됨. (int는 {0,0,0})
		// 일반 for문 (인덱스와 값을 같이 출력)
		for (int idx = 0; idx < arr.length; idx++) {
			System.out.printf("arr[%d] = %.1f\t", idx, arr[idx]); // 0.0을 출력하기 위해 %d대신 %f으로 변경. (소숫점 첫째자리수는 %.1f)
			System.out.println();
		}
			
		// 확장 for문 (배열만 출력)
		for (double a : arr) { // foreach 구문. a라는 임시 변수를 만든 후 arr을 카피한 것.
			// index가 필요 없는 경우엔 foreach를 이용해 출력하는 것이 편리함.
			System.out.println(a + " "); // sysout (a[0])으로는 사용 못함.
						
		}	
		// 배열 값을 변경. 모든 값에 10% 인상을 해주고 싶다면?
		// arr[0] = arr[0] * 1.1; --> arr[0] *= 1.1;
		
		double [] arr2 = {999.0, 987.0, 920.0}; // 해당 배열에 모두 곱하기 10%를 하고 싶은 경우
		for (int idx2 =0; idx2 < arr2.length; idx2++) {
			arr2[idx2] *= 1.1;
			}
		for (double d : arr2) {
			System.out.printf( "%.1f \t", d);
		}
		// 혹은 확장for문을 이용해 인상할 수도 있음.
		for (double b : arr2) { // 999.0, 987.0, 920.0
			b *= 1.1; // b에 10%를 더해주면 변경되는지?
			System.out.printf( "%.1f \t", b); // 확장 for문을 이용한 값 변경은 불가함.
                                            		//배열을 복제한 임시 변수가 변경되는 것이므로..
		}
		}
	}


