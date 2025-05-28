<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carros</title>


<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.7.1-dist/jquery-3.7.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>


</head>
<body>
	<jsp:include page="/publica/publica-nav.jsp" />

	<div class="container">
		<div class="row">
			<div class="col">
				<h2>Carros</h2>
				
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Marca</th>
							<th>Nome</th>
							<th>Modelo</th>
							<th>Cor</th>
							<th>Fabricação</th>
							<th>Ativado?</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="carro" items="${listaCarros}">
							<tr>
								<td><c:out value="${carro.id}" /></td>
								<td><c:out value="${carro.marca}" /></td>
								<td><c:out value="${carro.nome}" /></td>
								<td><c:out value="${carro.modelo}" /></td>
								<td><c:out value="${carro.cor}" /></td>
								<td><fmt:formatDate value='${carro.fabricacao}'
										type='date' pattern='dd/MM/yyyy' /></td>

								<td>
									
									<span> <c:out value= "${carro.ativo=='true' ? 'ATIVO' : 'NÃO ATIVO'}" /> </span>
								</td>				
								
								<td> 																			
									<a class="btn btn-outline-danger btn-sm"
									onclick="return confirm('Você deseja apagar?');"
									href="${pageContext.request.contextPath}/auth/admin?acao=apagar&id=<c:out value="${carro.id}" />">
									Apagar</a>
								</td>				
							
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>