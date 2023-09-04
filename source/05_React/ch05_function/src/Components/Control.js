import './Control.css'

const Control = props => {
    return(
        <ul className ="control">
            <li><button onClick = {function(){
                props.onChangeMode('create');  // props를 변수로 설정 후, onChangeMode()앞에 props를 넣는 것 잊지 말 것!
            }}>CREATE</button></li>
            <li><button onClick = {function(){
                props.onChangeMode('update');
            }}>UPDATE</button></li>
            <li><button onClick = {function(){
                props.onChangeMode('delete');
            }}>DELETE</button></li>

        </ul>
    );
}

export default Control;