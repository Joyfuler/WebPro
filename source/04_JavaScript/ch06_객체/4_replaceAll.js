// 위와 같은 str 변수의 0을 x로 바꾸고 싶다면?
// var str = '안녕00방가00좋은 수요일00내일은 목요일'
// console.log ('원본 : ' + str);
// var splitStr = str.split('00'); // stringtokenizer랑 비슷...? 00을 기준으로 배열로 쪼개짐.
// // --> splitStr = ['안녕','방가', '좋은 수요일', '내일은 목요일'];
// console.log ('분할된 str : ' + splitStr);
// var joinStr = splitStr.join('x'); // join은 각 배열들을 x라는 단어로 묶는 함수.
// console.log('Join된 Str : ' + joinStr);

function replaceAll(txt, a, b) {
  // 모든 텍스트와 기존 텍스트, 바꿀 텍스트 총 3개의 매개변수를 준비.
  var splitStr = txt.split(a); // a라는 단어를 기준으로 배열로 쪼갬.
  var joinStr = splitStr.join(b); // 쪼개진 배열에 b를 다시 넣어 결과적으로 a가 b로 변경됨.
  return txt.split(a).join(b);
}
// 위 3줄짜리를 1줄로 바꾸는 방법

// var replaceStr= replaceAll(str,'0','!');
// console.log(replaceStr);
// var replaceStr2 = replaceAll(str,'0',''); //0을 아예 빼버리는 과정.
// console.log(replaceStr2);
