import './TOC.css'

const TOC = props => {
    var lists = [];
    var data = props.data; // App.js의 TOC data로 던진 data를 var data가 받은 것.
    for (var i=0; i<data.length; i++){
        lists.push (<li key = {data[i].id}><a href = "/"
        id = {data[i].id}  // 함수 바깥에 data[i].id가 있으므로 안에 변수를 넣어서 쓸 수 있도록 해줌.
        // 이후 onChangePage에서 event.target.id로 산입이 가능.
        onClick = {e => {            
            e.preventDefault(); //본래 a태그의 기능을 막는 용도. e는 event이자, 이 anchor태그 자체를 가리킴.
            // 내가 클릭한 아이디가 몇번째인지를 먼저 알아야 하므로 함수에 이와 같은 식을 넣어준다.
            props.onChangePage(Number(e.target.id));            
        }}>{data[i].title}</a></li>);
        // 콘솔창에서 li키에 고유값을 넣으라는 warning이 있었으므로, data[i].id를 li의 유일한 key값으로써 설정하였음
    }
    return(
        <nav>
            <ol>
                {lists}
            </ol>
        </nav>
        );
};

    


export default TOC;