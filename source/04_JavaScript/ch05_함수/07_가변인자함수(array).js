// array함수 생성 - 여러 개의 매개변수를 쓸 수 있도록.
// 매개변수가 0개라면, length가 0인 배열을 return
// 매개변수가 1개라면, length가 (매개변수 a)만큼인 빈 배열을 return
// 매개변수가 2개라면, 각 매개변수를 배열 값으로 가진 배열을 return.
var arr = Array();
// 가변적 매개변수를 가진 함수를 만들려면 매개변수의 갯수를 정해주지 말고,
// 매개변수를 아예 넣지 말아야 함.

var arr1 = array();
var arr2 = array(2);
var arr3 = array(1, 5);
var arr4 = array(1, 4, 3);
console.log("arr1(빈배열) = " + arr1);
console.log("arr2(빈방여럿) = " + arr2);
console.log("arr3 :" + arr3);
console.log("arr4: " + arr4);

function array() {
  // 매개변수 x시 arguments라는 배열이 생김.  실행시의 매개변수가 들어옴.
  for (var idx = 0; idx < arguments[0]; idx++) {
    console.log(arguments[idx]);
  } //argument를 사용시 array라는 함수에 몇 개의 매개변수를 넣든 배열이 return됨.
} // 이후 if (arguments.length == 1){
// } arguments.length마다 다른 명령어를 입력하여 상황에 따라 다르게 반응하는 함수로 만듬.
function array() {
  let result = []; // 비어있는 배열. arguments의 갯수가 0일 때 그대로 return하는 값.
  if (arguments.length == 0) {
    return result;
  } else if (arguments.length == 1) {
    // length가 arguments[0]인 배열을 만듬. arguments[0]값이 3이라면, array(3)을 만드는 경우 빈 방이 3개 만들어지는 것과 동일.
    for (var cnt = 0; cnt <= arguments[0]; cnt++) {
      result.push(null); // 방은 비어있고, 만들어지는 갯수는 arguments[0] (첫번째 매개변수) 만큼.
    }
    return result;
  } else if (arguments.length == 2) {
    // arguments[0], arguments[1]...을 배열로 만듬. (array(1,2))
    for (var idx = 0; idx < arguments.length; idx++) {
      result.push(arguments[idx]); // 1방값, 2방값... 매개변수 갯수만큼 배열에 매개변수 값을 넣어줌.
    }
    return result;
  } else if ((arguments.length = 3)) {
    // 2와 마찬가지.
    for (var idx = 0; idx < arguments.length; idx++) {
      result.push(arguments[idx]); // 매개변수 인자를 길이만큼 (끝까지) push해서 추가해줌.
    }
    return result;
  }
}
