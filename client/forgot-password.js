document.addEventListener('DOMContentLoaded', function (){
    const emailForm = document.getElementById('email-step-form');
    const codeForm = document.getElementById('code-step-form');
    const updateForm = document.getElementById('update-passwd-form');

    emailForm.addEventListener('submit', e => {
        e.preventDefault();

        const email = {
            email: document.getElementById('email-recovery').value
        };

        fetch("http://localhost:8080/reset-password/send-code", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(email)
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

        const code = {
            code: document.getElementById('email-recovery').value
        };

        fetch("http://localhost:8080/reset-password/send-code", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(code)
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
        alert('Senha atualizada com sucesso!');
    });
});