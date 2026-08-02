const userId = localStorage.getItem("userId");

async function loadCompanyProfile() {

    try {

        const response = await fetch(

            API.companyProfile + "/" + userId,

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

        const company = await response.json();
        localStorage.setItem("companyId", company.id);

        document.getElementById("companyName").value =
        company.companyName || "";

        document.getElementById("website").value =
        company.website || "";

        document.getElementById("location").value =
        company.location || "";

        document.getElementById("description").value =
        company.description || "";

    }

    catch (error) {

        console.log(error);

    }

}

document.getElementById("companyProfileForm")

.addEventListener("submit", async function (e) {

    e.preventDefault();

    const company = {

        companyName:
        document.getElementById("companyName").value,

        website:
        document.getElementById("website").value,

        location:
        document.getElementById("location").value,

        description:
        document.getElementById("description").value

    };

    const response = await fetch(

        API.companyProfile + "/" + userId,

        {

            method: "PUT",

            headers: {

                "Content-Type": "application/json",

                "Authorization":
                "Bearer " + localStorage.getItem("token")

            },

            body: JSON.stringify(company)

        }

    );

    if (response.ok) {

        alert("Company Profile Updated Successfully");

    }

    else {

        alert("Unable to Update Company Profile");

    }

});

loadCompanyProfile();