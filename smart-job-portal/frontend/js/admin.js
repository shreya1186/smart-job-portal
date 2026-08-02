// const adminId = 1;

async function loadAdminDashboard(){

    try{

        const response = await fetch(

            API.adminDashboard,

            {

                headers:{

                    "Authorization":"Bearer " +
                    localStorage.getItem("token")

                }

            }

        );
        

        if(!response.ok){

            alert("Unable to load dashboard");

            return;

        }

        const data = await response.json();

        document.getElementById("totalUsers").innerText =
        data.totalUser;

        document.getElementById("totalStudents").innerText =
        data.totalStudents;

        document.getElementById("totalCompanies").innerText =
        data.totalCompanies;

        document.getElementById("totalJobs").innerText =
        data.totalJobs;

        document.getElementById("totalApplications").innerText =
        data.totalApplication;

    }

    catch(error){

        console.log(error);

    }

}

loadAdminDashboard();