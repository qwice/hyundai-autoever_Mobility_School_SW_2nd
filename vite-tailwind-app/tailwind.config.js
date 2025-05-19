// /** @type {import('tailwindcss').Config} */
// export default {
//   content: [],
//   theme: {
//     extend: {},
//   },
//   plugins: [],
// }

module.exports = {
    content: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
    theme: {
        extend: {
            fontSize: {
                h1: "2.25rem", // 36px
                h2: "1.875rem", // 30px
                h3: "1rem", // 24px
                // 필요에 따라 추가
            },
        },
    },
    plugins: [],
};
