const lightBtn = document.getElementById('light-switch');

if (window.matchMedia("(prefers-color-scheme: light)").matches) {
    document.documentElement.classList.add('light');
    lightBtn.textContent = '☽';
}

const brightToggle = () => {
  if (document.documentElement.classList.contains('light')) {
    document.documentElement.classList.remove('light');
    document.documentElement.classList.add('dark');
    lightBtn.textContent = '☀';
  } else {
    document.documentElement.classList.remove('dark');
    document.documentElement.classList.add('light');
    lightBtn.textContent = '☽';
  }
};

lightBtn.addEventListener('click', brightToggle);
