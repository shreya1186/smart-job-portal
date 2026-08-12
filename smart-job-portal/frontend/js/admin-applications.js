async function loadApplications() {

    try {

        const response = await fetch(

            API.adminApplications,

            {

                headers: {

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            alert("Unable to load applications");

            return;

        }

        const applications = await response.json();

        const table = document.getElementById("applicationsTable");

        table.innerHTML = "";

        applications.forEach(application => {

            table.innerHTML += `

                <tr>

                    <td>${application.id}</td>

                    <td>${application.studentName}</td>

                    <td>${application.jobTitle}</td>

                    <td>${application.status}</td>

                    <td>${application.appliedDate}</td>

                    <td>

                        <button
                            class="btn btn-danger"
                            onclick="deleteApplication(${application.id})">

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

async function deleteApplication(applicationId) {

    const confirmDelete = confirm("Delete this application?");

    if (!confirmDelete) {

        return;

    }

    try {

        const response = await fetch(

            API.deleteApplicationAdmin + "/" + applicationId,

            {

                method: "DELETE",

                headers: {

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            alert("Unable to delete application");

            return;

        }

        alert("Application deleted successfully");

        loadApplications();

    }

    catch (error) {

        console.log(error);

        alert("Server Error");

    }

}

loadApplications();