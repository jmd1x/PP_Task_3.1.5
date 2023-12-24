//User information-page
getUser()

function getUser() {
    fetch("api/user")
        .then(response => response.json())
        .then(user => {
                let userRoles = []
                user.roles.forEach(role => userRoles.push(role.role.replace("ROLE_", "")))
                const info = `$(
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                        <td>${user.age}</td>
                        <td>${user.username}</td>
                        <td>${userRoles}</td>
            </tr>)`;
                $('#userInfo').append(info)
            })
}