<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entregas" var="linkPaginas" />

<%@ page import="java.util.List"%> 
<%@ page import="com.entregas.model.Estado"%>
<%@ page import="com.entregas.dao.EstadoDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>4 - Cadastro Usuario</title>
</head>
<body>
	<form action="${linkPaginas}" method="post">
		<h3>Cadastro de usuário</h3>
		<br> Nome: <input type="text" name="nome" required/> <br> 
		Senha: <input type="password" name="senha" required/><br> CEP: <input type="text" name="cep" placeholder="12345-678" pattern="[0-9]{5}-[0-9]{3}" required/> <br> 
			Rua: <input type="text" name="rua" required /><br>
		Bairro: <input type="text" name="bairro" required /> <br> 
		Municipio: <input type="text" name="municipio" required/> <br>
		 Estado: <select name="estado">		
		
			<c:forEach items="${estados}" var="estado">
				<option value="${estado.sigla}">${estado.nome}</option>
			</c:forEach>
		</select> Numero: <input type="number" min="0" max="1000000000" step="0" name="numero" /> Complemento: <input type="text" name="complemento" /> <br>
		 <hr>
		 	<input type="hidden" name="acao" value="CadUsuario"> 
			<input	type="submit"> <br><br> <input type="reset"><br>

	</form>
</body>
</html>