// bind ?
var hong = { name: "홍길동", first: 10, second: 20 };
var shin = { name: "이길동", first: 30, second: 40 }; //타입이 동일한 2개의 객체 생성
first = 100;
second = 99;

function sum(prefix = " : ") {
  //매개변수 초기값 세팅.. first나 second가 들어가 있지 않음.
  //아무것도 들어가 있지 않은 경우 디폴트는 : 가 됨.
  return prefix + (this.first + this.second); // 외부 변수의 합으로 인식. 이번 경우 위에 지정된 var first, var second가 들어옴.
}
console.log('외부 변수의 합' +  sum('')); // 아무것도 적지 않았더라도, prefix에 :가 있으므로 '외부 변수의 합:' 으로 출력
console.log('Hong의 합 ' + sum.call(hong)); // hong이 sum이라는 함수를 실행하라는 의미
// sum()으로만 적어버리면 어떤 외부 변수의 합으로 인식하므로, hong의 sum을 구하기 위해 sum.call을 사용해야 함.
console.log('hong의 합 sum.call(hong)', sum.call(hong, ' = '));
console.log('shin의 합 sum.call(shin,"~")', sum.call(shin,'~ '));

//var hongSum = sum.bind(hong); // hong에 있는 매개변수가 this로 들어가는 새로운 함수 
var hongSum = sum.bind(hong); // 만일 this가 제대로 먹히지 않을 때는 bind를 사용하여 들어가기 원하는 객체를 넣어주자
console.log('bind를 이용한 hong의 sum값', hongSum());

var shinSum = sum.bind(shin,'?! '); // this에 shin의 값이 들어감.
console.log('bind를 이용한 shin의 sum값' + shinSum());
