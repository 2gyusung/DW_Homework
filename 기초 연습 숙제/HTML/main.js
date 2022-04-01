// 클래스 입력
const toggleBtn = document.querySelector('.navbar_toogleBtn');
const menu = document.querySelector('.navbar_menu');
const icons = document.querySelector('.navbar_icons');

// click 할 떄에 호출
toggleBtn.addEventListener('click', () => {
  // 
  menu.classList.toggle('active');
  icons.classList.toggle('active');
});
