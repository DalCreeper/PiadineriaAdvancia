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
		<form id="addPiadinaForm" action="AddPiadinaActionServlet" method="post">
			<label for="name">Name:</label>
			<input type="text" id="name" name="name" required>
			
			<label>Dough:</label>
			<div class="chips-container">
			<%
				Dough[] doughs = (Dough[]) session.getAttribute("doughs");
			 	if(doughs != null) {
					for(Dough dough : doughs) {
			%>
						<div class="chip" onclick="toggleChipSelection('dough', this, 1)">
					        <span class="chip-label"><%=dough.getRaw()%></span>
					    </div>
						<!--
						<md-chip-set class="chip-set" id="dough" name="dough" required>
							<md-filter-chip
								label="<%=dough.getRaw()%>"
								onclick="toggleChipSelection(this), 1">
								<span class="mdc-chip__icon" style="display: none;"></span>
							</md-filter-chip>
						</md-chip-set>
						-->
			<%
					}
				}
			%>
			</div>
			<label>Meat Base (max 2):</label>
			<div class="chips-container">
			<%
				MeatBase[] mBases = (MeatBase[]) session.getAttribute("mBases");
				if(mBases != null) {
					for(MeatBase mBase : mBases) {
			%>
						<div class="chip" onclick="toggleChipSelection('meatBase', this, 2)">
					        <span class="chip-label"><%=mBase.getRaw()%></span>
					    </div>
					    <!--
						<md-chip-set class="chip-set" id="mBase" name="mBase" required>
							<md-filter-chip
								label="<%=mBase.getRaw()%>"
								onclick="toggleChipSelection(this), 2">
							</md-filter-chip>
						</md-chip-set>
						-->
			<%
					}
				}
			%>
			</div>
			<label>Sauces (max 2):</label>
			<div class="chips-container">
			<%
				Sauces[] sauces = (Sauces[]) session.getAttribute("sauces");
				if(sauces != null) {
					for(Sauces sauce : sauces) {
			%>
						<div class="chip" onclick="toggleChipSelection('sauces', this, 2)">
					        <span class="chip-label"><%=sauce.getRaw()%></span>
					    </div>
						<!--
						<md-chip-set class="chip-set" id="sauce" name="sauce" required>
							<md-filter-chip
								label="<%=sauce.getRaw()%>"
								onclick="toggleChipSelection(this), 2">
							</md-filter-chip>
						</md-chip-set>
						-->
			<%
					}
				}
			%>
			</div>
			<label>Optional Elements (max 3):</label>
			<div class="chips-container">
			<%
				OptionalElements[] oElements = (OptionalElements[]) session.getAttribute("oElements");
				if(oElements != null) {
					for(OptionalElements oElement : oElements) {
			%>
						<div class="chip" onclick="toggleChipSelection('optionalElements', this, 3)">
					        <span class="chip-label"><%=oElement.getRaw()%></span>
					    </div>
						<!--
						<md-chip-set class="chip-set" id="oElement" name="oElement" required>
							<md-filter-chip
								label="<%=oElement.getRaw()%>"
								onclick="toggleChipSelection(this), 3">
							</md-filter-chip>
						</md-chip-set>
						-->
			<%
					}
				}
			%>
			</div>
			<label for="price">Price:</label>
			<input type="number" id="price" name="price" step="0.01" required>
			<label for="addedBy">Added By:</label>
			<input type="text" id="addedBy" name="addedBy" required>
			<button type="submit">Add Piadina</button>
		</form>
	</main>
	<script src="resources/js/scriptAdd.js"></script>
</body>
</html>