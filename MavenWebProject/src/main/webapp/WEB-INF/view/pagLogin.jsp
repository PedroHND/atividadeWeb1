<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entregas" var="linkPaginas" />

<!DOCTYPE html>
<html>
<head>
<title>0 - Pagina inicial</title>
</head>
<body>
	<form action="${linkPaginas}" method="post">

		Usuario: <input type="text" name="usuario" /> <br>
		<br> Senha: <input type="password" name="senha" /> <br>
		<br> <input type="submit" name="entrar" value="enviar" /> <br>
		<br> <input type="hidden" name="acao" value="login"/> 
		<input type="submit" value="Cadastrar Usuario"/>

	</form>
</body>
</html>
