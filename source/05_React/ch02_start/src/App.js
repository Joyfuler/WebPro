import { Component } from "react";
import "./App.css";

class App extends Component {
  // 태그에 대한 속성을 가진 Component 클래스를 가져와 상속.
  render() {
    //render () 및 return () 안에 html 속성을 넣어줌.
    return (
    <div className="App">
      Hello, React!
      </div>
    ); // return();
  } // render ()
} // class

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//        Hello, React!!
//       </header>
//     </div>
//   );
// }

export default App; // 외부에서 App이라는 태그를 사용할 수 있도록 허용함.
