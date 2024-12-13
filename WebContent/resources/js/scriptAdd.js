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

            if(type === 'dough') selectedCountDough++; document.querySelector('.errorDough').style.display = 'none';
            if(type === 'meatBase') selectedCountMeatBase++; document.querySelector('.errorMeatBase').style.display = 'none';
            if(type === 'sauces') selectedCountSauces++; document.querySelector('.errorSauces').style.display = 'none';
            if(type === 'optionalElements') selectedCountOptionalElements++; document.querySelector('.errorOptionalElements').style.display = 'none';
        }
    }

    updatePrice();
}

function updatePrice() {
    document.getElementById("price").innerText = totalPrice.toFixed(2);
}

function validateForm() {
    let errorCont = 0;
    
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

document.querySelector('form').addEventListener('submit', function(event) {
    if(!validateForm()) {
        event.preventDefault();
    }
});
