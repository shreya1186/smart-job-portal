async function loadJobs() {

    try {

        const response = await fetch(API.getAllJobs, {

            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            }

        });

        if (!response.ok) {

            alert("Unable to load jobs");
            return;
        }

        const jobs = await response.json();

        const container = document.getElementById("jobsContainer");

        container.innerHTML = "";

        if (jobs.length === 0) {

            container.innerHTML = `
                <div class="dashboard-card" style="text-align:center;">
                    <h2>😔 No Jobs Available</h2>
                    <p>Please check again later.</p>
                </div>
            `;

            return;
        }

        jobs.forEach(job => {

            container.innerHTML += `

            <div class="job-card">

                <h2>${job.title}</h2>

                <p>
                    <i class="fa-solid fa-location-dot"></i>
                    <b> Location:</b> ${job.location}
                </p>

                <p>
                    <i class="fa-solid fa-briefcase"></i>
                    <b> Experience:</b> ${job.experience}
                </p>

                <p>
                    <i class="fa-solid fa-indian-rupee-sign"></i>
                    <b> Salary:</b> ₹${job.salary}
                </p>

                <p>
                    <i class="fa-solid fa-calendar-days"></i>
                    <b> Deadline:</b> ${job.deadline}
                </p>

                <div style="margin-top:20px;">

                    <button
                        class="btn btn-primary"
                        onclick="viewJob(${job.id})">

                        <i class="fa-solid fa-eye"></i>
                        View Details

                    </button>

                </div>

            </div>

            `;

        });

    }

    catch (e) {

        console.log(e);
        alert("Unable to load jobs.");

    }

}

function viewJob(id){

    window.location.href = `job-details.html?id=${id}`;

}

loadJobs();

