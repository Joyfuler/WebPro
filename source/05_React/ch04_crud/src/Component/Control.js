import { Component } from "react";
import './Control.css';


class Control extends Component {
    // Control의 경우 해당 버튼을 누를 때의 기능이 고정이고,
    // Subject, Content처럼 변수가 생기는 것이 아니므로 생성자를 넣지 않는다.
    render(){
        console.log ('Control Rendering');
        return(            
            <ul className="control">
            {/* 유사HTML 환경에서는 class대신 꼭 className을 사용*/}
                {/* a태그를 사용했을 때는 아래와 같이 입력하였음. 
                <a href="#" onClick = {e => {
                    e.preventDefault();
                    this.props.onChangeMode('create');
                }}>CREATE</a> */}
                <li><button onClick = {() => {
                    this.props.onChangeMode('create');
                }}>CREATE</button></li>
                <li><button onClick = {() => {
                    this.props.onChangeMode('update');
                }}>UPDATE</button></li>
                <li><button onClick = {() => {
                    this.props.onChangeMode('delete');
                }}>DELETE</button></li>
            </ul>
        );
    }
}
export default Control;
