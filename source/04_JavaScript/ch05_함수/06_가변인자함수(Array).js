// 가변인자함수 : 매개변수의 갯수에 따라 변하는 함수 (자바의 메소드오버로드처럼)
// 화살표 함수에서는 불가, 클래식한 함수에서만 가능.
// ex. Array()
var arr1 = [273, 2, "hello"]; // 쉼표가 맨 뒤에 있더라도 문제 x. 쉼표 뒤 값은 존재하지 않음
var arr2 = Array(273, 2, 3, "hello"); //위와 아래가 동일. Array에 매개변수를 몇 개를 넣든
//해당 변수로 배열을 만들어내는 함수.
var arr3 = [, , ,]; // 방 갯수는 3개인 비어있는 배열이 생김.
var arr4 = Array(3); // 마찬가지로 방이 3개짜리인 비어있는 배열을 만듬. (매개변수 1개)
// 이 경우 배열 수에 들어가는 것이 아니라 배열 칸만 지정해줌. (매개변수 갯수에 따른 역할변화)
var arr5 = Array(); // 방의 갯수가 0개인 빈 배열
var arr6 = []; // arr5와 마찬가지로 빈 배열. 방 x

console.log("arr1 = ", arr1, "방의 갯수=", arr1.length);
console.log("arr2 = ", arr2, "방의 갯수=", arr2.length);
console.log("arr3 = ", arr3, "방의 갯수=", arr3.length);
console.log("arr4 = ", arr4, "방의 갯수=", arr4.length);
console.log("arr5 = ", arr5, "방의 갯수=", arr5.length);
console.log("arr6 = ", arr5, "방의 갯수=", arr6.length);
// 3과 4는 동일

// 그러나 내가 직접 Array라는 배열에 여러 종류의 매개변수를 넣어도 오버로드처럼 사용할 수는 없음.
// 실제로 다양한 매개변수를 받아서 쓸 수 있는 함수는 무엇이 있을까?
