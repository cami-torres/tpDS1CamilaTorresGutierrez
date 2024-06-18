# tpDiseno

## Requisitos

- Java 17
- Maven
- Mysql

## Como configurar la base de datos

Editar el archivo application.properties con los valores requeridos para conectarse a la base de datos.

## Cómo empaquetar y ejecutar la aplicación

### Paso 1: Navegar al directorio raíz del proyecto

Antes de ejecutar los comandos, asegúrate de navegar al directorio raíz de tu proyecto:

```sh
cd path/to/your/project
```
### Paso 2: Empaquetar la aplicación

Ejecuta el siguiente comando para limpiar el proyecto y empaquetar la aplicación en un archivo jar

```sh
mvn clean package
```

### Paso 3: Ejecutar la aplicación

Para ejecutar la aplicación, utiliza el siguiente comando

```bash
java -jar target/tpDiseno-X.X.X.jar
```
### Paso 4: Acceder a la aplicación

La aplicación se ejecutará en el path http://localhost:8082/


## Notas

Asegurarse de tener Java 17 y Maven instalados y configurados en tu sistema.
