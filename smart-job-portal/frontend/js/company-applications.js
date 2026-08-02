const params = new URLSearchParams(window.location.search);

const jobId = params.get("jobId");

async function loadApplications() {

    try {

        const response = await fetch(

            API.companyApplications + "/" + jobId,

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

        const container =
        document.getElementById("applicationsContainer");

        container.innerHTML = "";

                if (applications.length === 0) {

            container.innerHTML = `
                <div class="dashboard-card" style="text-align:center;">
                    <h2>📭 No Applications Received</h2>
                    <p>No students have applied for this job yet.</p>
                </div>
            `;

            return;
        }

        applications.forEach(app => {

            container.innerHTML += `

            <div class="dashboard-card">

                <h2>${app.studentName}</h2>

                <p><b>Email:</b> ${app.studentEmail}</p>

                <p><b>Status:</b> ${app.status}</p>

                <p><b>Cover Letter:</b></p>

                <p>${app.coverLetter}</p>

                <br>

                <button class="btn btn-primary">

                    View Resume

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

loadApplications();