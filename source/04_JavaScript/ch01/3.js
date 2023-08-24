let sum = 0; //변수선언 (var,let), var는 <> 밖에서 사용 가능, let은 <> 안에서만 가능.
for (var i = 1; i <= 10; i++) {
  // for (const i=1; i<=10; i++) 은 오류. 상수이므로 더하려고 할 때 console에서 오류가 출력됨
  sum += i;
  console.log("i=" + i + "일 때까지 누적 합은 " + sum);
}
console.log("for문 끝");
console.log("for문 수행 후 i값은 " + i);
console.log("1~10까지의 누적합은 " + sum);
