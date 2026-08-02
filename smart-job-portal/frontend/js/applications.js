const studentId = localStorage.getItem("studentId");

async function loadApplications() {

    try {
        const response = await fetch(
            API.studentApplications + "/" + studentId,
            {
                headers: {
                    "Authorization":
                    "Bearer " +
                    localStorage.getItem("token")
                }
            }
        );

        if (!response.ok) {

            alert("Unable to load applications");

            return;
        }

        const applications = await response.json();

        const container =
        document.getElementById("applicationContainer");

        container.innerHTML = "";

        if (applications.length === 0) {

            container.innerHTML = `
                <div class="dashboard-card" style="text-align:center;">
                    <h2>📄 No Applications Yet</h2>
                    <p>You haven't applied to any job.</p>
                    <br>
                    <a href="jobs.html" class="btn btn-primary">
                        Browse Jobs
                    </a>
                </div>
            `;

            return;
        }

        applications.forEach(app => {

            container.innerHTML += `

            <div class="dashboard-card">

                <h2>${app.jobTitle}</h2>

                <br>

                <p>

                <b>Status :</b>

                ${app.status}

                </p>

                <br>

                <p>

                ${app.coverLetter}

                </p>

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