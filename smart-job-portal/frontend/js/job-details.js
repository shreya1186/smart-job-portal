const params = new URLSearchParams(window.location.search);

const jobId = params.get("id");

async function loadJob(){

    const response = await fetch(

        API.getJob + "/" + jobId,

        {

            headers:{

                "Authorization":"Bearer "+localStorage.getItem("token")

            }

        }

    );

    const job = await response.json();

    document.getElementById("title").innerHTML =
    job.title;

    document.getElementById("location").innerHTML =
    "<b>Location:</b> " + job.location;

    document.getElementById("experience").innerHTML =
    "<b>Experience:</b> " + job.experience;

    document.getElementById("skills").innerHTML =
    "<b>Skills:</b> " + job.skills;

    document.getElementById("salary").innerHTML =
    "<b>Salary:</b> ₹" + job.salary;

    document.getElementById("deadline").innerHTML =
    "<b>Deadline:</b> " + job.deadline;

    document.getElementById("description").innerHTML =
    "<b>Description:</b><br>" + job.description;

}

document.getElementById("applyBtn").onclick=()=>{

    window.location.href=
    `apply.html?id=${jobId}`;

};

loadJob();