const companyId = localStorage.getItem("companyId");

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

                <p><b>Location:</b> ${job.location}</p>

                <p><b>Salary:</b> ₹${job.salary}</p>

                <p><b>Deadline:</b> ${job.deadline}</p>

                <br>

                <a class="btn btn-primary"
                   href="company-applications.html?jobId=${job.id}">

                   View Applications

                </a>

            </div>

            `;

        });

    }

    catch (error) {

        console.log(error);

    }

}

loadCompanyJobs();