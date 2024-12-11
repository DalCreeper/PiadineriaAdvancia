/*
document.addEventListener("DOMContentLoaded", () => {
    const addPiadinaBtn = document.getElementById("addPiadinaBtn");

    addPiadinaBtn.addEventListener("click", () => {
        window.location.href = "addForm.jsp";
    });

    function loadMenu() {
        const menuTableBody = document.getElementById("menuTableBody");
        const piadinasMock = [
            {
                name: "Romana",
                dough: "Classic",
                meat: "Prosciutto crudo",
                sauces: "Mayonnaise, BBQ Sauce",
                optional: "Mozzarella, Tomato",
                price: "7.50",
                addedBy: "Mario Rossi"
            },
			{
                name: "Italian",
                dough: "Carbon",
                meat: "Beef",
                sauces: "Philadelphia",
                optional: "Green salad, Tomato",
                price: "8.00",
                addedBy: "John Doe"
            },
        ];

        piadinasMock.forEach(piadina => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${piadina.name}</td>
                <td>${piadina.dough}</td>
                <td>${piadina.meat}</td>
                <td>${piadina.sauces}</td>
                <td>${piadina.optional}</td>
				<td>&euro; ${piadina.price}</td>
                <td>${piadina.addedBy}</td>
                <td><button class='deleteBtn'>Remove</button></td>
            `;
            menuTableBody.appendChild(row);
        });

        document.querySelectorAll(".deleteBtn").forEach(button => {
            button.addEventListener("click", (e) => {
                e.target.closest("tr").remove();
            });
        });
    }

    loadMenu();
});
*/
