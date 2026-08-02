const params = new URLSearchParams(window.location.search);

const jobId = params.get("id");

const studentId = localStorage.getItem("studentId");

document.getElementById("applyForm")

.addEventListener("submit", async function(e){

    e.preventDefault();

    const application = {

    studentId: studentId,

    jobId: jobId,

    coverLetter:
    document.getElementById("coverLetter").value

    };
console.log(localStorage.getItem("token"));
const response = await fetch(

API.applyJob,

{

method:"POST",

headers: {
    "Content-Type": "application/json",
    "Authorization": "Bearer " + localStorage.getItem("token")
},

body:JSON.stringify(application)

}

);

if(response.ok){

alert("Application Submitted Successfully");

window.location.href="applications.html";

}

else{

    const error = await response.text();

    alert(error);

}

});