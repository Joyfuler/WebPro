// 클래스뿐 아니라 객체 역시 상속이 가능함
let superObj = {name : '손웅정'}; //부모객체
// let subObj = {age: 32}; //상속받은객체. 두 속성타입은 서로 다름 (name / age)
// subObj.__proto__ = superObj; //프로그래밍에서의 proto함수. 부모객체의 속성을 상속받을 수 있음. 
let subObj = Object.create(superObj); //객체끼리 상속
subObj.age = 32; //subObj에 age =32 라는 속성을 추가해도 똑같은 결과를 낼 수 있음.
console.log ('superObj.name :', superObj.name);
console.log ('subObj.name:', subObj.name, 'subObj.age:',subObj.age);
console.log ('subObj.__proto__.name : ', subObj.__proto__.name);

debugger; // 실행이 잘 되는지를 확인 (브라우저에서 일시중지하면서 객체 상태를 모니터링)
// subObj.__proto__.name == subObj.name ? (X)
// 사실 subObj.name에는 값이 없고, subObj.__proto__.name이 super로부터 상속받은 값을 다시 가져다 쓴 것.
subObj.name = '손흥민';
console.log('subObj.name:', subObj.name);
console.log('subObj.__proto__.name:',subObj.__proto__.name);
console.log('subObj.age:', subObj.age);