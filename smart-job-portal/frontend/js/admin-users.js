async function loadUsers() {

    try {

        const response = await fetch(API.adminUsers, {

            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            }

        });

        if (!response.ok) {

            alert("Unable to load users");
            return;

        }

        const users = await response.json();

        const table = document.getElementById("usersTable");

        table.innerHTML = "";

        users.forEach(user => {

            table.innerHTML += `

                <tr>

                    <td>${user.id}</td>

                    <td>${user.name}</td>

                    <td>${user.email}</td>

                    <td>${user.role}</td>

                    <td>

                        <button
                            class="btn btn-danger"
                            onclick="deleteUser(${user.id})">

                            Delete

                        </button>

                    </td>

                </tr>

            `;

        });

    }

    catch (error) {

        console.log(error);
        alert("Server Error");

    }

}

async function deleteUser(userId) {

    const confirmDelete = confirm("Delete this user?");

    if (!confirmDelete) {

        return;

    }

    try {

        const response = await fetch(

            API.deleteUser + "/" + userId,

            {

                method: "DELETE",

                headers: {

                    "Authorization":
                    "Bearer " + localStorage.getItem("token")

                }

            }

        );

        if (!response.ok) {

            console.log("Status:", response.status);

            const text = await response.text();

            console.log("Response:", text);

            alert("Status : " + response.status);

            return;
        }

        alert("User deleted successfully");

        loadUsers();

    }

    catch (error) {

        console.log(error);

    }

}

loadUsers();