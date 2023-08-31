import "./App.css";
import Content from "./Component/Content";
import TOC from "./Component/TOC";
import Subject from "./Component/Subject";
import React, { Component } from "react";


class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      selected_content_id : 1,
      mode: 'read',
      welcome: {title:'WELCOME', desc:'Hello, React!!'},
      subject: { title: "WEB", sub: "World Wide Web!!" },
      contents: [
        { id: 1, title: "HTML", desc: "HTML is for Information" },
        { id: 2, title: "CSS", desc: "CSS is for design" },
        { id: 3, title: "JavaScript", desc: "Javascript is for interactive" },
      ],     
    };
  }

  render() {
    console.log ('★★App Rendering');
    var _title = null;
    var _desc = null;
    if (this.state.mode ==='welcome'){
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
    } else if (this.state.mode ==='read'){
      for (var i=0; i<this.state.contents.length; i++){
        var data = this.state.contents[i];
        if (data.id === this.state.selected_content_id){
        _title = data.title;
        _desc = data.desc;
        break;        
        }
      }
      // 기본 값을 처음 배열로 고정.
    }
    return (
      <div className="App">
        <Subject title={this.state.subject.title} 
        sub={this.state.subject.sub}
        onChangePage={function(){
          this.setState({
            mode: 'welcome'
          });
        }.bind(this)}></Subject>        
        <TOC onChangePage={id => {
          this.setState({
            mode: 'read',
            selected_content_id: Number(id)
          });
        }}
        data = {this.state.contents}></TOC>
        <Content
          title={_title}
          desc= {_desc}
        ></Content>
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
