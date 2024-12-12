<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PiadineriaAdvancia Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/stylesLogin.css">
</head>
<body>
	<div class="login-container">
		<h2>Login</h2>
		<form action="LoginServlet" method="post">
			<div class="form-group">
				<label for="username">Username</label> <input name="username"
					type="text" id="username" placeholder="username" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input name="password"
					type="password" id="password" placeholder="password" required>
			</div>
			<%
				String errorMessage = (session != null) ? (String) session.getAttribute("errorMessage") : null;
				if (errorMessage != null) {
			%>
					<p class="form-error"><%=errorMessage%></p>
			<%
				}
			%>
			<div class="form-group checkbox">
				<label for="rememberMe"> <input name="rememberMe"
					class="align-middle" type="checkbox" id="rememberMe" /> Remember me
				</label>
			</div>
			<button type="submit" class="login-btn">Login</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="resources/js/script.js"></script>
</body>
</html>
