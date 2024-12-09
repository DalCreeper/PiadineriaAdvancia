/**
 * 
 */

const validUsername = "Mike";
const validPassword = "Prova.1";

const loginForm = document.getElementById('loginForm');
const errorMessage = document.getElementById('errorMessage');

loginForm.addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if(username === validUsername && password === validPassword) {
        alert('Login successful!');
        const rememberMe = document.getElementById('rememberMe').checked;
        if(rememberMe) {
            alert('You chose to stay logged in.');
        }
    } else {
        errorMessage.style.display = 'block';
    }
});
