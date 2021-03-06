# GLOBAL STOCK SEARCHER

El presente proyecto consiste en una aplicación para calcular el mercado de valores de las acciones negociados en la Bolsa. Esta recibe el identificador de una acción y muestra en un principio el histórico de la valoración diaria, pero es posible cambiar esta a intra-dia, semanal y mensual. Para esto se utiliza el API [Alpha Vantage]( https://www.alphavantage.co/documentation)

## Comenzando 🚀

A continuación se presentarán series de instrucciones para que se pueda tener un funcionamiento en maquina local del proyecto


### Pre-requisitos 📋

Para el correcto funcionamiento en un ambiente de desarrollo se deberán tener instaladas las siguientes tecnologías:  
* [Git](https://git-scm.com/) - Software de control de versiones
* [Java 8](https://www.java.com/es/download/ie_manual.jsp) - Entorno de desarrollo
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spark](https://sparkjava.com/download) - Micro framework para el desarrollo de aplicaciones web en Java

### Instalación 🔧

1. **Clonar el proyecto**
    ```
    git clone https://github.com/AngieMeG/AREP-T01
    ```
2. **Compilar el proyecto**
    ```
    mvn package
    ```
3. **Ejecutar la aplicación**  
    * Para entornos Windows
        ```
        java -cp "target/classes;target/dependency/*" edu.escuelaing.arem.App
        ``` 
    * Para entornos Unix
        ```
        java $JAVA_OPTS -cp target/classes:target/dependency/* edu.escuelaing.arem.App
        ```
4. **Servicio Web**
Para observar la pagina web se debera
    ```
    localhost:4567
    ```
    Esto redireccionará al archivo index.html del proyecto
## Ejecutando las pruebas ⚙️

Para la ejecución de las pruebas
```
mvn test
```
Como nota, se tiene otra prueba escrita que no se ejecuta con el comando por las políticas del api utilizado actualmente )no se puede consultar el api más de 5 veces por minuto), por lo que se dejó comentada

## Arquitectura
Se cuenta con:
* Una clase cliente JavaScript
* Una clase servidor Spark ue funciona como fachada usando servicios REST
* Clase con la conección al API externo
* Se tiene ademas, un clase LRU Cache Singleton para que el servidor no tenga que hacer una busqueda al API siempre

![Arquitectura](img/Diagrama.PNG)
## Despliegue 📦

El despliegue de la aplicación se encuentra en [GSS](https://time-series-stock.herokuapp.com/)

## Extensibilidad 📁
Para poder consultar otro api como por ejemplo [IEX](https://iexcloud.io/docs/api/#chart) es necesario cambiar la instancia del servicio actual, para esto en la clase CurrentServiceInstance se debe cambiar el constructor con
```
service = new AlphaHttpStockService();
```
## Construido con 🛠️

* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spark](https://sparkjava.com/download) - El framework web usado
* [JQuery](https://jquery.com/) - Libreria JavaScript para el manejo del DOM
* [KnockoutJS](https://knockoutjs.com/) - Framework JavaScript usado para el manejo del patron de Model-View-ViewModel
* [JUnit](https://junit.org/junit5/) - Herramienta para pruebas unitarias en Java

## Documentación 📖
Para generar la documentación
```
mvn javadoc:javadoc
```
Esta se va a encontrar ```target/site/apidocs/index.html```

## Autores ✒️

* **Angie Tatiana Medina Gil**

## Licencia 📄

Este proyecto está bajo la Licencia GNU General Public License mire el archivo [LICENSE.md](LICENSE.md) para detalles
