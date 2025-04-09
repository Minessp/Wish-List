const formCadastro = document.getElementById('formSignup');
const formLogin = document.getElementById('formLogin');

// Verifica se o form é de cadastro
if (formCadastro) {
    formCadastro.addEventListener('submit', e => {
        e.preventDefault();

        const formData = {
            username: document.getElementById('usernameSignup').value,
            email: document.getElementById('emailSignup').value,
            password: document.getElementById('passwdSignup').value
        }

        // Envia dados de cadastro
        fetch("http://localhost:8080/user/signup", {
            method: 'POST',
            headers: {
                   'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        }).then(response => {
            if (response.status === 201) {
                window.location.href = "./login-page.html";
            }
        })
            .catch((err) => {
                console.log(err);
                alert("Não foi possível cadastrar o usuário");
            });

        formCadastro.reset();
    })
}

// Verifica se o form é de login
if (formLogin) {
    formLogin.addEventListener('submit', e => {
        e.preventDefault();

        const formData = {
            email: document.getElementById('emailLogin').value,
            password: document.getElementById('passwdLogin').value
        }

        // Envia dados de login
        fetch("http://localhost:8080/user/login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        }).then(response => {
            if (response.status === 200) {
                window.location.href = "./home.html";
            }
        })
            .catch((err) => {
                console.log(err);
                alert("Não foi possível fazer o login");
        });

        formLogin.reset();
    })
}