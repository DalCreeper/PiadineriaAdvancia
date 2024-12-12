let selectedCountDough = 0;
let selectedCountMeatBase = 0;
let selectedCountSauces = 0;
let selectedCountOptionalElements = 0;

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
				}
				break;
			case 'meatBase' :
				if(selectedCountMeatBase < maxSelections) {
		            selectedChip.classList.add('selected');
					selectedCountMeatBase++;
				}
				break;
			case 'sauces' :
				if(selectedCountSauces < maxSelections) {
		            selectedChip.classList.add('selected');
					selectedCountSauces++;
				}
				break;
			case 'optionalElements' :
				if(selectedCountOptionalElements < maxSelections) {
		            selectedChip.classList.add('selected');
					selectedCountOptionalElements++;
				}
				break;
			default : break;	
		}
    }
}
