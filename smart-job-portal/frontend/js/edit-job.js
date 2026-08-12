const params = new URLSearchParams(window.location.search);

const jobId = params.get("jobId");

async function loadJob() {

    try {

        const response = await fetch(

            API.getJob + "/" + jobId,

            {

                headers: {

                    "Authorization":
                        "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            alert("Unable to load job");

            return;

        }

        const job = await response.json();

        document.getElementById("title").value = job.title;
        document.getElementById("description").value = job.description;
        document.getElementById("salary").value = job.salary;
        document.getElementById("location").value = job.location;
        document.getElementById("experience").value = job.experience;
        document.getElementById("skills").value = job.skills;
        document.getElementById("deadline").value = job.deadline;

    }

    catch (error) {

        console.log(error);

        alert("Server Error");

    }

}

loadJob();

document.getElementById("editJobForm")

.addEventListener("submit", async function(e){

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

    try{

        const response = await fetch(

            API.updateJob + "/" + jobId,

            {

                method:"PUT",

                headers:{

                    "Content-Type":"application/json",

                    "Authorization":
                        "Bearer " + localStorage.getItem("token")

                },

                body:JSON.stringify(job)

            }

        );

        if(!response.ok){

            alert("Unable to update job");

            return;

        }

        alert("Job Updated Successfully");

        window.location.href="company-jobs.html";

    }

    catch(error){

        console.log(error);

        alert("Server Error");

    }

});