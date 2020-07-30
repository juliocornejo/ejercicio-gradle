ejercicio
=========

Fuentes del arquetipo RestFul SpringBoot backend registrar Usuario
Para compilar

Para ejecutar

./gradlew bootRun

#### ESTADO
Para consultar por el estado (UP-DOWN)
http://localhost:8081/actuator/health

##### USO
Para utilizar este aplicativo para registrar un usuario

registrar Usuario

POST -> localhost:8081/registrar-usuario

{
  "name": "name",
  "email": "waatas@walgo.cl",
  "password": "2Aa34Tg",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "contrycode": "57"
    }
  ]
}




