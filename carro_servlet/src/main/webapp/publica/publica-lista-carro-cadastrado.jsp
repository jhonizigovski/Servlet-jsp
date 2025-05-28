<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.7.1-dist/jquery-3.7.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>


</head>
<body>
	 <div class="container mt-4">
    <div class="alert alert-success">${mensagem}</div>

    <div class="card" style="width: 24rem;">
      <div class="card-body">
        <h5 class="card-title">Carro Cadastrado</h5>
        <p class="card-text">
          <strong>ID:</strong> ${carroGravado.id}<br>
          <strong>Marca:</strong> ${carroGravado.marca}<br>
          <strong>Nome:</strong> ${carroGravado.nome}<br>
          <strong>Modelo:</strong> ${carroGravado.modelo}<br>
          <strong>Cor:</strong> ${carroGravado.cor}<br>
          <strong>Data de Fabricação:</strong> 
          <fmt:formatDate value="${carroGravado.fabricacao}" pattern="dd/MM/yyyy"/><br>
          <strong>Chassi:</strong> ${carroGravado.chassi}<br>
        </p>
      </div>
       <a href="${pageContext.request.contextPath}/auth/admin?acao=listar" class="btn btn-primary">
    Lista de carros
  </a>
    </div>
  </div>
</html>