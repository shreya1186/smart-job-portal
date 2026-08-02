const userId = localStorage.getItem("userId");

async function loadProfile() {

    try {

        const response = await fetch(

            API.studentProfile + "/" + userId,

            {
                headers: {
                    "Authorization":
                    "Bearer " + localStorage.getItem("token")
                }
            }
        );

        if (!response.ok) {

            return;

        }

        const student = await response.json();

        localStorage.setItem("studentId", student.id);

        document.getElementById("college").value =
        student.college || "";

        document.getElementById("degree").value =
        student.degree || "";

        document.getElementById("branch").value =
        student.branch || "";

        document.getElementById("skills").value =
        student.skills || "";

        document.getElementById("phone").value =
        student.phone || "";

        document.getElementById("github").value =
        student.github || "";

        document.getElementById("linkedin").value =
        student.linkedin || "";

        document.getElementById("address").value =
        student.address || "";

        document.getElementById("about").value =
        student.about || "";

    }

    catch(error){

        console.log(error);

    }

}

document.getElementById("studentProfileForm")

.addEventListener("submit", async function(e){

    e.preventDefault();

    const student = {

        college:
        document.getElementById("college").value,

        degree:
        document.getElementById("degree").value,

        branch:
        document.getElementById("branch").value,

        skills:
        document.getElementById("skills").value,

        phone:
        document.getElementById("phone").value,

        github:
        document.getElementById("github").value,

        linkedin:
        document.getElementById("linkedin").value,

        address:
        document.getElementById("address").value,

        about:
        document.getElementById("about").value

    };

    const response = await fetch(

        API.studentProfile + "/" + userId,

        {

            method:"PUT",

            headers:{

                "Content-Type":"application/json",

                "Authorization":
                "Bearer " + localStorage.getItem("token")

            },

            body:JSON.stringify(student)

        }

    );

    if(response.ok){

        alert("Profile Updated Successfully");

        window.location.href="profile.html";

    }

    else{

        alert("Unable to update profile");

    }

});

loadProfile();