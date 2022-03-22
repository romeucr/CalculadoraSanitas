# Calculadora Sanitas

## Presentación
La Calculadora Sanitas es un microservicio desarrollado en Java + Spring y tiene como
objetivo disponibilizar una API REST para la realización de operaciones matemáticas.
Por ahora solamente SUMA y RESTA entre dos números están disponibles.

### Design Pattern
Ha sido elegido el [Strategy](https://refactoring.guru/es/design-patterns/strategy/java/example) Design Pattern para desarrollar el microservicio.
Este patrón de design nos permite cambiar el comportamiento de una clase sin extenderla y con eso añadir nuevas operaciones a la calculadora muy facilmente.

Para eso basta añadir una nueva clase que implemente la interface MathOperations, incluir el nuevo tipo de operación en 
el enumerado OperationTypeEnum y bifurcar el flujo en CalculatorService para llamar a la instancia de dicha operación.

La clase de contexto Calculation es responsable por llamar la ejecución de la operación.

### BigDecimal
Se utiliza el tipo [BigDecimal](https://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html) para
representar los números por ser el tipo apropriado cuando necesitamos que los datos sean más precisos.

### Exception Handler
Ha sido implementado una clase responsable por interceptar excepciones para tratar los errores, devolviendo una respuesta
que sea más entendible. En esta clase también se hace el trace de los errores, añadiéndolos en los logs.

### TracerAPI
La librería de trace, una librería externa, que ha sido añadida al proyecto. Para poder utilizarla, ha sido creada una clase de
configuración responsable por la creación del bean que será utilizado en la aplicación.

### Pruebas Unitarias
Han sido creadas pruebas unitarias para el controller, para el service y para las clases que implementan las operaciones
matemáticas. Fueron utilizados JUnit5 y Mockito.

### Controller
Un controller único para la calculadora ha sido implementado. Es responsable por recibir la petición y repasar los
datos al service para que la operación sea realizada. Una vez terminada la operación, el service devolve el
resultado que es enviado como respuesta.

La petición de una operación debe ser hecha a través de una petición HTTP POST y su body, un JSON, debe contener los dos
números de la operación y su tipo. Ejemplo:
````json
{
    "number1": 10.50,
    "number2": 5.50,
    "operation": "SUM"
}
````
La respuesta consiste en un objeto que contiene el resultado de la operación.

La API está disponible en /calculator/calculate

## Deploy
Para hacer el deploy en local de la aplicación, seguir los siguientes pasos:
1) Clonar el repositorio
```shell
git clone https://github.com/romeucr/CalculadoraSanitas.git
```
2) En la carpeta de la aplicación, instalar el jar de la librería de trace en el repositorio local de maven <path_to_jar_file> corresponde
   a la carpeta dónde está el jar de la librería. Al clonar el proyecto, el jar está en la carpeta lib.
```shell
   mvn install:install-file \
   -Dfile="<path_to_jar_file>" \
   -DgroupId="io.corp.calculator" \
   -DartifactId=tracer \
   -Dversion="1.0.0" \
   -Dpackaging=jar \
   -DgeneratePom=true
```
3) En la carpeta de la aplicación hacer el build de la aplicación:
````shell
mvn clean install
````
4) En la carpeta de la aplicación ejecutar aplicación:
````shell
mvn spring-boot:run
````

5) La API estará disponible en http://localhost:8080/calculator/calculate
## Deploy en Docker
1) Ejecutar los pasos 1, 2 y 3 del tópico anterior.
2) Crear una imagen con la aplicación. En la carpeta de la aplicación (donde se encuentra el fichero Dockerfile)
   ejecutar el comando:
````dockerfile
docker build -t calcsanitas
````
3) Ejecutar un container con la imagen creada:
````dockerfile
docker run -p 8080:8080
````
La API estará disponible en http://localhost:8080/calculator/calculate

## Hacer una petición
1) Ejecutar el comando:
````shell
curl --location --request POST 'http://localhost:8080/calculator/calculate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "number1": 10.250,
    "number2": 5.150,
    "operation": "SUM"
}'
````
ATENCIÓN: las operaciones disponibles son SUM (SUMA) y SUBTRACTION (RESTA)