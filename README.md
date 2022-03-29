# Solución del POC IoBuilders

## Frontend

### App

- Realizaremos una aplicación hibrida que con un desarrollo único podamos abarcar el proyecto en el tiempo determinado para ello utilizaremos React Native o en su defecto, una PWA que nos permita desplegar en IOS y Android.

- Utilización de algún framework de componentes como React Native Elements o NativeBase, en el caso de PWA, usaríamos Chakra o React Bootstrap.

- Realización de Test unitarios con react-testing-library.

- Estructura por componentes reutilizables y la lógica extraída (servicios).

- Comunicación cliente-servidor mediante REST y Websockets para eventos en tiempo real.

- Utilizaremos una solución de terceros para el KYC.

## Backend

### Infraestructura

- Desarrollaremos microservicios utilizando Kubernetes de algún proveedor cloud.
- Kafka para generación de eventos asíncronos.
- API Gateway que se encargará de autorizar y auditar las peticiones entrantes.

### Pipeline

- Alojamiento en Github y utilizaremos Githun Actions para el testing y el CD.
- Gitflow como gestión de ramas mediante Pull Request para favorecer y mejorar la estructura y conocimiento del código entre los miembros del equipo.

### Arquitectura de los microservicios

- Python debido a que con el tipado dinámico como Javascript y sería más rápido para abarcar el POC.
- Los microservicios dockerizados.
- Autenticación por JWT.
- Test unitarios definiendo una cobertura mínima.

## Riesgos

- Curva de aprendizaje de stack y blockchain.
- Dificultad para encontrar perfiles para el proyecto.
- Cumplimiento de las normativas de seguridad.
- Presión por tiempos ajustados.

## Equipo

- Team Leader (perfil mixto entre Desarrollador Senior y Arquitecto, con responsabilidad de SCRUM master) (1)
- Product Owner (1)
- Devops (1)
- Desarrollador Senior Frontend React con React Native (1)
- Desarrollador Blockchain + conocimiento con React (1)
- Desarrolladores Senior Back Python (2)
- Experto en seguridad (1)

## Cultura y Metología

- Metodología Agile, utilizando SCRUM con Jira. Intentando realizar las reuniones imprescindible dado que tenemos un tiempo muy limitado, tratando de planificar correctamente y paralelizar el trabajo.

- Seguir principios de Clean Code para mantener un alto estándar de calidad técnica, tratando de tener un código homogeneo y que todo el equipo pueda seguir una misma linea de trabajo. Teniendo code review para poder seguir estos estandares.

- Se realizará CI/CD con github y github actions, utilizando linters y autoformateadores de código.

- TDD y API First Development para poder trabajar en paralelo.

- Se trabajarán las dinámicas de grupo para mejorar las relaciones entre el equipo, habrá transparencia y se fomentará el aprendizaje. Además de tener flexibilidad horaría con la posibilidad de teletrabajo para la conciliación de la vida familiar.
