import { Component } from "react";
import "./Subject.css";

class Subject extends Component {
  render() {
    console.log("Subject render 수행");
    return (
      <header>
        <h1>
          <a
            href="/"
            onClick={(e) => {
              e.preventDefault(); // 클릭시 a태그 발동을 막음.
              this.props.onChangePage();
            }}
          >
            {this.props.title}
          </a>
        </h1>
        {/* 제목(속성 객체) 들어갈 곳은 중괄호를 넣는다. */}
        {this.props.sub}
      </header>
    );
  }
}

export default Subject;
