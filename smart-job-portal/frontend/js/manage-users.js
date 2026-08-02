async function loadUsers() {

    try {

        const response = await fetch(

            BASE_URL + "/admin/users",

            {

                headers: {

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            alert("Unable to load users");

            return;

        }

        const users = await response.json();

        const container = document.getElementById("usersContainer");

        container.innerHTML = "";

        users.forEach(user => {

            container.innerHTML += `

            <div class="dashboard-card">

                <h2>${user.name}</h2>

                <p><b>Email :</b> ${user.email}</p>

                <p><b>Role :</b> ${user.role}</p>

                <br>

                <button
                    class="btn btn-primary"
                    onclick="deleteUser(${user.id})">

                    Delete

                </button>

            </div>

            <br>

            `;

        });

    }

    catch (error) {

        console.log(error);

    }

}

async function deleteUser(id) {

    if (!confirm("Delete this user?")) return;

    const response = await fetch(

        BASE_URL + "/admin/user/" + id,

        {

            method: "DELETE",

            headers: {

                "Authorization":
                "Bearer " + localStorage.getItem("token")

            }

        }

    );

    if (response.ok) {

        loadUsers();

    }

}

loadUsers();