<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/atividade/entregasJson" method="post">
<input type="hidden" name="id" value="${pedidoUsuario.id}">
<input type="hidden" name="prazo" value="${pedidoUsuario.prazo}">
<input type="hidden" name="frete" value="${pedidoUsuario.frete}">
<input type="hidden" name="sigla" value="${estadoEntrega.sigla}">
<input type="hidden" name="nome" value="${estadoEntrega.nome}">

prazo: ${pedidoUsuario.prazo} <br>
frete: ${pedidoUsuario.frete}<br>
estado: ${estadoEntrega.nome} - ${estadoEntrega.sigla}<br>

<input type="submit">
</form>
</body>
</html>