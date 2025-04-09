document.addEventListener('DOMContentLoaded', () => {
    const emailForm = document.getElementById('email-step-form');
    const codeForm = document.getElementById('code-step-form');
    const updateForm = document.getElementById('update-passwd-form');

    emailForm.addEventListener('submit', (e) =>  {
        e.preventDefault();
        document.getElementById('email-step').style.display = 'none';
        document.getElementById('code-step').style.display = 'block';
    });

    codeForm.addEventListener('submit', (e) =>  {
        e.preventDefault();
        document.getElementById('code-step').style.display = 'none';
        document.getElementById('update-passwd-step').style.display = 'block';
    });

    updateForm.addEventListener('submit', (e) =>  {
        e.preventDefault();
        alert('Senha atualizada com sucesso!');
    });
});