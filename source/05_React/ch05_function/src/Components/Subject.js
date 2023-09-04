import './Subject.css'

const Subject = props => {
    return (
        <header className = "subject">
            <h1 onClick = {function(){
                props.onChangePage();
            }}> {props.title} </h1>            
        </header>
        // h1에 app.js에서 날아온 ChangePage를 다시 돌려주는 이벤트를 검. header에 넣어도 무방
        


    );
};

export default Subject;