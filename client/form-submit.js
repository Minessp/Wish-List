const formCadastro = document.getElementById('formCadastro');
const formLogin = document.getElementById('formLogin');

if (formCadastro) {
    formCadastro.addEventListener('submit', e => {
        e.preventDefault();

        const formData = {
            nome: document.getElementById('nomeCadastro').value,
            email: document.getElementById('emailCadastro').value,
            password: document.getElementById('passwdCadastro').value
        }

        // Envia dados de cadastro
        fetch("http://localhost:8080/cadastro", {
            method: 'POST',
            headers: {
                   'Content-Type': 'application/json'
            },
            body: JSON.stringify({formData})
        }).then(r => console.log(r.data))
            .catch((err) => console.log(err));

        formCadastro.reset();
    })
}

if (formLogin) {
    formLogin.addEventListener('submit', e => {
        e.preventDefault();

        const formData = {
            email: document.getElementById('emailLogin').value,
            password: document.getElementById('passwdLogin').value
        }

        // Envia dados de login
        fetch("http://localhost:8080/login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({formData})
        }).then(r => console.log(r.data))
            .catch((err) => console.log(err));

        formLogin.reset();
    })
}