<!DOCTYPE html>
<%@ page import="model.enums.Dough"%>
<%@ page import="model.enums.MeatBase"%>
<%@ page import="model.enums.Sauces"%>
<%@ page import="model.enums.OptionalElements"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PiadineriaAdvancia AddPiadina</title>
<link rel="stylesheet" href="resources/css/stylesAdd.css">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
<script type="importmap">
    	{
      		"imports": {
        		"@material/web/": "https://esm.run/@material/web/"
      		}
    	}
	</script>
<script type="module">
    	import '@material/web/all.js';
    	import {styles as typescaleStyles} from '@material/web/typography/md-typescale-styles.js';

    	document.adoptedStyleSheets.push(typescaleStyles.styleSheet);
  	</script>
</head>
<body>
	<header>
		<h1>Add a New Piadina</h1>
	</header>
	<main>
		<form id="addPiadinaForm" action="AddPiadinaServlet" method="post">
			<label for="name">Name:</label>
			<input type="text" id="name" name="name" required>
			
			<label for="dough">Dough:</label>
			<%
				Dough[] doughs = (Dough[]) request.getAttribute("doughs");
				for (Dough dough : doughs) {
			%>
					<md-chip-set id="dough" name="dough" required>
						<md-filter-chip
							label="<%=dough.getRaw()%>>"
							onclick="toggleChipSelection(this), 1">
						</md-filter-chip>
					</md-chip-set>
			<%
				}
			%>

			<label for="meat">Meat Base (max 2):</label>
			<%
				MeatBase[] mBases = (MeatBase[]) request.getAttribute("mBases");
				for (MeatBase mBase : mBases) {
			%>
					<md-chip-set id="mBase" name="mBase" required>
						<md-filter-chip
							label="<%=mBase.getRaw()%>>"
							onclick="toggleChipSelection(this), 2">
						</md-filter-chip>
					</md-chip-set>
			<%
				}
			%>

			<label for="sauces">Sauces (max 2):</label>
			<%
				Sauces[] sauces = (Sauces[]) request.getAttribute("sauces");
				for (Sauces sauce : sauces) {
			%>
					<md-chip-set id="sauce" name="sauce" required>
						<md-filter-chip
							label="<%=sauce.getRaw()%>>"
							onclick="toggleChipSelection(this), 2">
						</md-filter-chip>
					</md-chip-set>
			<%
				}
			%>

			<label for="optional">Optional Elements (max 3):</label>
			<%
				OptionalElements[] oElements = (OptionalElements[]) request.getAttribute("sauces");
				for (OptionalElements oElement : oElements) {
			%>
					<md-chip-set id="oElement" name="oElement" required>
						<md-filter-chip
							label="<%=oElement.getRaw()%>>"
							onclick="toggleChipSelection(this), 3">
						</md-filter-chip>
					</md-chip-set>
			<%
				}
			%>

			<label for="price">Price:</label>
			<input type="number" id="price" name="price" step="0.01" required>
			
			<label for="addedBy">Added By:</label>
			<input type="text" id="addedBy" name="addedBy" required>

			<button type="submit">Add Piadina</button>
		</form>
	</main>
	<script src="scriptAdd.js"></script>
</body>
</html>