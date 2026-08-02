async function loadJobs() {

    try {

        const response = await fetch(

            BASE_URL + "/admin/jobs",

            {

                headers: {

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            alert("Unable to load jobs");

            return;

        }

        const jobs = await response.json();

        const container =
        document.getElementById("jobsContainer");

        container.innerHTML = "";

        jobs.forEach(job => {

            container.innerHTML += `

            <div class="dashboard-card">

                <h2>${job.title}</h2>

                <p>${job.location}</p>

                <p>₹${job.salary}</p>

                <br>

                <button
                    class="btn btn-primary"
                    onclick="deleteJob(${job.id})">

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

async function deleteJob(id) {

    if (!confirm("Delete this job?")) return;

    const response = await fetch(

        BASE_URL + "/admin/job/" + id,

        {

            method: "DELETE",

            headers: {

                "Authorization":
                "Bearer " + localStorage.getItem("token")

            }

        }

    );

    if (response.ok) {

        loadJobs();

    }

}

loadJobs();