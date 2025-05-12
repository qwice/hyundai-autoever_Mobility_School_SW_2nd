// 문서의 최상위 노드
let doc = document.firstChild;
console.log(doc);

// 실제 HTML 루트 요소
let html = document.firstElementChild;
console.log(html);

// ID로 선택하기
const el = document.getElementById("title");
console.log(el);
console.log(el.innerText); // 내부 내용만 가져옴.

// 클래스명으로 선택하기
const classEls = document.getElementsByClassName("text");
console.log(classEls);
for(let els of classEls) {
    console.log(els);
}

// 태그명으로 선택하기
const tagEls = document.getElementsByTagName("p");
console.log(tagEls);

// querySelector
const queryEl = document.querySelector("#title"); // "여기", 따움표안에 넣으면 알아서 판단함, .xx > 클래스, #xx > id, xx > 태그
console.log(queryEl);

const queryEls = document.querySelectorAll("p");
console.log(queryEls);