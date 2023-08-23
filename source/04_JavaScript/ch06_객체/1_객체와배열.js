/* 자바의 경우 어떻게 했었는지?
class Person {
    private String name;
    private String age;
    public Person(String name, String age){
        this.name = name; -> 내 객체의 name에 매개변수 name을 대입한다는 의미.
        this.age = age;        
    }
    public void setName (String name){
        this.name = name;
        이하 get&set 메소드... 
        }
    } 이와 같은 클래스를 우선 생성한 후 다른 클래스에
    Person person = new Person("홍길동",20); 식으로 정의하였음.
    자바의 경우 person.name = '김길동'; 식으로 바꿀 수가 없으므로 (private)
    person.setName("김길동"); 과 같은 식으로 사용하였음.
*/
const person = {'name':'홍길동','age':20}; // 자바스크립트의 경우는 다음과 같이 생성함.
// name과 age는 속성변수이자 key값. (key값으로 해당 값을 가져올 수 있음.)
// 혹은 배열로 만들어도 같은 결과가 나옴.
personArr = ['홍길동',20];
// 배열의 경우에는 key값은 배열의 index. personArr[0] 등으로 접근가능.

person.name = "김길동"; // const 변수임에도 안의 name을 변경할 수 있음!
// 안에 있는 객체의 값이 아니라, 참조하고 있는 주소의 값만 바꾸지 못하는 것이기 때문.
console.log(person.name , '/' , person.age);
console.log(person['name'], '/' , person['age']);