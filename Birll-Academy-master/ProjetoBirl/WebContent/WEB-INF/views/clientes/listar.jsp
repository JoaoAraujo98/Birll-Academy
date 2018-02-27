<%@page import="academia.config.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="academia.daos.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	
	<style> 
		body{
			text-align: center;
		}
		
	</style>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de clientes</title>
	</head>

	<body>
		
		<h1>LISTA DE CLIENTES</h1>
		
		<jsp:useBean id="dao" class="academia.daos.ClienteDAO"></jsp:useBean>
	
		
	
		<table border =3; align="center">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cpf</th>
				<th>Telefone</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
	
			<c:forEach var="cliente" items="${clientes}">
				
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.fone}</td>
					<td>${cliente.email}</td>
					<td>${cliente.endereco}</td>
					<td><fmt:formatDate value="${cliente.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
					<td><a href="/ProjetoBirl/clientes/remover?&id=${cliente.id}">Remover</a></td>
					<td><a href="/ProjetoBirl/clientes/selecionar?&id=${cliente.id}">Alterar</a></td>
					<td><a href="/ProjetoBirl/clientes/pagarmensalidade?&id=${cliente.id}">Pagar Mensalidade</a></td>
					<td><a href="/ProjetoBirl/clientes/vermensalidades?&id=${cliente.id}">Ver Mensalidades</a></td>
				</tr>
			</c:forEach>
		
	
		</table>
		
		
		
		
		
	</body>
</html>