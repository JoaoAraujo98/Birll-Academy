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
	body {
		text-align: center;
	}
	
	table {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 100%;
	}
	
	td, th {
		border: 1px solid #dddddd;
		text-align: left;
		padding: 8px;
	}
	
	tr:nth-child(even) {
		background-color: #dddddd;
	}
	
	
</style>

<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mensalidades</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>

	<body>
		<center><h1>Mensalidades</h1></center>
	  <div class="w3-bar w3-light-grey">
    <a href="/ProjetoBirl/" class="w3-bar-item w3-button">Inicio</a>
    <div class="w3-dropdown-hover">
      <button class="w3-button">Ações</button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="/ProjetoBirl/clientes/form" class="w3-bar-item w3-button">Adicionar Cliente</a>
        <a href="/ProjetoBirl/clientes/selecionarnome" class="w3-bar-item w3-button">Buscar Cliente por Nome</a>
         <a href="/ProjetoBirl/clientes/formfluxo" class="w3-bar-item w3-button">Fluxo Mensal</a>
        
      </div>
    </div>
  </div><br><br>
		
		
		
		<jsp:useBean id="dao" class="academia.daos.ClienteDAO"></jsp:useBean>
	
		
	
		<table border =3; align="center">
			<tr>
				<th>Codigo</th>
				<th>ID do Cliente</th>
				<th>Valor</th>
				<th>Data de Pagamento</th>
				<th>Inicio da Mensalidade</th>
				<th>Fim da Mensalidade</th>
				
			</tr>
	
			<c:forEach var="mensalidade" items="${mensalidades}">
				
				<tr>
					<td>${mensalidade.codigo}</td>
					<td>${mensalidade.idcliente}</td>
					<td>${mensalidade.valor}</td>
					
					
					<td><fmt:formatDate value="${mensalidade.datapagamento.time}"
						pattern="dd/MM/yyyy" /></td>
					
					
					<td><fmt:formatDate value="${mensalidade.datainicio.time}"
						pattern="dd/MM/yyyy" /></td>
					
					<td><fmt:formatDate value="${mensalidade.datafim.time}"
						pattern="dd/MM/yyyy" /></td>
					
					
					
				</tr>
			</c:forEach>
		
	
		</table>
		
		
		
		
		
	</body>
</html>