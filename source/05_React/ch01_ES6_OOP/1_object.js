"usr strict";
var memberArray = ["hong", "park", "kim"];
// var memberArray = 1;

// 위와 같은 경우 에러가 나지 않고, memberyArray값이 1이 됨. (앞 값 삭제)
// 따라서 '엄격한' 변수선언을 통해 다른 것으로 덮어쓰기되지 않도록 할 수 있음.

// var copyArray = memberArray; //얕은복사 (객체의 주소만 똑같이 참조하므로)
var copyArray = [...memberArray]; // ...을 사용해 깊은복사를 사용. (주소만 참조하는 것이 아니라, 값이 똑같은 개체로 만듬).
copyArray[0] = "홍길동"; // 원래는 copyArray를 바꾸면 memberArray값도 변경됨.
copyArray[1] = "박길동"; // 그러나 ...을 사용하는 경우에는 값만 다른 별도의 개체이므로 memberArray는 변경되지 않음.
copyArray[2] = "김길동";
console.group("memberArray for-loop");
for (let i = 0; i < memberArray.length; i++) {
  console.log(i, "번째 : ", memberArray[i]);
}
console.groupEnd("memberArray for-loop");
console.group("copyArray for-loop");
for (let i = 0; i < copyArray.length; i++) {
  console.log(i, "번째 : ", copyArray[i]);
}
console.groupEnd("copyArray for-loop");

var memberObject = { name: "hong", age: 20 }; // 생성자함수 객체 생성
// var copyObject = {...memberObject}; // 깊은복사로 변경
// var copyObject = Object.assign({}, memberObject); // 객체의 깊은복사
var copyObject = Object.assign({id:1}, memberObject); // {id:1, name:'hong', age:20}
// 뒤에 있는 memberObejct를 앞의 빈 객체 {} 에 내용을 붙여넣는 것.
copyObject.name = '홍길동'; 
copyObject['age']= 30;

console.group ('copyObject for-in문');
for (let idx in copyObject) {
    console.log(idx, ':', copyObject[idx]);
        
    }    
console.groupEnd ('copyObject for-in문');

console.group ('memberObject for-in문');
for (let idx in memberObject) {
    console.log(idx, ':', memberObject[idx]);
        
    }

console.groupEnd ('memberObject for-in문'); // 얕은복사이므로 copyObject와 memberObject가 동일해짐
