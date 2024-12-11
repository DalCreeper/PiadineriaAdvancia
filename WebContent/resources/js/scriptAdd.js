let selectedCount = 0;

function toggleChipSelection(selectedChip, maxSelections) {
    const chips = document.querySelectorAll('#dough md-filter-chip');
    const isSelected = selectedChip.hasAttribute('disabled');
    
    if(isSelected) {
        selectedChip.removeAttribute('disabled');
        selectedCount--;
    } else {
        if(selectedCount < maxSelections) {
            selectedChip.setAttribute('disabled', 'true');
            selectedCount++;
        }
    }

    if(selectedCount < maxSelections) {
        chips.forEach(chip => {
            if(!chip.hasAttribute('disabled')) {
                chip.removeAttribute('disabled');
            }
        });
    } else {
        chips.forEach(chip => {
            if(!chip.hasAttribute('disabled') && chip !== selectedChip) {
                chip.setAttribute('disabled', 'true');
            }
        });
    }
}