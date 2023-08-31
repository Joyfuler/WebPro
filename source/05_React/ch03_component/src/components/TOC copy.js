import { Component } from "react";

class TOC extends Component {
  render() {
    var lists = [];
    var data = this.props.data;
    for (var i = 0; i < data.length; i++) {
      lists.push(
        <li key={data[i].id}>
          <a
            href={data[i].id + ".html"}
            data-id={data[i].id} // a태그에 data-id라는 props를 추가함.
            onClick={(e) => {
              e.preventDefault();
              this.props.onChangePage(Number(e.target.dataset.id)); // 매개변수가 있는 경우엔 id를 넣어줘야함!
              // id를 넣는 방법은 브라우저에서 해당 버튼을 클릭 후 console에서 target -> dataset -> id의 값을 찾아 넣어주면 된다. (data-id로 변수를 생성해야 id로 출력됨!)
              // 단, 가져오는 값은 숫자가 아닌 String이므로 형변환이 필요.
              // for문 안 함수는 [i]를 인식하지 못함! (외부라면 인식 가능하나, a라는 태그 안에서는 서로 인식이 불가능하니 사용이 불가능.)
            }}
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
