// test() : 문자열에 패턴이 있는지 검사하고 결과를 true / false 반환
const regExp = /World/;
console.log(regExp.test("Hello World!")); // true > 정규표현식이 성립한다.

const regExp1 = /HELLO/;
console.log(regExp1.test("hello world!")); // false > 정규표현식이 성립하지 않는다. > HELLO가 포함되어 있지 않다.

// exec() : 문자열에서 패턴에 일치하는 첫 번째 결과를 반환
const result = /가장+/.exec("가장 큰 실수는 포기입니다.");
console.log(result); // ["가장"]

// match() : 문자열에서 패턴에 일치하는 모든 결과를 배열로 반환
const phone = "010-1234-5678 010-5006-4146 02-7894-33333";
const regNum = phone.match(/\d{3}-\d{4}-\d{4}/g); // d > digit 3자리-4자리-4자리 패턴, g > 반복
console.log(regNum); // ["010-1234-5678", "010-5006-4146"]

// 웹사이트 주소 찾기
const regex = /https?:\/\/[\w-\.]+/g;
const urls = "http://www.naver.com https://google.co.kr awdawdaw";
console.log(urls.match(regex));

// 이메일 검사 하기
const regex_email = /^([a-z]+\d*)+(\.?\w+)+@\w(\.\w{2,3})+$/;
console.log(regex_email.test("example@gmail.co.kr")); // true