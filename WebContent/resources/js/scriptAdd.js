let specifiedName = '';
let selectedCountDough = 0;
let selectedCountMeatBase = 0;
let selectedCountSauces = 0;
let selectedCountOptionalElements = 0;
let totalPrice = 0.0;
const maxDoughSelections = 1;
const maxMeatBaseSelections = 2;
const maxSaucesSelections = 2;
const maxOptionalSelections = 3;

const ingredientPrices = {
    dough: {},
    meatBase: {},
    sauces: {},
    optionalElements: {}
};

document.querySelectorAll('#doughContainer .chip').forEach(chip => {
    ingredientPrices.dough[chip.querySelector('.chip-label').innerText] = parseFloat(chip.getAttribute('data-price'));
});
document.querySelectorAll('#meatBaseContainer .chip').forEach(chip => {
    ingredientPrices.meatBase[chip.querySelector('.chip-label').innerText] = parseFloat(chip.getAttribute('data-price'));
});
document.querySelectorAll('#saucesContainer .chip').forEach(chip => {
    ingredientPrices.sauces[chip.querySelector('.chip-label').innerText] = parseFloat(chip.getAttribute('data-price'));
});
document.querySelectorAll('#optionalElementsContainer .chip').forEach(chip => {
    ingredientPrices.optionalElements[chip.querySelector('.chip-label').innerText] = parseFloat(chip.getAttribute('data-price'));
});

function toggleChipSelection(type, selectedChip, maxSelections) {
	const label = selectedChip.querySelector('.chip-label').innerText;
    const price = ingredientPrices[type][label];
    let selectedCount;

    switch(type) {
        case 'dough' :
            selectedCount = selectedCountDough;
            break;
        case 'meatBase' :
            selectedCount = selectedCountMeatBase;
            break;
        case 'sauces' :
            selectedCount = selectedCountSauces;
            break;
        case 'optionalElements' :
            selectedCount = selectedCountOptionalElements;
            break;
    }
	
	if(selectedChip.classList.contains('selected')) {
        selectedChip.classList.remove('selected');
        totalPrice -= price;

        if(type === 'dough') selectedCountDough--;
        if(type === 'meatBase') selectedCountMeatBase--;
        if(type === 'sauces') selectedCountSauces--;
        if(type === 'optionalElements') selectedCountOptionalElements--;
    } else {
        if(selectedCount < maxSelections) {
            selectedChip.classList.add('selected');
            totalPrice += price;
			switch(type) {
				case 'dough' :
					selectedCountDough++;
					document.querySelector('.errorDough').style.display = 'none';
					break;
				case 'meatBase' :
					selectedCountMeatBase++;
					document.querySelector('.errorMeatBase').style.display = 'none';
					break;
				case 'sauces' :
					selectedCountSauces++;
					document.querySelector('.errorSauces').style.display = 'none';
					break;
				case 'optionalElements' :
					selectedCountOptionalElements++;
					document.querySelector('.errorOptionalElements').style.display = 'none';
					break;
			}
        }
    }

    updatePrice();
}

function updatePrice() {
	if(totalPrice === 0.00) totalPrice += 0
    document.getElementById("price").innerText = totalPrice.toFixed(2);
}

function validateForm() {
    let errorCont = 0;
    
	specifiedName = document.getElementById('name').value;
	if(specifiedName === "") {
		errorCont++;
		document.querySelector('.errorName').style.display = 'block';
	}
	
    if(selectedCountDough !== 1) {
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

    return errorCont === 0;
}

function hideErrorName() {
    document.querySelector('.errorName').style.display = 'none';
}

function collectSelectedIngredients() {
    const selectedIngredients = {
        dough: null,
        meatBase: [],
        sauces: [],
        optionalElements: []
    };

    document.querySelectorAll('#doughContainer .chip.selected').forEach(chip => {
        selectedIngredients.dough = chip.querySelector('.chip-label').innerText;
    });

    document.querySelectorAll('#meatBaseContainer .chip.selected').forEach(chip => {
        selectedIngredients.meatBase.push(chip.querySelector('.chip-label').innerText);
    });

    document.querySelectorAll('#saucesContainer .chip.selected').forEach(chip => {
        selectedIngredients.sauces.push(chip.querySelector('.chip-label').innerText);
    });

    document.querySelectorAll('#optionalElementsContainer .chip.selected').forEach(chip => {
        selectedIngredients.optionalElements.push(chip.querySelector('.chip-label').innerText);
    });

    return selectedIngredients;
}

function submitAjax() {
    if(!validateForm()) {
        return;
    }
	
	const name = document.getElementById("name").value;
    const selectedIngredients = collectSelectedIngredients();
    const totalPrice = parseFloat(document.getElementById("price").innerText);
    const user = document.getElementById("user").innerText;
    
    const requestData = {
        name: name,
        dough: selectedIngredients.dough,
        meatBase: selectedIngredients.meatBase,
        sauces: selectedIngredients.sauces,
        optionalElements: selectedIngredients.optionalElements,
        price: totalPrice,
        user: user
    };

    fetch('add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestData)
    }).then(response => {
        if(response.ok) {
            window.location.href = "/PiadineriaAdvancia/dashboard";
        } else {
            alert("Error adding the piadina.");
        }
    }).catch(error => {
        console.error('Error:', error);
        alert("An unexpected error occurred.");
    });
}

document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();
    submitFormWithAjax();
});
