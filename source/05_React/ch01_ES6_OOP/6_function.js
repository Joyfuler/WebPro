function sum(x=0,y=0){
    return x+y;
}
console.log ('sum(10,2) :' , sum(10,2)); // 12
console.log('sum(10)', sum(10)); //본래는 undefined에 10을 더한 결과 NAN으로 return.
// 그러나 매개변수가 이미 0으로 초기화되었으므로 0+10이 되어 10이 return됨.
// 그런데 첫 함수에 매개변수로 올 때 x,y값을 미리 지정할 수 있음.