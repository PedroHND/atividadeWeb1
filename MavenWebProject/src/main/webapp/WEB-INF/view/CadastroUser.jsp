<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entregas" var="linkPaginas" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>0 - Cadastro Usuario</title>
</head>
<body>
	<form action="${linkPaginas}" method="post">
	<h3>Cadastro de usuário</h3><br>
	Nome: <input type="text" name="nome"/> <br>
	Senha: <input type="password" name="senha"/><br>
	CEP: <input type="text" name="cep"> <br>
	Rua: <input type="text" name="rua"/><br>
	Bairro: <input type="text" name="bairro"/> <br>
	Municipio: <input type="text" name="municipio">
	Estado: <select>
	<c:forEach items="${estados }" var="estado">
	<option value="${estado.sigla}">${estado.sigla}</option>
	</c:forEach>
	</select>
	Numero: <input type="text" name="numero"/> <br>
	Complemento: <input type="text" name="complemento"> <br>
	
		
	<input type="submit">
	<input type="reset"><br>
	
	</form>
</body>
</html>