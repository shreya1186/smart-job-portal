let currentPage = 0;
const pageSize = 5;

async function loadJobs() {

    try {

        const response = await fetch(

            API.jobPagination +
            "?page=" + currentPage +
            "&size=" + pageSize,

            {
                headers:{
                    "Authorization":
                    "Bearer " + localStorage.getItem("token")
                }
            }

        );

        if (!response.ok) {

            alert("Unable to load jobs");
            return;
        }

        const data = await response.json();

        displayJobs(data.content);

        showPagination(data);

    }

    catch (e) {

        console.log(e);
        alert("Unable to load jobs.");

    }

}

function viewJob(id){

    window.location.href = `job-details.html?id=${id}`;

}

function displayJobs(jobs) {

    const container = document.getElementById("jobsContainer");

    container.innerHTML = "";

    if (jobs.length === 0) {

        container.innerHTML = `
            <div class="dashboard-card">
                <h2>No Jobs Found</h2>
            </div>
        `;

        return;

    }

    jobs.forEach(job => {

        container.innerHTML += `

        <div class="job-card">

            <h2>${job.title}</h2>

            <p>
                <i class="fa-solid fa-building"></i>
                <b>Company:</b> ${job.companyName}
            </p>

            <p>
                <i class="fa-solid fa-location-dot"></i>
                <b>Location:</b> ${job.location}
            </p>

            <p>
                <i class="fa-solid fa-briefcase"></i>
                <b>Experience:</b> ${job.experience}
            </p>

            <p>
                <i class="fa-solid fa-indian-rupee-sign"></i>
                <b>Salary:</b> ₹${job.salary}
            </p>

            <p>
                <i class="fa-solid fa-calendar-days"></i>
                <b>Deadline:</b> ${job.deadline}
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

function showPagination(data) {

    const pagination = document.getElementById("pagination");

    pagination.innerHTML = `
    
        <button
            class="btn btn-outline"
            onclick="previousPage()"
            ${data.first ? "disabled" : ""}>

            Previous

        </button>

        <span>

            Page ${data.number + 1}
            of
            ${data.totalPages}

        </span>

        <button
            class="btn btn-outline"
            onclick="nextPage()"
            ${data.last ? "disabled" : ""}>

            Next

        </button>

    `;

}

async function searchByTitle() {

    const title = document.getElementById("searchValue").value;

    if (title.trim() === "") {

        loadJobs();
        return;

    }

    try {

        const response = await fetch(

            API.searchByTitle + "?title=" + encodeURIComponent(title),

            {
                headers: {
                    "Authorization":
                    "Bearer " + localStorage.getItem("token")
                }
            }

        );

        if (!response.ok) {

            alert("Search failed");
            return;

        }

        const jobs = await response.json();

        displayJobs(jobs);

    }

    catch (error) {

        console.log(error);

    }

}

async function searchByLocation() {

    const location = document.getElementById("searchValue").value;

    if (location.trim() === "") {

        loadJobs();
        return;

    }

    try {

        const response = await fetch(

            API.searchByLocation + "?location=" + encodeURIComponent(location),

            {
                headers: {
                    "Authorization":
                    "Bearer " + localStorage.getItem("token")
                }
            }

        );

        if (!response.ok) {

            alert("Search failed");
            return;

        }

        const jobs = await response.json();

        displayJobs(jobs);

    }

    catch (error) {

        console.log(error);

    }

}

async function searchByExperience() {

    const experience = document.getElementById("searchValue").value;

    if (experience.trim() === "") {

        loadJobs();
        return;

    }

    try {

        const response = await fetch(

            API.searchByExperience + "?experience=" + encodeURIComponent(experience),

            {
                headers: {
                    "Authorization":
                    "Bearer " + localStorage.getItem("token")
                }
            }

        );

        if (!response.ok) {

            alert("Search failed");
            return;

        }

        const jobs = await response.json();
        displayJobs(jobs);
    }

    catch (error) {

        console.log(error);

    }

}

async function searchBySkills() {

    const skills = document.getElementById("searchValue").value;

    if (skills.trim() === "") {

        loadJobs();
        return;

    }

    try {

        const response = await fetch(

            API.searchBySkills + "?skills=" + encodeURIComponent(skills),

            {
                headers: {
                    "Authorization":
                    "Bearer " + localStorage.getItem("token")
                }
            }

        );

        if (!response.ok) {

            alert("Search failed");
            return;

        }

        const jobs = await response.json();

        displayJobs(jobs);

    }

    catch (error) {

        console.log(error);

    }

}

async function searchJobs() {

    const type = document.getElementById("searchType").value;

    if (type === "title") {

        searchByTitle();

    }

    else if (type === "location") {

        searchByLocation();

    }

    else if (type === "experience") {

        searchByExperience();

    }

    else {

        searchBySkills();

    }

}


loadJobs();


function previousPage() {

    if(currentPage > 0){

        currentPage--;

        loadJobs();

    }

}

function nextPage() {

    currentPage++;

    loadJobs();

}