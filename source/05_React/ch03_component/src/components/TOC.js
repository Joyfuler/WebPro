import { Component } from "react";
import "./TOC.css";

class TOC extends Component {
  render() {
    var lists = [];
    var data = this.props.data;
    for (var i = 0; i < data.length; i++) {
      lists.push(
        <li key={data[i].id}>
          <a
            href={data[i].id + ".html"}
            onClick={function (id, e) {
              e.preventDefault();
              this.props.onChangePage(id); // 매개변수가 있는 경우엔 id를 넣어줘야함!
            }.bind(this, data[i].id)} //bind (this 뒤에 매개변수를 추가해주자!)
            // data[i].id는 function의 첫번째 매개변수로 이동, this는 this 매개변수로
          >
            {data[i].title}
          </a>
        </li>
      );
    }
    // data[i].id = 1,2,3 ... data[i].title = html, css, javascript

    // App.js에서 <TOC data = {this.state.contents}>로 넘겼으므로, this.props.data로 받음.
    console.log("TOC render 수행");
    return (
      // 진짜 태그가 아닌, 유사 html 태그임을 참고.
      // 유사 태그 안에 매개변수나 객체를 넣겠다면 꼭 {} 를 넣어주자.
      <nav>
        <ul>{lists}</ul>
      </nav>
    );
  }
}

export default TOC;
