<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entregas" var="linkPaginas" />

<!DOCTYPE html>
<html>
<head>
<title>3 - Pagina inicial</title>
</head>
<body>
	<form action="${linkPaginas}" method="post">

		Usuario: <input type="text" name="usuario" required/> <br>
		<br> Senha: <input type="password" name="senha" required/> <br>
		<br> <input type="submit" name="acao" value="Login" /> <br>
		
		<a href="entregas?acao=FormCadastro"> <input type="button" value= "Fazer Cadastro"> </a>
<br>

	</form>
</body>
</html>
