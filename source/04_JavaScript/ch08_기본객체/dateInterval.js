/* dateInterval.js 구현하는 js파일 */
let now = new Date();
let openday = new Date(2023, 5, 26, 9, 30, 0);

Date.prototype.getIntervalDay = function (that) {
    // now.getIntervalDay(openday): now는 this, openday는 that을 넣음.
    // now가 new Date(), openday는 개강일을 넣은 상태임
//     if (this>that){
//         let intervalMillisec = this.getTime() - that.getTime(); // this(현재)-that(개강일)을 밀리세컨으로 빼서 계산
//     } else {
//         let intervalMillisec = that.getTime() - this.getTime();
//     }
// return intervalMillisec;
// };
    let intervalMillisec = Math.abs(this.getTime() - that.getTime());
    let day = Math.trunc(intervalMillisec / (1000*60*60*24)); // 밀리세컨을 일단위로 만들기 위해 + 소숫점버림
    return day;
};


console.log('개강일부터 오늘까지 날짜: ' + now.getIntervalDay(openday) + '일');