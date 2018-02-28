<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <title>--Formulário Cliente--</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8" />
    <!--   <link href="ContatoEstilo.css" rel="stylesheet" media="all" />
    <script src="JavaScript1.js"></script>-->
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
<div class="w3-container">
  <center><h1>Birl Academy</h1></center>

  <div class="w3-bar w3-light-grey">
    <a href="/ProjetoBirl/" class="w3-bar-item w3-button">Inicio</a>
    <div class="w3-dropdown-hover">
      <button class="w3-button">Ações</button>
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="/ProjetoBirl/clientes/form" class="w3-bar-item w3-button">Adicionar Cliente</a>
        <a href="/ProjetoBirl/clientes" class="w3-bar-item w3-button">Listar Cliente</a>
        <a href="/ProjetoBirl/clientes/selecionarnome" class="w3-bar-item w3-button">Buscar Cliente por Nome</a>
        
      </div>
    </div>
  </div>
</div>
   <center> <form action="/ProjetoBirl/clientes" method="post">

        <h2>Cadastre-se</h2>

        <p class="nome">
            <label for="nome">Nome:</label>
            <input type="text" id="nomeid" placeholder="seu nome" required="required" name="nome" />
            
        </p>
        <p>
        	<label for="cpf">CPF:</label>
            <input type="text" id="cpfid" placeholder="xxx.xxx.xxx-xx" name="cpf" />
            
        </p>
        <p class="fone">
       	 	<label for="fone">Fone:</label>
            <input type="text" id="foneid" placeholder="(xx)xxxx-xxxx" name="fone" />
            

        </p>
        
         <p>
        	<label for="endereco">Endereço:</label>
            <input type="text" id="enderecoid" placeholder="nome da rua, número" name="endereco" />
            
        </p>
         <p>
        	<label for="email">Email:</label>
            <input type="text" id="emailid" placeholder="email@mail.com" name="email" />
            
        </p>
            <p>
        	<label for="dataNascimento">Data de nascimento:</label>
            <input type="text" id="dataNascimentoid" placeholder="dd/MM/yyyy" name="dataNascimento" />
            
        </p> 
        <p class="submit">
            <input type="submit" onclick="Enviar();" value="Enviar" />
        </p>

    </form></center>
</body>

</html>