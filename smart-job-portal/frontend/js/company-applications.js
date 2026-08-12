const params = new URLSearchParams(window.location.search);

const jobId = params.get("jobId");

function getActionButtons(application) {

    switch (application.status) {

        case "APPLIED":
            return `
                <button
                    class="btn btn-primary"
                    onclick="updateStatus(${application.id}, 'UNDER_REVIEW')">

                    📄 Under Review

                </button>

                <button
                    class="btn btn-danger"
                    onclick="updateStatus(${application.id}, 'REJECTED')">

                    ❌ Reject

                </button>
            `;

        case "UNDER_REVIEW":
            return `
                <button
                    class="btn btn-primary"
                    onclick="updateStatus(${application.id}, 'INTERVIEW')">

                    🎤 Interview

                </button>

                <button
                    class="btn btn-danger"
                    onclick="updateStatus(${application.id}, 'REJECTED')">

                    ❌ Reject

                </button>
            `;

        case "INTERVIEW":
            return `
                <button
                    class="btn btn-primary"
                    onclick="updateStatus(${application.id}, 'SELECTED')">

                    ✅ Select

                </button>

                <button
                    class="btn btn-danger"
                    onclick="updateStatus(${application.id}, 'REJECTED')">

                    ❌ Reject

                </button>
            `;

        case "SELECTED":
            return `
                <span class="status-selected">
                    🎉 Candidate Selected
                </span>
            `;

        case "REJECTED":
            return `
                <span class="status-rejected">
                    ❌ Candidate Rejected
                </span>
            `;

        default:
            return "";
    }

}

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

                    <h2>📭 No Applications Yet</h2>

                    <p>No student has applied for this job.</p>

                </div>

            `;

            return;

        }

        applications.forEach(application => {

            container.innerHTML += `

                <div class="job-card">

                    <h3>${application.studentName}</h3>

                    <p><b>Job:</b> ${application.jobTitle}</p>

                    <p><b>Status:</b> ${application.status}</p>

                    <p><b>Applied:</b> ${application.appliedDate}</p>

                    <br>

                    <p><b>Cover Letter</b></p>

                    <p>${application.coverLetter}</p>

                    <br>

                     <div style="margin-top:15px;display:flex;gap:10px;align-items:center;flex-wrap:wrap;">

                        ${getActionButtons(application)}

                    </div>

                </div>

            `;

        });

    }

    catch (error) {

        console.log(error);

        alert("Server Error");

    }

}

loadApplications();


async function updateStatus(applicationId, status) {

    try {

        const response = await fetch(

            API.updateApplicationStatus +
            "/" +
            applicationId +
            "/status?status=" +
            status,

            {

                method: "PUT",

                headers: {

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            alert("Unable to update status");

            return;

        }

        alert("Application moved to " + status + " Successfully");

        loadApplications();

    }

    catch (error) {

        console.log(error);

        alert("Server Error");

    }

}