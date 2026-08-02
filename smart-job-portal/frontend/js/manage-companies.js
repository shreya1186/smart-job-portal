async function loadCompanies() {

    try {

        const response = await fetch(

            BASE_URL + "/admin/companies",

            {

                headers: {

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            alert("Unable to load companies");

            return;

        }

        const companies = await response.json();

        const container =
        document.getElementById("companiesContainer");

        container.innerHTML = "";

        companies.forEach(company => {

            container.innerHTML += `

            <div class="dashboard-card">

                <h2>${company.companyName}</h2>

                <p>${company.location}</p>

                <p>${company.website}</p>

                <br>

                <button
                    class="btn btn-primary"
                    onclick="deleteCompany(${company.id})">

                    Delete

                </button>

            </div>

            <br>

            `;

        });

    }

    catch (error) {

        console.log(error);

    }

}

async function deleteCompany(id) {

    if (!confirm("Delete this company?")) return;

    const response = await fetch(

        BASE_URL + "/admin/company/" + id,

        {

            method: "DELETE",

            headers: {

                "Authorization":
                "Bearer " + localStorage.getItem("token")

            }

        }

    );

    if (response.ok) {

        loadCompanies();

    }

}

loadCompanies();