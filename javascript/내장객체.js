// 문자열을 다루는 string 객체
// 특정 문자열 포함 여부 : includes(), indexOf
const email = "jks2024@gmail.com"; // 실제론 이렇게 확인하지 않고 정규식으로 확인함
if(!email.includes("@")){
    console.log("잘못된 이메일 형식 입니다.");
} else {
    console.log("이메일 형식 입니다.");
}

if(email.indexOf("@") !== -1) {
    console.log("잘못된 이메일 형식 입니다.");
}

// 슬라이싱 : 문자열에서 특정 부분 문자열 추출
const fruits = "Apple, Banana, Kiwi";
// const subStr = fruits.slice(1, -5); // 음수 허용
const subStr = fruits.slice(1, 5);
const subStr1 = fruits.substring(1, 5); // 음수를 허용하지 않는다.
console.log(subStr);
console.log(subStr1);

// replace : 문자열 대체
let str = "지구오락실, 이영지, 안유진, 미미, 이은지";
let n = str.replace("이은지", "나영석"); // 같은 값이 2개 있으면 앞에 있는 인덱스값만 바뀜
console.log(n)

// 문자열 결합
let text = "안녕하세요.";
text += "오늘은 ";
text += "날씨가 아주 별로예요. ";
text += "집에 가고 싶어요~~";
console.log(text);

const text1 = "안녕하세요.";
const text2 = text1.concat(" 오늘은");
const text3 = text2.concat(" 날씨가 아주 별로에요.");
console.log(text3);