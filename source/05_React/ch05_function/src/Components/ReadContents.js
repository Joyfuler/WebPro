import './ReadContents.css'

const ReadContent = props => {
    return(
        <article>
            <h2>{props.title}</h2>
            {/* class의 경우는 this.props.title을 썼어야 하지만,
            함수의 매개변수로 props를 받았다면 this를 쓰지 않아도 됨 */}
            {props.desc}
        </article>
    );
};

export default ReadContent;