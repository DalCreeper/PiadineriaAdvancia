document.addEventListener("DOMContentLoaded", function () {
	const loginForm = document.querySelector("form");
	const loginButton = document.getElementById("login-btn");
	
	loginForm.addEventListener("submit", function() {
	  overlay.style.display = "flex";
	  loginButton.disabled = true;
	});
});