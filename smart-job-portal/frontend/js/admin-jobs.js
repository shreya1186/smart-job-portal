async function loadJobs() {

    try {

        const response = await fetch(API.adminJobs, {

            headers: {

                "Authorization":
                "Bearer " + localStorage.getItem("token")

            }

        });

        if (!response.ok) {

            alert("Unable to load jobs");
            return;

        }

        const jobs = await response.json();

        const table = document.getElementById("jobsTable");

        table.innerHTML = "";

        jobs.forEach(job => {

            table.innerHTML += `

                <tr>

                    <td>${job.id}</td>

                    <td>${job.title}</td>

                    <td>${job.location}</td>

                    <td>₹${job.salary}</td>

                    <td>${job.deadline}</td>

                    <td>

                        <button
                            class="btn btn-danger"
                            onclick="deleteJob(${job.id})">

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

async function deleteJob(jobId) {

    const confirmDelete = confirm("Delete this job?");

    if (!confirmDelete) {

        return;

    }

    try {

        const response = await fetch(

            API.deleteJobAdmin + "/" + jobId,

            {

                method: "DELETE",

                headers: {

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            alert("Unable to delete job");
            return;

        }

        alert("Job deleted successfully");

        loadJobs();

    }

    catch (error) {

        console.log(error);

    }

}

loadJobs();