# Challenge Técnico en Mercado

Prueba técnica para ingreso a Mercado libre.

# Introducción

El challenge consiste en crear un API REST para detectar si una persona es mutante o no y obtener las estadisticas en base a cuantos mutantes hay.

### Tecnologias Usadas

1. [Spring boot](https://spring.io/projects/spring-boot)
2. [Spring Jpa](https://spring.io/projects/spring-data-jpa)
3. [Lombok](https://projectlombok.org/)
4. [Azure](https://docs.microsoft.com/en-us/azure/?product=popular)

## Comenzando 🚀

Estas instrucciones te permitirán ejecutar proyecto.

### Pre-requisitos 📋

Este es el Programa que necesitas para ejecutar el software.

* [Postman](https://www.postman.com/)

### Consumo del Servicio


1. Abrir Postman.

![image](https://user-images.githubusercontent.com/44062843/163070200-0a8d1cbd-5b59-4884-abd8-e5443c65f9a7.png)

2. Damos en el bóton **New** y Luego seleccionamos **Http Request**.

![image](https://user-images.githubusercontent.com/44062843/163070524-9cfd8f5c-2393-4c94-ac12-002d8295c194.png)

3. Seleccionamos el metodo GET O POST.

![image](https://user-images.githubusercontent.com/44062843/163070616-301d072c-ed6c-473f-9deb-725f1215cb52.png)

4. Luego ingresamos la URL base del servicio..

<pre><code>https://x-men-api.azurewebsites.net/</code></pre>

![image](https://user-images.githubusercontent.com/44062843/163070926-c662f186-7be8-4e64-921b-0b9b660d968a.png)

5. Cuando el método es GET no se requiere Body.

6. Si el método es POST, si requiere body el cual puedes seleccionar y luego se elige RAW Y formato JSON y pegamos el Body.

![image](https://user-images.githubusercontent.com/44062843/163076199-5087ef03-85a2-46b1-8b71-60a74ec08ee9.png)



7. Y por ultimo le das click en el bóton **Send**.

### API ¿es mutante?

Request: 

<pre><code>https://x-men-api.azurewebsites.net/mutant/</code></pre>

Method: POST

Body: Is Human

<pre><code>{ "dna": ["TTGCGA", "CAGTGC", "TTAAAT", "ACAAGG","CACCTC", "TCACTG"] }</code></pre>

Body: Is Mutant

<pre><code>{ "dna": ["TTGCGA", "CAGTGC", "TTAAGT","ACAAGG","CCCCTC","TCACTG"] }</code></pre>

### Estadisticas

Request: 

<pre><code>https://x-men-api.azurewebsites.net/stats/</code></pre>

Method: GET

### Ejemplos

Es mutante: 

![image](https://user-images.githubusercontent.com/44062843/163072604-19c082b6-19d8-481f-8ac7-96ce4dd353ee.png)

Es humano:

![image](https://user-images.githubusercontent.com/44062843/163072639-bcff9ad4-99cf-4dee-8f6e-e0ddccd99b20.png)

Estadisticas:

![image](https://user-images.githubusercontent.com/44062843/163072681-0c93413c-a5d2-4dad-9f83-2174c5883122.png)

## Pruebas Unitarias

Se completo un coverage > 80%

![image](https://user-images.githubusercontent.com/44062843/163075024-e1e336d7-8e07-4132-871f-5159db8f50bc.png)

## Despliegue automatico

Se configuro que cuando se haga un commit en la rama Master se despligue por medio Azure.

Gracias.


