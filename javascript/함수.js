// 함수란? 특정작업을 반복하거나 재사용할 수 있도록 작성된 코드 블록
// 입력값을 받을 수 있으며 반환값을 줄 수 있음
// 함수 선언문 : 호이스팅 가능(끌어올림)
console.log(sum(100, 200));
console.log(sum(1.1, 2.2));
console.log(sum("아이브", "안유진"));

function sum(a, b) {
    return a+b;
}

// 함수 표현식 : 변수의 익명 또는 기명 함수 할당, 호이스팅 안됨
const mul = function (a, b) {
    return a*b;
}

console.log(mul(5, 3));

// 화살표 함수 : 생략 가능한 모든것을 생략, 간결한 표현에 유리, 콜백 함수에서 익명의 함수를 사용하는 경우 주로 사용
const div = (a, b) => a/b;
console.log(div(10, 4));

// 즉시 실행 함수 : 호출 없이도 실행되는 함수
(function() {
    console.log("즉시 실행 함수입니다.");
})();

// 기본값 할당
function sum1(a, b, c = 300) {
    return a+b+c;
}

console.log(sum1(100, 200)); // argument, parameter > 인수, 인자

// callback 함수 : 콜백함수는 비동기처리와 아주 밀접한 관계를 가짐
// 콜백함수란? 함수의 인자로 다른 함수를 전달하여, 그 함수가 실행될 때 호출되는 함수
// 사용자 이벤트 처리 : btn.addEventListener("click", callback{})
// 서버와 통신 시 사용 : axios 기반의 비동기 통신(async / await 방식 사용)
// 파일 입출력 시 : 속도 차이가 발생하므로
// 의도적으로 지연이 필요한 경우에도 사용

function birdSing() {
    console.log("새가 즐겁게 노래합니다.");
}

function catCry() {
    console.log("고양이가 슬프게 웁니다.");
}

function dogDance() {
    console.log("강아지가 신나게 춤을 춥니다.");
}

function checkAnimalMood (mood) { // 일반적인 형식
    if(mood === "happy") birdSing();
    else if(mood === "sad") catCry();
    else dogDance();
}

checkAnimalMood("happy");

// 콜백함수
function checkAnimalMoodCallback(mood, happyAction, sadAction) {
    if(mood === "happy") happyAction();
    else if(mood === "sad") sadAction();
}

checkAnimalMoodCallback("happy", dogDance, catCry);
checkAnimalMoodCallback("happy", () => {console.log("아무것도 안함");}, catCry);

// 콜백 타이머
function buyToy(item, price, quantity, callback) {
    console.log("🧒 아이가 '" + item + "' 장난감을 " + quantity + "개 골라서 엄마에게 가져갔습니다.");
    setTimeout(function () {
        console.log("💰 계산이 필요합니다.");
        let total = price * quantity;
        callback(total);
    }, 2000);
}

function pay(total) {
    console.log("엄마: '지불할 금액은 " + total + "원입니다.'");
    console.log("🧒 아이: '와! 고마워요, 엄마!' 🎉");
}

buyToy("공룡 장난감", 3000, 3, pay);

// 클로저 : 함수가 해당 함수의 스코프 외부에 있는 변수에 접근할 수 있는 메커니즘
function counter() {
    let count = 0;
    return {
        increment: function() {
            count++;
            console.log(count);
        },
        decrement: function() {
            count--;
            console.log(count);
        }
    }
}

const myCnt = counter();
console.log(myCnt);
myCnt.increment();
myCnt.increment();
