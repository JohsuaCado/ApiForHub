Foro Hub 👩‍💻
Foro Hub es una aplicación de foro creada para facilitar la comunicación y discusión entre los usuarios. Permite a los usuarios crear y responder tópicos, participando activamente en debates.

Características ⚙️
Registro y autenticación de usuarios.
Creación, edición y eliminación de tópicos.
Respuestas a tópicos existentes.
Listado de usuarios y tópicos disponibles.
Autenticación mediante JWT (JSON Web Tokens).
Tecnologías utilizadas ⚒️
Java
Spring Boot
Spring Security
JWT (JSON Web Tokens)
JPA (Java Persistence API)
H2 Database (para desarrollo y pruebas)
Postman (para pruebas de API)
Swagger (para documentación de API)
Estructura del proyecto 🖥️
Entities: Clases que representan las tablas de la base de datos.
Dto: Clases utilizadas para transferir datos entre el cliente y el servidor.
Repository: Interfaces que extienden JpaRepository para realizar operaciones CRUD en las entidades.
Service: Clases que contienen la lógica de negocio.
Controller: Clases que gestionan las solicitudes HTTP.
Security: Clases que configuran la seguridad y la autenticación.
