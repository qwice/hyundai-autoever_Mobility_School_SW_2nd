// const prompt = require("prompt-sync")();
// let num = Number(prompt("정수 입력 : "));

let num = 10;
// if, if ~ else, if ~ else if ~ else

if(num >= 0) {
    console.log(`${num}은 양수 입니다.`);
} else {
    console.log(`${num}은 음수 입니다.`);
}

if(num > 100) {
    console.log(`${num}은 100보다 커요.`);
} else if(num < 100) {
    console.log(`${num}은 100보다 작아요.`);
} else {
    console.log(`${num}은 100과 같아요.`);
}

// switch ~ case : 조건값이 와야 함
let day = new Date().getDay();
switch (day) {
  case 0:
    console.log("일요일");
    break;
  case 1:
    console.log("월요일");
    break;
  case 2:
    console.log("화요일");
    break;
  case 3:
    console.log("수요일");
    break;
  case 4:
    console.log("목요일");
    break;
  case 5:
    console.log("금요일");
    break;
  case 6:
    console.log("토요일");
    break;
}

const dayStr = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
console.log(dayStr[day]);