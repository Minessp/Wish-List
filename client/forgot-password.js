document.addEventListener('DOMContentLoaded', function (){
    const emailForm = document.getElementById('email-step-form');
    const codeForm = document.getElementById('code-step-form');
    const updateForm = document.getElementById('update-passwd-form');

    emailForm.addEventListener('submit', e => {
        e.preventDefault();

        const data = {
            email: document.getElementById('email-recovery').value
        };

        fetch("http://localhost:8080/reset-password/send-code", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.status === 200) {
                    document.getElementById('email-step').style.display = 'none';
                    document.getElementById('code-step').style.display = 'block';
                }
            })
            .catch(error => console.log(error));
    });

    codeForm.addEventListener('submit', e => {
        e.preventDefault();

        const data = {
            email: document.getElementById('email-recovery').value,
            code: document.getElementById('code-recovery').value};

        fetch("http://localhost:8080/reset-password/validate-code", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.status === 200) {
                    document.getElementById('code-step').style.display = 'none';
                    document.getElementById('update-passwd-step').style.display = 'block';
                }
            })
            .catch(error => console.log(error));
    });

    updateForm.addEventListener('submit', e => {
        e.preventDefault();

        const data = {
            email: document.getElementById('email-recovery').value,
            code: document.getElementById('code-recovery').value,
            password: document.getElementById('passwd-recovery').value
        }

        fetch("http://localhost:8080/reset-password/set-password", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.status === 200) {
                    alert('Senha atualizada com sucesso!');
                    window.location.href = "./sign-login-page.html";
                } else {
                    alert("Não foi possível alterar a senha!");
                }
            })
            .catch(error => console.log(error));
    });
});