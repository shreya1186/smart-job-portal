const loginForm = document.getElementById("loginForm");

loginForm.addEventListener("submit", async (e) => {

    e.preventDefault();

    const loginData = {

        email: document.getElementById("email").value,

        password: document.getElementById("password").value

    };

    try {

        const response = await fetch(API.login, {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(loginData)

        });

        const data = await response.json();

        if (!response.ok) {

            alert(data.message || "Login Failed");
 
            return;

        }

        localStorage.setItem("userId", data.userId);
        localStorage.setItem("token", data.token);
        localStorage.setItem("role", data.role);
        localStorage.setItem("email", loginData.email);

        alert(data.message);

        if (data.role === "STUDENT") {

            window.location.href = "student.html";

        }

        else if (data.role === "COMPANY") {

                const response = await fetch(

                API.companyProfile + "/" + data.userId,

                {
                    headers: {
                        "Authorization": "Bearer " + data.token
                    }
                }

            );

            if (response.ok) {

                const company = await response.json();

                localStorage.setItem("companyId", company.id);

            }

            window.location.href = "company.html";
        }

        else if (data.role === "ADMIN") {

            window.location.href = "admin.html";

        }

    }

    catch (error) {

        alert("Unable to connect to server.");

        console.log(error);

    }

});