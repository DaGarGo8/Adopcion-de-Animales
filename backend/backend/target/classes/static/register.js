document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Para evitar el envío tradicional del formulario

    const correo = document.getElementById('correo').value;
    const password = document.getElementById('password').value;
    const rol = document.getElementById('rol').value || 'USER';  // Valor por defecto
    const apellidos = document.getElementById('apellidos').value || 'No especificado';
    const identificacion = document.getElementById('identificacion').value || 'No especificada';

    const userData = {
        correo: correo,
        password: password,
        rol: rol,
        apellidos: apellidos,
        identificacion: identificacion
    };

    // Realizar la solicitud POST con el JSON
    fetch('http://localhost:8080/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'  // Aquí le indicamos que el cuerpo será JSON
        },
        body: JSON.stringify(userData)  // Convertir el objeto en JSON
    })
    .then(response => response.json())
    .then(data => {
        console.log('Usuario registrado con éxito:', data);
        alert('Usuario registrado con éxito');
    })
    .catch(error => {
        console.error('Error al registrar el usuario:', error);
        alert('Error al registrar el usuario');
    });
});
