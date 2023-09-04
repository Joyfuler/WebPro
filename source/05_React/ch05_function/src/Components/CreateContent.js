
const CreateContent = (props) => {
    return(
        <article>
            <h2>크리에이트</h2>
            <form onSubmit = {event => {
                event.preventDefault();
                props.onCreate(event.target.title.value, event.target.desc.value); // app에 있는 oncreate 함수를 실행. 두 개의 매개변수를 받아 타이틀과 설명을 추가함
            }}>
                {/* oncreate 역시 함수가 들어있지만 props. CreateContent에서 props로 받아온다.*/}
                <p><input type = "text" name = "title" placeholder = "타이틀"></input></p>
                <p><textarea type = "text" name = "desc" placeholder = "설명"></textarea></p>
                <p><input type = "submit" value = "추가"/></p>
            </form>
        </article>
    );
}

export default CreateContent;