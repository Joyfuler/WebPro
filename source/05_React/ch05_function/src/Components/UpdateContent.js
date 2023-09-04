
const UpdateContent = props => {
    return(
        <article>
            <h2>업데이트</h2>
            <form onSubmit = {event => {
                event.preventDefault();
                props.onUpdate(Number(event.target.id.value), event.target.title.value, event.target.desc.value);
                // create와 동일한 내용이나 새로운 함수 onUpdate로 변경. 또한 id를 비교해 같은 것을 수정해야 하므로 id라는 매개변수를 1개 추가하여 총 3개 매개변수가 되었음.
            }}>
                {/* props. -> CreateContent에서 props로 받아온다.*/}
                <p><input type = "hidden" name = "id" defaultValue = {props.data.id}></input></p>
                <p><input type = "text" name = "title" defaultValue = {props.data.title}></input></p>
                <p><textarea type = "text" name = "desc" defaultValue = {props.data.desc}></textarea></p>
                <p><input type = "submit" value = "수정"/></p>
            </form>
        </article>
    );
}

export default UpdateContent;