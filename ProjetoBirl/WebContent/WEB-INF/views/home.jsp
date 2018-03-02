<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body{
background-image:url("http://blog.visme.co/wp-content/uploads/2017/07/50-Beautiful-and-Minimalist-Presentation-Backgrounds-037.jpg");
}	}

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página incial</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>


<body>

	 <c:import url="cabecalho.jsp" />
	 
	<div class="w3-container">
  

  <div class="w3-bar w3-light-grey">
    <a href="/ProjetoBirl/" class="w3-bar-item w3-button">Inicio</a>
    <div class="w3-dropdown-hover">
      <button class="w3-button">Ações</button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="/ProjetoBirl/clientes/form" class="w3-bar-item w3-button">Adicionar Cliente</a>
        <a href="/ProjetoBirl/clientes" class="w3-bar-item w3-button">Listar Cliente</a>
        <a href="/ProjetoBirl/clientes/selecionarnome" class="w3-bar-item w3-button">Buscar Cliente por Nome</a>
         <a href="/ProjetoBirl/clientes/formfluxo" class="w3-bar-item w3-button">Fluxo Mensal</a>
        
      </div>
    </div>
  </div>
</div>

<center><h2>Bem vindo</h2></center>
	<p>A Birl Academy é uma academia voltada para a prestação de serviços de fitness e wellness, baseada na excelência no atendimento personalizado por profissionais qualificados e altamente 
	treinados para a melhor prescrição do exercício. Possuímos diversas atividades, sempre desenvolvidas por profissionais de educação física e contando também com um profissional de fisioterapia
	 para a orientação do exercício no método Pilates. Estaremos de braços abertos esperando a sua visita 
	 e certos que juntos poderemos alcançar o seu objetivo com muito mais qualidade e eficiência!!!</p>





</body>
</html>