// Al enviar el formulario
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevenir el envío del formulario por defecto

    const correo = document.getElementById('correo').value;
    const password = document.getElementById('password').value;

    // Crear un objeto con los datos de login
    const loginData = {
        correo: correo,
        password: password
    };

    // Realizar la solicitud POST con los datos JSON
    fetch('http://localhost:8080/api/usuarios/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'  // Indicamos que enviamos JSON
        },
        body: JSON.stringify(loginData)  // Convertimos el objeto a JSON
    })
    .then(response => response.text()) // Usar response.text() para obtener la respuesta cruda como texto
    .then(text => {
        console.log('Texto recibido del servidor:', text);

        // Aquí verificamos si la respuesta es un texto específico que esperamos
        if (text === "Inicio de sesión exitoso") {
            alert('Inicio de sesión exitoso');
            // Redirigir a la página principal o a otro lugar después del login
            window.location.href = 'index.html'; // Cambia esto por la URL deseada
        } else {
            alert('Error al iniciar sesión: ' + text);
        }
    })
    .catch(error => {
        console.error('Error al iniciar sesión:', error);
        alert('Hubo un error al iniciar sesión');
    });
});
