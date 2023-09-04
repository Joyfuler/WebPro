import "./App.css";
import Subject from "./Components/Subject";
import TOC from "./Components/TOC";
import Control from "./Components/Control";
import ReadContent from "./Components/ReadContents";
import { useState } from "react";
import CreateContent from "./Components/CreateContent";
import UpdateContent from "./Components/UpdateContent";
var maxId = 4;
function App() {
  //렌더링을 해야 하는 경우, 변수는 다른 식으로 선언해야 한다.
  //클래스의 경우는 setState를, 함수의 경우는 hook을 이용함.

  // const _mode = useState('read');
  //let mode = _mode[0] // mode의 0번째 배열에는 welcome이 존재.
  //const setMode = _mode[1]; // mode 상태변경용으로 사용할 변수
  const [mode, setMode] = useState("welcome");
  const [selectedId, setSelectedId] = useState(0); // 우선 0으로 초기값선언.
  const [contents, setContents] = useState([
    { id: 1, title: "HTML", desc: "HTML is HyperText Markup Language" },
    { id: 2, title: "CSS", desc: "CSS is For Design" },
    { id: 3, title: "JavaScript", desc: "JavaScript is for Interactive" },
    { id: 4, title: "React", desc: "React is JavaScript Language" },
  ]); // contents의 내용들을 useState로 그대로 산입.
  // useState는 값을 배열로 리턴하므로 배열변수를 선언하여 1줄로 정리하였음.

  
  const subject = "WEB"; // props의 사용을 줄이기 위해 변수로 빼는 작업
  // const contents = [{id:1, title:'HTML', desc: 'HTML is HyperText Markup Language'}
  // ,{id:2, title:'CSS', desc: 'CSS is For Design'}
  // ,{id:3, title:'JavaScript', desc: 'JavaScript is for Interactive'}
  // ,{id:4, title:'React', desc: 'React is JavaScript Language'}];

  //mode에 따라서 다른 것을 출력하도록 하는 변수
  const welcome = { title: "Welcome", desc: "Happy React!" };
  let _article,
    _content = null;
  let getReadContent = () => {
    for (var i = 0; i < contents.length; i++) {
      if (contents[i].id === selectedId) {
        // for문으로 각 id를 비교한 후, id가 같을 때의 값을 리턴함.
        return contents[i]; // id가 같으면 각 title과 desc를 출력하도록 변경함.
      }
    }
  };

  // welcome모드라면 _article에 ReadContent의 props를 welcome으로 하고, 그 아래 값들을 출력하게 함.
  if (mode === "welcome") {
    _article = (
      <ReadContent title={welcome.title} desc={welcome.desc}></ReadContent>
    );
  } else if (mode === "read") {
    // 해당 제목을 클릭하면, 그 제목의 id를 가져와 그것이 selectedId와 같을 때 해당 title과 desc를 출력하도록 함.
    // for (var i=0; i<contents.length; i++){ --> 윗쪽 GetReadContent 함수 내에 넣는 것으로 이사하였음. 함수 바깥으로 나가지 않도록 주의!
    // if (contents[i].id === selectedId){
    _content = getReadContent(); //함수가 제대로 동작하는지 확인함.
    _article = (
      <ReadContent title={_content.title} desc={_content.desc}></ReadContent>
    );
  } else if (mode === "create") {
    _article = (
      <CreateContent
        onCreate={function (_title, _desc) {
          // createcontent.js에서 받은 title과 desc를 받아 추가하는 함수. id는 ++ 을 통해 1씩 증가
          _content = { id: ++maxId, title: _title, desc: _desc };
          let _contents = Array.from(contents);
          _contents.push(_content);
          setContents(_contents); // hook함수인 useState로 렌더링이 다시 일어나도록 함.
          // contents.push (_content); 처럼 입력하는 경우 실제로는 변경되지 않음. (렌더링x)
          setMode("read");
          setSelectedId(maxId);
        }}
      ></CreateContent>
    );
  } else if (mode === "update") {
    // 무언가를 선택한 후에 수정 버튼이 나와야 하므로, id가 0이 되어서는 안 됨.(welcome 상태이므로)
    // create와 비슷하고, id가 0만 아니면 되므로 _content를 재사용해도 됨.
    if (selectedId === 0) {
      _article = <h4>수정할 데이터를 선택 후 업데이트 기능을 이용하세요</h4>;
    } else {
      _content = getReadContent();
      _article = <UpdateContent data = {_content}
      onUpdate = {function(_id,_title,_desc){ // 수정은 매개변수가 3개이므로 
        _content = {id:_id, title: _title, desc: _desc}
        let _contents = Array.from(contents); //원본데이터를 _contents에 똑같이 복제함.
        for (var i=0; i<_contents.length; i++){
          if (_contents[i].id === _id){ // 만일 _contents배열의 어떤 id와 매개변수로 들어온 _id가 서로 같으면?
            _contents[i] = _content;
            break;
          }
        }
        setContents(_contents);
        setMode('read');
      }}></UpdateContent>
    }
  } 

  return (
    <div className="App">
      <Subject
        title={subject}
        onChangePage={() => {
          setMode("welcome");
          setSelectedId(0);
          // mode = 'welcome' 처럼 단순변경은 불가능!!!!!!!
        }}
      ></Subject>
      {/* 이벤트걸기 - 맨 위의 WEB 클릭시 welcome모드로 가게 할 것. */}
      <TOC
        data={contents}
        onChangePage={(_id) => {
          setMode("read");
          setSelectedId(_id); // selectedid는 클릭한 것이 매개함수로 들어와 변경됨.
          // HTML 클릭시 selectedId를 1로, css 클릭시 selectedId를 2로.
        }}
      ></TOC>
      <Control
        onChangeMode={(_mode) => {          
          if (_mode === "delete") {
            if (selectedId !== 0 && window.confirm('정말 삭제하시겠습니까?')){ // welcome 모드인 경우 selected_id는 0이 됨.            
              // contents를 복제한 뒤, id를 비교. id가 일치하는 경우 해당하는 배열의 값들을 삭제함. (split)

              //마찬가지로 원본 바로 삭제는 x, 복사를 만든 후 작업
              let _contents = Array.from(contents); 
              for (var i=0; i<_contents.length; i++){
                if (_contents[i].id === selectedId) // 선택한 내용의 id와 for문을 돌린 것이 일치할 때 삭제
                _contents.splice(i,1); // i번째에서 1개, 즉 i번째만 제거.
                setContents(_contents); // hook변경
                if (_contents.length>0){
                  setMode('read');
                  setSelectedId(_contents[0].id) // 맨첫번째방의 id를 변수로. (1은 삭제될 수 있으니 위험)                  
                  // 삭제시 welcome 모드로
                } else {
                  setMode('welcome');
                  setSelectedId(0);
                }

                
              }
              
            } else if (selectedId === 0) {
              alert('삭제할 컨텐츠를 선택한 후 삭제해야 합니다');
            }
          } else { 
            setMode(_mode); // 삭제할 때를 제외하면 매개변수로 들어온 _mode로 모드를 변경.
          }
        }}
      ></Control>
      {/* 위에서 mode===welcome일 때 설정한 _article이 ReadContent 컴포넌트 내용이므로, _article을 대신 넣어주면 됨.
       */}
      {_article}
    </div>
  );
}

export default App;
