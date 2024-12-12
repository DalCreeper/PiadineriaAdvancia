<!DOCTYPE html>
<%@ page import="model.classes.Piadina"%>
<%@ page import="model.enums.Dough"%>
<%@ page import="model.enums.MeatBase"%>
<%@ page import="model.enums.Sauces"%>
<%@ page import="model.enums.OptionalElements"%>
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
		<h1>Menu Management - Piadineria Advancia</h1>
		<%
			String user = (session != null) ? (String) session.getAttribute("user") : null;
			if (user != null) {
		%>
		<h3>
			Welcome, <%=user%>!
		</h3>
		<%
			}
		%>
	</header>
	<main>
		<section class="menu-section">
			<h2>Menu</h2>
			<div class="table-responsive-xl">
				<table class="menu-table table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Dough</th>
							<th>Meat Base</th>
							<th>Sauces</th>
							<th>Optional</th>
							<th>Price</th>
							<th>Added By</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody id="menuTableBody">
						<%
							Piadina[] piadinas = (Piadina[]) session.getAttribute("piadinas");
							if (piadinas != null) {
								for (Piadina piadina : piadinas) {
						%>
									<tr>
										<td class="col"><%=piadina.getName()%></td>
										<td class="col"><%=piadina.getDough().getRaw()%></td>
										<td class="col"><%=Arrays.stream(piadina.getMeatBase()).map(MeatBase::getRaw).collect(Collectors.joining(", "))%></td>
										<td class="col"><%=Arrays.stream(piadina.getSauces()).map(Sauces::getRaw).collect(Collectors.joining(", "))%></td>
										<td class="col"><%=Arrays.stream(piadina.getOptionalElements()).map(OptionalElements::getRaw).collect(Collectors.joining(", "))%></td>
										<td class="col text-nowrap"><%=String.format("&euro; %.2f", piadina.getPrice())%></td>
										<td class="col"><%=piadina.getEmployee().getName() + " " + piadina.getEmployee().getSurname()%></td>
										<td class="col"><div class="d-flex justify-content-center">
												<button class="deleteBtn">Remove</button>
											</div></td>
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
			<button class="align-middle" id="addPiadinaBtn">Add Piadina</button>
		</section>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="resources/js/scriptDash.js"></script>
</body>
</html>