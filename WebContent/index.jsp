<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="resources/styles.css">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form method="post" id="loginForm">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" placeholder="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" placeholder="password" required>
            </div>
            <div class="form-group checkbox">
	            <div class="checkbox">
				    <label>
				        <input class="align-middle" type="checkbox" id="rememberMe"/>
				        Remember me
				    </label>
				</div>
                <!-- <input type="checkbox" id="rememberMe"> -->
                <!-- <label for="rememberMe">Remember me</label> -->
            </div>
            <button type="submit" class="login-btn">Login</button>
        </form>
    </div>
    <script src="resources/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
