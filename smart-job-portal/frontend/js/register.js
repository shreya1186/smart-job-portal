const registerForm = document.getElementById("registerForm");

registerForm.addEventListener("submit", async (e) => {

    e.preventDefault();

    const registerData = {

        name: document.getElementById("name").value,

        email: document.getElementById("email").value,

        password: document.getElementById("password").value,

        role: document.getElementById("role").value

    };

    try {

        const response = await fetch(API.register, {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(registerData)

        });

        if (response.ok) {

            const message = await response.text();

            alert(message);

            window.location.href = "login.html";

        } else {

            const error = await response.json();

            alert(error.message);

        }

    }

    catch (error) {

        console.log(error);

        alert("Unable to connect to server.");

    }

});