const companyId = localStorage.getItem("companyId");

console.log("Company ID:", companyId);
console.log("API:", API.companyJobs + "/" + companyId);

async function loadCompanyJobs() {

    try {

        const response = await fetch(

            API.companyJobs + "/" + companyId,

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

        const container = document.getElementById("companyJobsContainer");

        container.innerHTML = "";

        if (jobs.length === 0) {

            container.innerHTML = `
                <div class="dashboard-card" style="text-align:center;">
                    <h2>📋 No Jobs Posted</h2>
                    <p>You haven't posted any jobs yet.</p>
                    <br>
                    <a href="post-job.html" class="btn btn-primary">
                        Post Your First Job
                    </a>
                </div>
            `;

            return;
        }

        jobs.forEach(job => {

            container.innerHTML += `

            <div class="job-card">

                <h3>${job.title}</h3>

                <p><i class="fa-solid fa-location-dot"></i> <b>Location:</b> ${job.location}</p>

                <p><i class="fa-solid fa-indian-rupee-sign"></i> <b>Salary:</b> ₹${job.salary}</p>

                <p><i class="fa-solid fa-calendar-days"></i> <b>Deadline:</b> ${job.deadline}</p>

                <br>

                <br>

                <div style="display:flex; gap:10px; flex-wrap:wrap;">

                    <a class="btn btn-primary"
                        href="company-applications.html?jobId=${job.id}">

                        <i class="fa-solid fa-users"></i>
                        View Applications

                    </a>

                    <button
                        class="btn btn-outline"
                        onclick="editJob(${job.id})">

                        <i class="fa-solid fa-pen"></i>
                        Edit

                    </button>

                    <button
                        class="btn btn-danger"
                        onclick="deleteJob(${job.id})">

                        <i class="fa-solid fa-trash"></i>
                        Delete

                    </button>

                </div>

            </div>

            `;

        });

    }

    catch (error) {

        console.log(error);

    }

}

loadCompanyJobs();



function editJob(jobId) {

    window.location.href =
        "edit-job.html?jobId=" + jobId;

}

async function deleteJob(jobId) {

    const ok = confirm("Delete this job?");

    if (!ok) return;

    try {

        const response = await fetch(

            API.deleteJob + "/" + jobId,

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

        loadCompanyJobs();

    }

    catch (error) {

        console.log(error);

    }

}