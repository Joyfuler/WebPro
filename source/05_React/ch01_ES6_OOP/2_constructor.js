function Person (name, first, second){ //생성자 함수.
    this.name = name;
    this.first = first;
    this.second = second; // 매개변수에서 생성자함수에 대입.
}
// 매개변수에 함수를 넣을 수도 있지만, 생성자함수에 함수를 넣는 경우 메모리 과소비가 일어날 수 있으므로 지양

Person.prototype.sum = function(){
    return this.first + this.second;
};

var kim = new Person('kim', 10, 20);
var lee = new Person('lee', 30,40);
console.log(kim.name, ',', kim.first, ',' , kim.second, ',' , kim.sum());
console.log(lee.name, ',', lee.first, ',' , lee.second, ',' , lee.sum());