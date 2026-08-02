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

            document.getElementById("profileContent").style.display = "none";

            document.getElementById("noProfileMessage").style.display = "block";

            return;

        }

        const student = await response.json();

        localStorage.setItem("studentId", student.id);

        document.getElementById("studentCollege").innerHTML =
            "<b>College:</b> " + student.college;

        document.getElementById("studentDegree").innerHTML =
            "<b>Degree:</b> " + student.degree;

        document.getElementById("studentBranch").innerHTML =
            "<b>Branch:</b> " + student.branch;

        document.getElementById("studentSkills").innerHTML =
            "<b>Skills:</b> " + student.skills;

        document.getElementById("studentPhone").innerHTML =
            "<b>Phone:</b> " + student.phone;

        document.getElementById("studentGithub").innerHTML =
            "<b>GitHub:</b> " + student.github;

        document.getElementById("studentLinkedin").innerHTML =
            "<b>LinkedIn:</b> " + student.linkedin;

        document.getElementById("studentAddress").innerHTML =
            "<b>Address:</b> " + student.address;

        document.getElementById("studentAbout").innerHTML =
            "<b>About:</b> " + student.about;

    }

    catch (error) {

        console.log(error);

    }

}

loadProfile();