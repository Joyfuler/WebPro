import { Component } from "react";
import "./TOC.css";

class TOC extends Component {
  shouldComponentUpdate(newProps /* 이전 props값*/){    
    if (this.props.data === newProps.data){
      return false; //이전값과 같다면, 변경할 필요가 없으므로 렌더링을 하지 않음.
    } 
    return true;
  }
  render() {
    console.log('TOC Rendering');
    var lists = [];
    var data = this.props.data;
    for (var key = 0; key < data.length; key++) {
      lists.push(
        <li key={data[key].id}>
          <a
            href={data[key].id + ".html"}
            data-id={data[key].id}
            onClick={function (id, e) {
              e.preventDefault();
              this.props.onChangePage(id);
            }.bind(this, data[key].id)}>
            {data[key].title}
          </a>
        </li>
      );
    }
    return (
      
      <nav>
        <ul>{lists}</ul>
      </nav>
    );
  }
}
export default TOC;
