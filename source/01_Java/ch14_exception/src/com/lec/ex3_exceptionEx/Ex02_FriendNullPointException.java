package com.lec.ex3_exceptionEx;

import java.util.Date;

public class Ex02_FriendNullPointException {
	public static void main(String[] args) {
		Friend hong = new Friend("홍길동", "010-9999-9999", new Date(98,10,12));
		System.out.println(hong);
		Friend kim = new Friend("김길동", "010-8888-8888");
		System.out.println(kim);
} // nullpointexception이 나오는 경우엔 무심코 try catch를 하기보다는, if를 통해 원인을 수정하는 것이 좋음.
}
