<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
  "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="resources/css/reset.css" />
<link rel="stylesheet" type="text/css" href="resources/css/structure.css"/>
</head>
<body>
<form class="box login" action="./login" method="GET">
	<fieldset class="boxBody">
	  <label>Username</label>
	  <input type="text" id="login" name="login" tabindex="1" placeholder="Login" required>
	  <label>Password</label>
	  <input type="password" id="password" name="password" placeholder="Password" tabindex="2" required>
	</fieldset>
	<footer>
		<label><a href="./taches" class="rLink" tabindex="3">Go to task management</a><br/>
		<a href="./affectations" class="rLink" tabindex="4">Go to affectation management</a></label><label></label>
	  <input type="submit" class="btnLogin" value="Login" tabindex="5">
	</footer>
</form>
</body>
</html>
