const role = localStorage.getItem("role");

if (role !== "STUDENT") {
    window.location.href = "access-denied.html";
}

const userId = localStorage.getItem("userId");

async function loadDashboard() {

    try {

        // First load student profile
        const profileResponse = await fetch(
            API.studentProfile + "/" + userId,
            {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                }
            }
        );

        const profileBtn = document.getElementById("profileBtn");

        if (!profileResponse.ok) {

            profileBtn.innerText = "Complete Profile";
            alert("Please complete your profile first.");
            return;

        }

        const profile = await profileResponse.json();

        localStorage.setItem("studentId", profile.id);

        profileBtn.innerText = "View Profile";

        const studentId = profile.id;

        // Now load dashboard
        const response = await fetch(
            API.studentDashboard + "/" + studentId,
            {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                }
            }
        );

        if (!response.ok) {

            alert("Unable to load dashboard.");
            return;

        }

        const data = await response.json();

        document.getElementById("totalApplications").innerText =
            data.totalApplication;

        document.getElementById("selectedJobs").innerText =
            data.selectedJobs;

        document.getElementById("rejectedJobs").innerText =
            data.rejectedJobs;

    }

    catch (error) {

        console.log(error);
        alert("Server Error");

    }

}

loadDashboard();