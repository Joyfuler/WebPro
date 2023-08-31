import { Component } from "react";
import "./TOC.css";

class TOC extends Component {
  render() {
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
