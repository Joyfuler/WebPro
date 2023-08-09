// 2. js (자바스크립트) JavaScript source code
/* 동적인 부분을 기록(DB연결은 안됨), 자바스크립트(jQuery,react) 문법으로 작성 */
let name = prompt("이름은?", "(3글자로 입력)"); // 취소클릭시 null리턴, 확인시 입력한것 name들어감        
if (name != "null" && name != "") { //빈칸ornull이 아닌경우
    document.write(name + "반갑습니다 <br>")
}
