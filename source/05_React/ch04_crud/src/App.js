import "./App.css";
import ReadContent from "./Component/ReadContent";
import TOC from "./Component/TOC";
import Subject from "./Component/Subject";
import React, { Component } from "react";
import Control from "./Component/Control";
import CreateContent from "./Component/CreateContent";
import UpdateContent from "./Component/UpdateContent";

class App extends Component {
  constructor(props) {
    super(props);
    this.maxId = 4; // 불필요한 렌더링방지를위해 this.state 밖으로 빼줌.
    // state가 set될떄마다 새롭게 렌더링이 되기 때문에
    this.state = {
      mode: "welcome",
      selected_content_id: 0, //선택하지 않은 상태
      welcome: { title: "WELCOME", desc: "Hello, React!!" },
      subject: { title: "WEB", sub: "World Wide Web!!" },
      contents: [
        { id: 1, title: "HTML", desc: "HTML is for Information" },
        { id: 2, title: "CSS", desc: "CSS is for design" },
        { id: 3, title: "JavaScript", desc: "Javascript is for interactive" },
        { id: 4, title: "React", desc: "React is for UI" },
      ],
    };
  }

  getReadContent() {
    for (var i = 0; i < this.state.contents.length; i++) {
      var data = this.state.contents[i];
      if (data.id === this.state.selected_content_id) {
        //같은 선택된 id와 데이터 아이디가 동일한 경우 해당 내용을 return
        return data;
      }
    } //for
  }

  getContent() {
    //클래스 안 메소드를 만드는 작업이므로 function getContent(x)
    var _title = null;
    var _desc = null;
    var _article = null;
    var _content = null;
    if (this.state.mode === "welcome") {
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>;
    } else if (this.state.mode === "read") {
      _content = this.getReadContent();
      _article = (
        <ReadContent title={_content.title} desc={_content.desc}></ReadContent>
      );
      // 기본 값을 처음 배열로 고정.
    } else if (this.state.mode === "create") {
      _article = (
        <CreateContent
          onSubmitCreate={function (_title, _desc) {
            //매개변수를 받아
            // _title과 _desc로 this.state.contents에 push로 {id:5, title:_title, desc: desc} 추가
            this.maxId++; // 현재 배열값. 4까지 있으며, 추가할 때 새로 id가 늘어나므로.
            _content = { id: this.maxId, title: _title, desc: _desc };
            var _contents = Array.from(this.state.contents); //render 규칙에 의해 setState 바로 앞절의 값이 setState가 적용된 상태와 같아서는 안 됨
            _contents.push(_content);

            this.setState({
              contents: _contents,
              mode: "read",
              selected_content_id: this.maxId,
            });
          }.bind(this)}
        ></CreateContent>
      );
    } else if (this.state.mode === "update") {
      _content = this.getReadContent(); // 위에 정의한 함수와 동일. 현재 선택된 id가 존재하는지를 비교. mode가 welcome상태라면 undefined(false)
      if (_content) {
        _article = (
          <UpdateContent
            data={_content}
            onSubmitUpdate={function (_id, _title, _desc) {
              var _contents = Array.from(this.state.contents); // 배열복사. 개체를 바꿀 때에는 꼭 복사를 한 후 복제한 데이터를 대입하는 것이 좋음.
              for (var idx = 0; idx < _contents.length; idx++) {
                if (_contents[idx].id === Number(_id)) {
                  _contents[idx] = {
                    id: Number(_id),
                    title: _title,
                    desc: _desc,
                  }; // 매개변수로 넘어온 content가 해당 배열순서에 맞는 content와 내용이 동일한지 비교
                  // 동일하다면, 원본을 변경
                  console.log(
                    idx,
                    "번째 수정 완료 수정된 데이터는",
                    _contents[idx]
                  );
                  break;
                }
              }
              this.setState({
                contents: _contents,
                mode: "read",
              });
            }.bind(this)}
          ></UpdateContent>
        );
      } else {
        this.setState({
          mode: "welcome",
          welcome: {
            title: "수정 유의사항",
            desc: "수정할 데이터 선택 후 수정하세요",
          },
        });
      }
    }
    return _article;
  }
  render() {
    console.log("★★App Rendering");

    return (
      <div className="App">
        <Subject
          title={this.state.subject.title}
          sub={this.state.subject.sub}
          onChangePage={function () {
            this.setState({
              mode: "welcome",
            });
          }.bind(this)}
        ></Subject>

        {/* 버튼영역 - Create / Update / Delete 등   */}
        {/* control에서 this.props.onChangeMode('create')로 할 시,
        'create'가 _mode라는 매개변수로 들어가고 mode를 create로 변경해준다.*/}
        <Control
          onChangeMode={(_mode) => {
            if (_mode === "delete") {
              if (this.state.selected_content_id != 0 &&
                window.confirm("정말 삭제하시겠습니까?")) {
                  //selected_content_id가 제대로 숫자인 content를, 확인을 눌렀을 때 해당 배열 번호의 데이터가 삭제되도록.
                  var _contents = Array.from(this.state.contents);
                  for (var idx =0; idx < _contents.length; idx++){
                    if (_contents[idx].id === this.state.selected_content_id){
                      _contents.splice(idx, 1); // 해당 idx번째부터 1개 지움 (즉 idx번째의 데이터만 지움)
                      alert(this.state.selected_content_id + '번째 데이터를 삭제 완료');
                      break;
                    }
                  }
                  this.setState({
                    contents : _contents,
                    mode : 'welcome',
                    selected_content_id: 0,
                  });
              } else if (this.state.selected_content_id ==0){
                alert("삭제할 데이터를 선택 후 삭제하세요.");
              }
            } else {
              this.setState({ mode: _mode });
              
            }
          }}
        ></Control>
        {/* 이후 버튼을 클릭시 Control.js에 있는 onChangeMode() 함수가 작동함.*/}

        <TOC
          data={this.state.contents}
          onChangePage={function (id) {
            this.setState({
              mode: "read",
              selected_content_id: Number(id),
            });
          }.bind(this)}
        ></TOC>
        {this.getContent()}
      </div>
    );
  }
}

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

export default App;
