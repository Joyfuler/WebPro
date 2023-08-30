import "./App.css";
import { Component } from "react";

//return 내부는 반드시 태그로 감싸야 정상적으로 동작함
class App extends Component {
  render() {
    return (
      <div className="App">
        <Subject title="web"></Subject>
      </div>
    );
  }
}
// Subject는 원래 존재하지 않는 컴포넌트(태그)이므로, 새로 Class를 만들어 주어야 함.

class Subject extends Component {
  render() {
    return (
      <header>
        <h1>WEB</h1>
        World Wide Web!
      </header> 
    );
  }
}
// 새로운 태그 Subject를 만들기 위해, <Subject>를 생성해 준 후 class를 만들어 component를 상속
export default App;
