const companyId = localStorage.getItem("companyId");

async function loadCompanyDashboard() {

    if (!companyId) {
        alert("Company profile not found");
        return;
    }

    try {

        const response = await fetch(

            API.companyDashboard + "/" + companyId,

            {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                }
            }

        );

        if (!response.ok) {
            alert("Unable to load dashboard");
            return;
        }

        const data = await response.json();

        document.getElementById("jobsPosted").innerText = data.jobsPosted;
        document.getElementById("applicationsReceived").innerText = data.applicationsReceived;
        document.getElementById("openJobs").innerText = data.openJobs;

    }
    catch (error) {
        console.log(error);
        alert("Server Error");
    }

}

loadCompanyDashboard();