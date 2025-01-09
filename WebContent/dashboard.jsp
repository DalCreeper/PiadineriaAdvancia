<!DOCTYPE html>
<%@ page import="com.advancia.PiadineriaAdvancia.model.classes.Employee"%>
<%@ page import="com.advancia.PiadineriaAdvancia.model.classes.Piadina"%>
<%@ page import="com.advancia.PiadineriaAdvancia.model.classes.Dough"%>
<%@ page import="com.advancia.PiadineriaAdvancia.model.classes.MeatBase"%>
<%@ page import="com.advancia.PiadineriaAdvancia.model.classes.Sauces"%>
<%@ page import="com.advancia.PiadineriaAdvancia.model.classes.OptionalElements"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.stream.Collectors"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PiadineriaAdvancia Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/stylesDash.css">
</head>
<body>
	<header class="d-flex">
		<div class="flex-fill">
			<h1 class="prevent-select">Menu Management - Piadineria Advancia</h1>
			<%
				Employee user = (session != null) ? (Employee) session.getAttribute("user") : null;
				if(user != null) {
			%>
			<h3 class="prevent-select">
				Welcome, <%= user.getUsername() %>!
			</h3>
			<%
				}
			%>
		</div>
		<form action="logout" method="post" class="align-self-center"><button class="logoutBtn align-self-center" id="logoutBtn">Logout</button></form>
	</header>
	<main>
		<section class="menu-section">
			<h2 class="prevent-select">Menu</h2>
			<div class="table-responsive-xl">
				<table class="menu-table table table-hover">
					<thead>
						<tr>
							<th class="align-middle prevent-select">Name</th>
							<th class="align-middle prevent-select">Dough</th>
							<th class="align-middle prevent-select">Meat Base</th>
							<th class="align-middle prevent-select">Sauces</th>
							<th class="align-middle prevent-select">Optional</th>
							<th class="align-middle prevent-select">Price</th>
							<th class="align-middle prevent-select">Added By</th>
							<th class="align-middle prevent-select">Actions</th>
						</tr>
					</thead>
					<tbody id="menuTableBody">
						<%
							List<Piadina> piadinas = (List<Piadina>) request.getAttribute("piadinas");
							if(piadinas != null) {
								for(Piadina piadina : piadinas) {
						%>
									<tr>
										<td class="col align-middle" id=""><%= piadina.getName() %></td>
										<td class="col align-middle"><%= piadina.getDough().getType() %></td>
										<td class="col align-middle"><%= piadina.getMeatBase().stream().map(MeatBase::getType).collect(Collectors.joining(", ")) %></td>
										<td class="col align-middle"><%= piadina.getSauces().stream().map(Sauces::getType).collect(Collectors.joining(", ")) %></td>
										<td class="col align-middle"><%= piadina.getOptionalElements().stream().map(OptionalElements::getType).collect(Collectors.joining(", ")) %></td>
										<td class="col align-middle text-nowrap"><%= String.format("&euro; %.2f", piadina.getPrice()) %></td>
										<td class="col align-middle"><%= piadina.getEmployee().getName() + " " + piadina.getEmployee().getSurname() %></td>
										<td class="col align-middle">
											<div class="d-flex justify-content-center">
												<button id="removePiadinaBtn" data-name="<%= piadina.getName() %>" onclick="remove(this)">Remove</button>
											</div>
										</td>
									</tr>
						<%
								}
							} else {
						%>
								<tr>
									<td colspan="8">No piadinas available</td>
								</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<div class="d-flex justify-content-center">
				<a href="addPiadina"><button class="align-middle" id="addPiadinaBtn">Add Piadina</button></a>
			</div>
		</section>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous">
	</script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="resources/js/scriptDash.js"></script>
</body>
</html>