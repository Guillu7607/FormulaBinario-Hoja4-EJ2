# Resumen
Este proyecto consiste en una aplicación de consola desarrollada en Java para gestionar un registro de pilotos de Fórmula 1 (Piloto). El objetivo principal del ejercicio es aprender a persistir objetos en el almacenamiento local del sistema mediante serialización en archivos binarios (.dat), permitiendo que los datos se mantengan guardados de forma permanente entre diferentes ejecuciones del programa.

## Características
Persistencia de Objetos Avanzada: Utiliza flujos de bytes orientados a objetos (ObjectOutputStream y ObjectInputStream) para escribir y leer instancias completas de una clase sin necesidad de trocear los atributos en texto plano.

Interfaz por Consola Interactiva: Implementa un menú iterativo basado en un bucle do-while y una estructura switch-case con la sintaxis de flecha moderna de Java.

Prevención de Duplicados: Valida que el nombre del piloto sea único (ignorando mayúsculas y minúsculas con equalsIgnoreCase) antes de permitir su inserción en la lista en memoria.

Control de Flujo por Excepciones: Gestiona el final de un archivo binario de longitud desconocida capturando de forma controlada la excepción EOFException (End Of File).
