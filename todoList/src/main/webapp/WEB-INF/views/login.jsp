<html>
<head></head>
<body>
	<h1>Page d'Authentification</h1>

	<c:if test="${error}">
		<p style="color: red">Erreur d'authentification: nom utilisateur ou mot de passe erroné</p>
	</c:if>

	<c:if test="${logout}">
		<p style="color: blue">Vous êtes deconnecté</p>
	</c:if>
	<form name='loginForm' action="authenticate" method='POST'>
		<table>
			<tr>
				<td>Nom utilisateur:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Mot de passe:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>