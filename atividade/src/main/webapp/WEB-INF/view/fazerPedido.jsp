<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List"%> 
<%@ page import="com.entregas.model.Estado"%>
<%@ page import="com.entregas.dao.EstadoDao"%>
<%@ page import="com.entregas.model.Endereco"%>
<%@ page import="com.entregas.dao.EnderecoDao"%>
<%@ page import="com.entregas.model.Usuario"%>
<%@ page import="com.entregas.dao.UsuarioDao"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>4 - Fazer Pedido</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />

<br>


Usuario: ${usuarioLogado.nome} <input type="hidden" name= "idUser" value="${usuarioLogado.id}">
<hr>
Endereco: <br>
Rua: ${usuarioLogado.endereco.rua } Numero: ${usuarioLogado.endereco.numero } 
  <c:if test="${not empty usuarioLogado.endereco.rua }">
  	Complemento: ${usuarioLogado.endereco.complemento } 
  </c:if> <br>
	Bairro: ${usuarioLogado.endereco.bairro}<br>
  	CEP: ${usuarioLogado.endereco.cep}<br>
	Municipio: ${usuarioLogado.endereco.municipio}<br>
	Estado: ${usuarioLogado.endereco.estado} <br> 
	<input type="hidden" name="id" value="${pedidoUsuario.id }">

<hr>
<h3>Catalogo</h3>
<hr>
<ul>
<c:forEach items="${produtos }" var="produto">
	
	<li>
	Nome: ${ produto.nome} Valor(R$): ${produto.preco } <br>
	<a href="/atividade/entregas?acao=AddProduto&idUser=${usuarioLogado.id}&id=${pedidoUsuario.id}&produto=${produto.id}"><input type="submit" value="Adicionar"></a>
	</li> 
	<hr>
</c:forEach>
</ul>
<hr>
<h3>Produtos</h3>
<form action="/atividade/entregas" method="post">

<input type="hidden" name= "idUser" value="${usuarioLogado.id}">
<input type="hidden" name="id" value="${pedidoUsuario.id }">

<c:if test="${not empty pedidoUsuario.listaProduto }">
<ul>	
${ pedidoUsuario.listaProduto}
</ul>

<br>
valor total = ${ pedidoUsuario.valor}
</c:if>
<br>

<br>
<a href="/atividade/entregas?acao=CalcularFrete"><input type="submit" name="acao" value="CalcularFrete"></a>
</form>
</body>
</html>