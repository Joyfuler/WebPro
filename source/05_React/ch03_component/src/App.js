import "./App.css";
import { Component } from "react";
import Subject from "./components/Subject";
import TOC from "./components/TOC";
import ReadContent from "./components/ReadContent";

//return 내부는 반드시 태그로 감싸야 정상적으로 동작함
class App extends Component {
  constructor(props) {
    super(props); // 생성자 함수가 없으므로, props를 생성자 함수로 추가
    this.state = {
      //state를 객체화. state 안에는 또 다른 객체나 배열이 들어갈 수 있음.
      subject: { title: "WEB", sub: "Word Wide Web" },
      contents: [
        // id는 반드시 중복되지 않도록 고유값으로 넣을 것!
        { id: 1, title: "HTML", desc: "HTML is HyperText Markup Language" },
        { id: 2, title: "CSS", desc: "CSS is for Design" },
        { id: 3, title: "JAVASCRIPT", desc: "JS is for Interactive." },
        { id: 4, title: "REACT", desc: "REACT is for UI" },
      ],
      mode: "read",
      welcome: { title: "WELCOME!", desc: "Hello, React" },
      selected_content_id: 1,
    };
  }
  // 다음과 같이 props를 바꿔도, state를 바꿔도 다시 render하면서 값이 바뀌도록 함.
  // 이후 아래 데이터에 태그의 값을 state 안에 있는 title / sub 등의 값으로 바꾸고자 한다면?
  // '' 대신 {} (중괄호)를 넣어 객체를 대입할 수 있음.

  render() {
    console.log("App render 수행");
    var _title,_desc, _article = null;
    if (this.state.mode === "welcome") {
      //타입과 값이 모두 동일해야. (<App> 태그가 StrictMode로 감싸져있음)
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>
    } else if (this.state.mode === "read") {
      //var data = this.state.contents[this.state.selected_content_id - 1]; // 선택한 컨텐츠 id에 1을 뺴주면 배열넘버에 맞춰져 출력이 가능함.
      // _title = data.title; // this.state.contents[0].title
      //_desc = data.desc; // this.state.contents[0].desc
      for (var i = 0; i < this.state.contents.length; i++) {
        var data = this.state.contents[i];
        if (data.id === this.state.selected_content_id) {
          // data.id = this.state.contents[i].id
          _title = data.title;
          _desc = data.desc;
          _article = <ReadContent title={_title} desc={_desc}></ReadContent>
          break;
        }
      }
    }
    return (
      <div className="App">
        <Subject
          title={this.state.subject.title}
          sub={this.state.subject.sub}
          onChangePage={() => {
            this.setState({
              mode: "welcome",
            }); //객체 넣을 땐 꼭 {} 안에!
          }}
        ></Subject>
        <TOC data={this.state.contents} // 중괄호 안은 유사 script
        onChangePage={id=>{ // 받은 아이디를 토대로 표시될 값을 바꿀 예정
          this.setState(
            {mode: "read",
            selected_content_id : id,
          });
        }}
        ></TOC>
        {_article}
        {/* onChangePage는 원래는 없는 값으로 props. 여기에 function 넣을 시 이벤트 발생
      만일 타이틀(props)을 바꿨을 때 다른 내용이 나오도록 하고 싶다면? 
      상속한 클래스의 title이 들어갈 부분에 this.props.title 을 넣어주면 해당 부분에 설정한 title이 들어감. 
      각 . 은 ~ 아래의 로 치환해서 대입하자. */}
      </div>
    );
  }
}
export default App;
