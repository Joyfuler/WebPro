import { Component } from "react";
class UpdateContent extends Component {
  // 선택되어 있는 TOC를 form태그에 넣고, 동일 id에 해당하는 내용을 수정.

  constructor(props) {
    super(props);
    this.state = {
      id: this.props.data.id,
      title: this.props.data.title,
      desc: this.props.data.desc,
    };
    this.inputHandler = this.inputFormHandler.bind(this);
  }

  inputFormHandler(e) {
    // input 버튼들의 중복된 태그를 피하기 위해, 공통된 부분을 FormHandler로 넣어줌.
    this.setState({
      [e.target.name]: e.target.value,
    });
  }

  render() {
    console.log("CreateContent Rendering");
    return (
      <article>
        <h2>UPDATE</h2>
        <form
          onSubmit={e => {
            e.preventDefault();
            this.props.onSubmitUpdate(
              this.state.id,
              this.state.title,
              this.state.desc
            );
          }}
        >
          <p>
            <input type="hidden" name="id" defaultValue={this.props.data.id} />
          </p>

          <p>
            <input
              type="text"
              name="title"
              value={this.state.title}
              onChange={this.inputHandler}
              // defaultValue = {this.props.data.title}
            />
          </p>
          <p>
            <textarea
              name="desc"
              rows="4"
              cols="25"
              value={this.state.desc}
              onChange={this.inputHandler}
            ></textarea>
          </p>
          <p>
            <input type="submit" value="수정" />
          </p>
        </form>
      </article>
    );
  }
}

export default UpdateContent;
