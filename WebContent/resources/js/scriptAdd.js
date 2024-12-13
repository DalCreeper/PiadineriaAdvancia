let selectedCountDough = 0;
let selectedCountMeatBase = 0;
let selectedCountSauces = 0;
let selectedCountOptionalElements = 0;
let errorCont;

function toggleChipSelection(type, selectedChip, maxSelections) {
    if(selectedChip.classList.contains('selected')) {
        selectedChip.classList.remove('selected');
		switch(type) {
			case 'dough' :
				selectedCountDough--;
				break;
			case 'meatBase' :
				selectedCountMeatBase--;
				break;
			case 'sauces' :
				selectedCountSauces--;
				break;
			case 'optionalElements' :
				selectedCountOptionalElements--;
				break;
			default : break;	
		}
    } else {
		switch(type) {
			case 'dough' :
				if(selectedCountDough < maxSelections) {
		            selectedChip.classList.add('selected');
					selectedCountDough++;
					document.querySelector('.errorDough').style.display = 'none';
				}
				break;
			case 'meatBase' :
				if(selectedCountMeatBase < maxSelections) {
		            selectedChip.classList.add('selected');
					selectedCountMeatBase++;
					document.querySelector('.errorMeatBase').style.display = 'none';
				}
				break;
			case 'sauces' :
				if(selectedCountSauces < maxSelections) {
		            selectedChip.classList.add('selected');
					selectedCountSauces++;
					document.querySelector('.errorSauces').style.display = 'none';
				}
				break;
			case 'optionalElements' :
				if(selectedCountOptionalElements < maxSelections) {
		            selectedChip.classList.add('selected');
					selectedCountOptionalElements++;
					document.querySelector('.errorOptionalElements').style.display = 'none';
				}
				break;
			default : break;	
		}
    }
}

document.querySelector('button[type="submit"]').addEventListener('click', function(event) {
	errorCont = 0;
	
	if(selectedCountDough != 1) {
		errorCont++;
		document.querySelector('.errorDough').style.display = 'block';
	}
	if(selectedCountMeatBase < 1) {
		errorCont++;
		document.querySelector('.errorMeatBase').style.display = 'block';
	}
	if(selectedCountSauces < 1) {
		errorCont++;
		document.querySelector('.errorSauces').style.display = 'block';
	}
	if(selectedCountOptionalElements < 1) {
		errorCont++;
		document.querySelector('.errorOptionalElements').style.display = 'block';
	}
	if(errorCont > 0) {
		event.preventDefault();
	}
});

