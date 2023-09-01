import { Component } from "react";

class CreateContent extends Component{
// form태그를 만들어서 추가하는 용도의 컴포넌트.
    render(){
        console.log ('CreateContent Rendering');
        return(
            <article>
                <h2>CREATE</h2>
                <form onSubmit = {e => {
                    e.preventDefault(); // 일단 자체 submit 기능을 막음. (e = 본래 이벤트가 걸리는 태그. 여기서는 form)
                    //console.log(e.target.title.value); // f12에 가보면 아래 input의 값을 가져오는 방법은 e.target.title.value
                    //console.log(e.target.desc.value);                    
                    this.props.onSubmitCreate(e.target.title.value, e.target.desc.value);
                    e.target.title.value = '';
                    e.target.desc.value = '';
                }}>
                <p><input type = "text" name = "title" placeholder = "타이틀" required="required"/></p>
                <p><textarea name = "desc" placeholder = "설명.." rows="4" cols="25" required="required"/></p>
                <p><input type = "submit" value = "추가"/></p>
                </form>
            </article>
        );
    }
}

export default CreateContent;