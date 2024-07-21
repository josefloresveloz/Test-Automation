## Pre-condiciones:
* Tener Java version 22
* Tener Maven version 3+

## Para ejecutar usar el comando:
### Opcion 1: Ejecutar mediante maven
* mvn clean verify -Dcucumber.filter.tags=@TestDemoWeb -f pom.xml

### Opcion 2: Ejecutar mediante la clase RunnerTest
* En la opción de **tags = "@TestDemo"** colocar el tag a ejecutar