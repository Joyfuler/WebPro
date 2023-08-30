class Person{
    constructor (name, first, second){ // class를 만들고, 안에 constructor()를 사용
        
        this.name = name;
        this.first = first;
        this.second = second;
    }
    sum(){ // 생성자 함수의 경우 person.prototype.sum().. 클래스 안에서는 function을 넣으면 안 됨!
        return this.first + this.second;
    }
}

var hong = new Person("홍길동",100,90);
console.log('hong의 sum ' + hong.sum());

class PersonPlus extends Person{
    constructor(name,first,second,third){
        super(name,first,second); // 부모 클래스에 이미 생성자가 있으므로, super를 통해 다시 가져와줌
        this.third = third; // PersonPlus에는 third 매개변수를 추가.
    }
    sum () {
        return super.sum() + this.third // 부모클래스의 sum에 본 클래스의 third를 더함.
    }
    avg () {
        return this.sum() / 3;
    }
}

var hong2 = new PersonPlus("김길동",80,80);
console.log(hong2.name+'의 sum: ' + hong.sum());
var son = new PersonPlus ('손흥민',100,100,100);
console.log(son.name+'의 sum: ' + son.sum());
console.log(son.name+'의 avg: ' + son.avg());