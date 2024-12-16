<!DOCTYPE html>
<%@ page import="model.classes.Employee"%>
<%@ page import="model.classes.Piadina"%>
<%@ page import="model.classes.Dough"%>
<%@ page import="model.classes.MeatBase"%>
<%@ page import="model.classes.Sauces"%>
<%@ page import="model.classes.OptionalElements"%>
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
	<header>
		<div class="d-flex">
			<div class="flex-fill">
				<h1>Menu Management - Piadineria Advancia</h1>
				<%
					Employee user = (session != null) ? (Employee) session.getAttribute("user") : null;
					if(user != null) {
				%>
				<h3>
					Welcome, <%= user.getUsername() %>!
				</h3>
				<%
					}
				%>
			</div>
			<form action="logout" method="post" class="align-self-center"><button class="logoutBtn align-self-center" id="logoutBtn">Logout</button></form>
		</div>
	</header>
	<main>
		<section class="menu-section">
			<h2>Menu</h2>
			<div class="table-responsive-xl">
				<table class="menu-table table table-hover">
					<thead>
						<tr>
							<th class="align-middle">Name</th>
							<th class="align-middle">Dough</th>
							<th class="align-middle">Meat Base</th>
							<th class="align-middle">Sauces</th>
							<th class="align-middle">Optional</th>
							<th class="align-middle">Price</th>
							<th class="align-middle">Added By</th>
							<th class="align-middle">Actions</th>
						</tr>
					</thead>
					<tbody id="menuTableBody">
						<%
							Piadina[] piadinas = (Piadina[]) request.getAttribute("piadinas");
							if(piadinas != null) {
								for(Piadina piadina : piadinas) {
						%>
									<tr>
										<td class="col align-middle"><%=piadina.getName()%></td>
										<td class="col align-middle"><%=piadina.getDough().getType()%></td>
										<td class="col align-middle"><%=Arrays.stream(piadina.getMeatBase()).map(MeatBase::getType).collect(Collectors.joining(", "))%></td>
										<td class="col align-middle"><%=Arrays.stream(piadina.getSauces()).map(Sauces::getType).collect(Collectors.joining(", "))%></td>
										<td class="col align-middle"><%=Arrays.stream(piadina.getOptionalElements()).map(OptionalElements::getType).collect(Collectors.joining(", "))%></td>
										<td class="col align-middle text-nowrap"><%=String.format("&euro; %.2f", piadina.getPrice())%></td>
										<td class="col align-middle"><%=piadina.getEmployee().getName() + " " + piadina.getEmployee().getSurname()%></td>
										<td class="col align-middle">
											<div class="d-flex justify-content-center">
												<a href="remove"><button id="removePiadinaBtn">Remove</button></a>
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
			<a href="addPiadina"><button class="align-middle" id="addPiadinaBtn">Add Piadina</button></a>
		</section>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous">
	</script>
	<script src="resources/js/scriptDash.js"></script>
</body>
</html>