<!DOCTYPE html>
<%@ page import="model.classes.Employee"%>
<%@ page import="model.classes.Dough"%>
<%@ page import="model.classes.MeatBase"%>
<%@ page import="model.classes.Sauces"%>
<%@ page import="model.classes.OptionalElements"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PiadineriaAdvancia AddPiadina</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/stylesAdd.css">
</head>
<body>
	<header>
		<h1>Add a New Piadina</h1>
	</header>
	<main>
		<form id="add" action="add" method="post">
			<label for="name">Name:</label>
			<input class="textBox" type="text" id="name" name="name" placeholder="name" onclick="hideErrorName()">
			<p class="errorName">A name must be specified.</p>
			<label>Dough:</label>
			<div class="chips-container" id="doughContainer">
			<%
				Dough[] doughs = (Dough[]) session.getAttribute("doughs");
			 	if(doughs != null) {
					for(Dough dough : doughs) {
			%>
						<div class="chip" onclick="toggleChipSelection('dough', this, 1)" data-price="<%= dough.getPrice() %>">
					        <span class="chip-label prevent-select"><%= dough.getType() %></span>
					    </div>
			<%
					}
				}
			%>
			</div>
			<p class="errorDough">A dough must be selected.</p>
			<label>Meat Base (max 2):</label>
			<div class="chips-container" id="meatBaseContainer">
			<%
				MeatBase[] mBases = (MeatBase[]) session.getAttribute("mBases");
				if(mBases != null) {
					for(MeatBase mBase : mBases) {
			%>
						<div class="chip" onclick="toggleChipSelection('meatBase', this, 2)" data-price="<%= mBase.getPrice() %>">
					        <span class="chip-label prevent-select"><%= mBase.getType() %></span>
					    </div>
			<%
					}
				}
			%>
			</div>
			<p class="errorMeatBase">At least one meat base must be selected.</p>
			<label>Sauces (max 2):</label>
			<div class="chips-container" id="saucesContainer">
			<%
				Sauces[] sauces = (Sauces[]) session.getAttribute("sauces");
				if(sauces != null) {
					for(Sauces sauce : sauces) {
			%>
						<div class="chip" onclick="toggleChipSelection('sauces', this, 2)" data-price="<%= sauce.getPrice() %>">
					        <span class="chip-label prevent-select"><%= sauce.getType() %></span>
					    </div>
			<%
					}
				}
			%>
			</div>
			<p class="errorSauces">At least one sauce must be selected.</p>
			<label>Optional Elements (max 3):</label>
			<div class="chips-container" id="optionalElementsContainer">
			<%
				OptionalElements[] oElements = (OptionalElements[]) session.getAttribute("oElements");
				if(oElements != null) {
					for(OptionalElements oElement : oElements) {
			%>
						<div class="chip" onclick="toggleChipSelection('optionalElements', this, 3)" data-price="<%= oElement.getPrice() %>">
					        <span class="chip-label prevent-select"><%= oElement.getType() %></span>
					    </div>
			<%
					}
				}
			%>
			</div>
			<p class="errorOptionalElements">At least one optional element must be selected.</p>
			<label>Price:</label>
			<div class="mb-3">
				<span id="price">0.00</span><span> &euro;</span>
			</div>
			<label for="addedBy">Added By:</label>
			<%
				Employee user = (session != null) ? (Employee) session.getAttribute("user") : null;
				if(user != null) {
			%>
					<span id="user"><%= user.getUsername() %></span>
			<%
				}
			%>
			<button class="mt-3" type="button" id="addbtn" onclick="submitAjax()">Add Piadina</button>
		</form>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous">
	</script>
	<script src="resources/js/scriptAdd.js"></script>
</body>
</html>