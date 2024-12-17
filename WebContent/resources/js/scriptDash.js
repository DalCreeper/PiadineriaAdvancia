function remove(button) {
	const piadinaName = button.getAttribute('data-name');
	console.log("Removing piadina:", piadinaName);
	
	if(confirm(`Are you sure you want to remove "${piadinaName}"?`)) {
		fetch('remove', {
	        method: 'POST',
	        headers: {
	            'Content-Type': 'application/json'
	        },
	        body: JSON.stringify(piadinaName)
	    }).then(response => {
	        if(response.ok) {
	            window.location.href = "/PiadineriaAdvancia/dashboard";
	        } else {
	            alert("Error removing the piadina.");
	        }
	    }).catch(error => {
	        console.error('Error:', error);
	        alert("An unexpected error occurred.");
	    });
	}
}