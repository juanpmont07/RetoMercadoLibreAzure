# Challenge Técnico en Mercado

Prueba técnica para ingreso a mercado libre.

# Introducción

El challenge consiste en crear un API REST para detectar si un humano es mutante y las estadisticas.

### Tecnologias Usadas

1. [Spring boot](https://spring.io/projects/spring-boot)
2. [Spring Jpa](https://spring.io/projects/spring-data-jpa)
3. [Lombok](https://projectlombok.org/)
4. [Azure](https://docs.microsoft.com/en-us/azure/?product=popular)

## Comenzando 🚀

Estas instrucciones te permitirán ejecutar proyecto .

### Pre-requisitos 📋

Programas necesitas para ejecutar el software

1. [Postman](https://www.postman.com/)

### Consumo del Servicio


1. Abrir Postman.

![image](https://user-images.githubusercontent.com/44062843/163070200-0a8d1cbd-5b59-4884-abd8-e5443c65f9a7.png)

2. Damos en el bóton **New** y Luego seleccionamos **Http Request**.

![image](https://user-images.githubusercontent.com/44062843/163070524-9cfd8f5c-2393-4c94-ac12-002d8295c194.png)

3. Seleccionamos el metodo GET O POST.

![image](https://user-images.githubusercontent.com/44062843/163070616-301d072c-ed6c-473f-9deb-725f1215cb52.png)

4. Luego ingresamos la Url base del servicio..

<pre><code>`https://x-men-api.azurewebsites.net/`</code></pre>

![image](https://user-images.githubusercontent.com/44062843/163070926-c662f186-7be8-4e64-921b-0b9b660d968a.png)

5. Cuando el método es GET no se requiere Body.

6. Si el método es POST si requiere body el cual puedes seleccionar y luego se elige RAW Y formato JSON.

![image](https://user-images.githubusercontent.com/44062843/163072151-21885688-09f7-4f81-8941-ff2575d00409.png)

7. Y por ultimo de damos en el bóton **Send**.

### Es mutante

Request: 

<pre><code>`https://x-men-api.azurewebsites.net/mutant/`</code></pre>

Method: POST

Body: Is Human

<pre><code>`{ "dna": ["TTGCGA", "CAGTGC", "TTAAAT", "ACAAGG","CACCTC", "TCACTG"] }`</code></pre>

Body: Is Mutant

<pre><code>`{ "dna": ["TTGCGA", "CAGTGC", "TTAAAT", "ACAAGG","CACCTC", "TCACTG"] }`</code></pre>

### Estadisticas

Request: 

<pre><code>`https://x-men-api.azurewebsites.net/stats/`</code></pre>

Method: GET




