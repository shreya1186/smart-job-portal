const companyId = localStorage.getItem("companyId");

document.getElementById("jobForm")

.addEventListener("submit", async function (e) {

    e.preventDefault();

    const job = {

        title: document.getElementById("title").value,

        description: document.getElementById("description").value,

        salary: document.getElementById("salary").value,

        location: document.getElementById("location").value,

        experience: document.getElementById("experience").value,

        skills: document.getElementById("skills").value,

        deadline: document.getElementById("deadline").value

    };

    try {

        const response = await fetch(

            API.createJob + "/" + companyId,

            {

                method: "POST",

                headers: {

                    "Content-Type": "application/json",

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                },

                body: JSON.stringify(job)

            }

        );

        if (!response.ok) {

            alert("Unable to post job");

            return;

        }

        alert("Job Posted Successfully");

        window.location.href = "company-jobs.html";

    }

    catch (error) {

        console.log(error);

        alert("Server Error");

    }

});