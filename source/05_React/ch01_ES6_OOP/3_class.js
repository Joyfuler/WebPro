// 클래스의 경우 ES6 클래스 지원 브라우저에서만 사용 가능.
//caniuse.com 에서 확인
// 앞 생성자 함수와 동일한 것을 클래스로 만들기 위해서는?
class Person{
    constructor (name, first, second){ // class를 만들고, 안에 constructor()를 사용
        console.log('생성자 함수 호출');
        this.name = name;
        this.first = first;
        this.second = second;
    }
    sum(){ // 생성자 함수의 경우 person.prototype.sum().. 클래스 안에서는 function을 넣으면 안 됨!
        return this.first + this.second;
    }
}

var kim = new Person('kim', 10, 20);
var lee = new Person('lee', 30,40);
console.log(kim.name, ',', kim.first, ',' , kim.second, ',' , kim.sum());
console.log(lee.name, ',', lee.first, ',' , lee.second, ',' , lee.sum());
// 위 sum 함수가 맘에 들지 않아 고치려 한다면?
// kim.sum = function(){}; 
Person.prototype.sum = function(){
    return '수정된 sum : ' + (this.first + this.second);
};

console.log(kim.name, ',', kim.first, ',' , kim.second, ',' , kim.sum());
console.log(lee.name, ',', lee.first, ',' , lee.second, ',' , lee.sum());