function remove(button) {
	const piadinaName = button.getAttribute('data-name');

	Swal.fire({
        title: 'Are you sure?',
        html: `You are about to remove <b>"${piadinaName}"</b><br>This action cannot be undone.`,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, remove it!',
		timer: 5000,
	  	timerProgressBar: true,
		customClass: {
		    confirmButton: 'confirm-btn',
		    cancelButton: 'cancel-btn',
		    popup: 'popup-progress-bar',
 		},
    }).then((result) => {
        if(result.isConfirmed) {
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
    });
}