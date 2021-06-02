const lightBtn = document.getElementById('light-switch');

const stored = localStorage.getItem('prefers-color-theme');
let osPrefersLight = window.matchMedia('(prefers-color-scheme: light)').matches

const addDark = () => {
  document.documentElement.classList.remove('light');
  document.documentElement.classList.add('dark');
  lightBtn.textContent = '☀';
};

const addLight = () => {
  document.documentElement.classList.remove('dark');
  document.documentElement.classList.add('light');
  lightBtn.textContent = '☽';
};

if (stored === 'light') {
  addLight();
} else if (stored === 'dark') {
  addDark();
} else {
  if (osPrefersLight) {
    addLight();
  } else {
    addDark();
  }
}

const brightToggle = () => {
  if (document.documentElement.classList.contains('light')) {
    addDark();
    localStorage.setItem('prefers-color-theme', 'dark');
  } else {
    addLight();
    localStorage.setItem('prefers-color-theme', 'light');
  }
};

lightBtn.addEventListener('click', brightToggle);
