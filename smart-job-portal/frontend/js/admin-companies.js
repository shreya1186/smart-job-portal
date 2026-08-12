async function loadCompanies() {

    try {

        const response = await fetch(API.adminCompanies, {

            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            }

        });

        if (!response.ok) {

            alert("Unable to load companies");
            return;

        }

        const companies = await response.json();

        const table = document.getElementById("companiesTable");

        table.innerHTML = "";

        companies.forEach(company => {

            table.innerHTML += `

                <tr>

                    <td>${company.id}</td>

                    <td>${company.companyName}</td>

                    <td>${company.website}</td>

                    <td>${company.location}</td>

                    <td>

                        <button
                            class="btn btn-danger"
                            onclick="deleteCompany(${company.id})">

                            Delete

                        </button>

                    </td>

                </tr>

            `;

        });

    }

    catch (error) {

        console.log(error);
        alert("Server Error");

    }

}

async function deleteCompany(companyId) {

    const confirmDelete = confirm("Delete this company?");

    if (!confirmDelete) {

        return;

    }

    try {

        const response = await fetch(

            API.deleteCompany + "/" + companyId,

            {

                method: "DELETE",

                headers: {

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            alert("Unable to delete company");
            return;

        }

        alert("Company deleted successfully");

        loadCompanies();

    }

    catch (error) {

        console.log(error);

    }

}

loadCompanies();