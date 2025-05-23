# Solución Segundo Parcial Programación Avanzada - 2510

## I. (20 PUNTOS) CONCEPTOS

1. **Un método abstracto puede declararse final**
    - [ ] a. Verdadero
    - [ ] b. Falso
    <details>
      <summary>Respuesta</summary>
      b. Falso. Un método abstracto no puede ser final porque se espera que sea implementado en una subclase. Un método final no puede ser sobrescrito, lo que contradice la naturaleza de un método abstracto.
    </details>
2. **En Java, la clase Object es la única clase que no hereda de ninguna otra clase.**
   - [ ] a. Verdadero
   - [ ] b. Falso
   <details>
        <summary>Respuesta</summary>
        a. Verdadero. En Java, todas las clases heredan de la clase Object, que es la raíz de la jerarquía de clases.
   </details>
3. **¿Cuál de las siguientes formas es válida para crear una excepción personalizada en Java?**
   - [ ] a. Extender la clase Exception
   - [ ] b. Extender la clase RuntimeException
   - [ ] c. Crear una clase que implemente la interfaz Throwable
   - [ ] d. Todas las anteriores
    <details>
        <summary>Respuesta</summary>
        d. Todas las anteriores. En Java, se pueden crear excepciones personalizadas extendiendo Exception, RuntimeException o implementando la interfaz Throwable.
    </details>
4. **Para evitar problemas de incompatibilidad en la serialización de objetos, se recomienda definir:**
   - [ ] a. El atributo `serialVersionUID`
   - [ ] b. Un método `toString()`
   - [ ] c. Un constructor sin parámetros
   - [ ] d. Un método final
    <details><summary>Respuesta</summary>a. El atributo `serialVersionUID`.</details>

5. **La sobrecarga de un método hace referencia a:**
   - [ ] a. Definir varios métodos con el mismo nombre, pero con diferente número de parámetros
   - [ ] b. Definir varios métodos con el mismo nombre, pero diferente tipo de retorno
   - [ ] c. Definir varios métodos con el mismo nombre, pero con diferentes tipos o cantidad de parámetros
   - [ ] d. Redefinir un método de la superclase en la subclase
    <details><summary>Respuesta</summary>c. Definir varios métodos con el mismo nombre, pero con diferentes tipos o cantidad de parámetros</details>

6. **¿Cuál de las siguientes declaraciones de método es inválida en una clase abstracta?**
   - [ ] a. `public abstract void hacerSonido();`
   - [ ] b. `public void dormir() { irADormir(); }`
   - [ ] c. `private abstract void caminar();`
   - [ ] d. Todas son válidas
    <details><summary>Respuesta</summary>c. `private abstract void caminar();`</details>

7. **¿Cuál de las siguientes líneas de código representa correctamente el uso de polimorfismo?**
   - [ ] a. `Circulo c = new Figura();`
   - [ ] b. `Figura f = new Circulo();`
   - [ ] c. `Figura f = new Figura();`
   - [ ] d. `Circulo c = (Circulo) new Cuadrado();`
    <details><summary>Respuesta</summary>b. `Figura f = new Circulo();`</details>

8. **En Java, ¿cuál es la diferencia principal entre una excepción chequeada y una excepción no chequeada?**
   - [ ] a. Las excepciones chequeadas no se pueden capturar con try-catch, mientras que las no chequeadas sí
   - [ ] b. Las excepciones chequeadas deben ser declaradas o manejadas explícitamente, mientras que las no chequeadas no
   - [ ] c. Las excepciones no chequeadas siempre terminan la ejecución del programa
   - [ ] d. Las excepciones chequeadas son subclases de `RuntimeException`, mientras que las no chequeadas son subclases de `Exception`
    <details><summary>Respuesta</summary>b. Las excepciones chequeadas deben ser declaradas o manejadas explícitamente, mientras que las no chequeadas no</details>

9. **¿El siguiente fragmento de código implementa correctamente el concepto de herencia?**
    ```java
    class Vehiculo {
        public void arrancar() {
            System.out.println("arrancando...");
        }
    }
    
    class Auto extends Vehiculo {
        public void detenerse() {
            System.out.println("deteniendo...");
        }
    }
    ```
   - [ ] a. No, porque la palabra correcta para heredar es implements
   - [ ] b. No, porque Auto no puede tener métodos propios
   - [ ] c. No, porque Vehiculo debería ser una clase abstracta
   - [ ] d. Sí, porque Auto hereda el método arrancar de Vehiculo
   <details><summary>Respuesta</summary>d. Sí, porque Auto hereda el método `arrancar` de Vehiculo</details>

10.	La palabra clave throws sirve para:

    - [ ] a. Propagar la excepción para que otro método la maneje
    - [ ] b. Controlar la excepción con un bloque try-catch
    - [ ] c. Para que el desarrollador arroje una excepción
    - [ ] d. Para que el compilador arroje una excepción
    <details><summary>Respuesta</summary>a. Propagar la excepción para que otro método la maneje</details>
---

## II. (80 PUNTOS) ESTRATEGIA FANTÁSTICA: BATALLAS REGIONALES

En el siguiente programa simulará una guerra entre regiones de un reino fantástico.
    
1. **(15 puntos) Definición de clases y atributos:** Defina todas las clases representadas en el siguiente diagrama UML. Solo debe definir el encabezado de cada clase y **TODOS** sus atributos.

   1. Generar el constructor de _Personaje, Soldado y Dragón_. El constructor de _Soldado_ recibe ataque y durabilidad para crear el arma. La lista de objetivos se debe crear vacía en ambos casos. 
   2. La clase _Personaje_ es abstracta. Escribir para la clase _Personaje_ los métodos abstractos que tenga.</br>

2. **(65 puntos) Definición de métodos:**

| Clase     | Puntos | Método                                                                                                                                                                                                                                                                                                                                                                     |
|-----------|--------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Dragón    | 5      | [**atacar**](src/main/java/com/javeriana/model/personaje/Dragon.java#12): baja la vida del objetivo en un total de `ataqueBase + dañoFuego`.                                                                                                                                                                                                                               |
| Soldado   | 5      | [**atacar**](src/main/java/com/javeriana/model/personaje/Soldado.java#12): baja la vida del objetivo en un total de `ataqueBase + ataque de arma`. También baja la durabilidad del arma en 1.                                                                                                                                                                              |
| Personaje | 15     | [**añadirObjetivo**](src/main/java/com/javeriana/model/personaje/Personaje.java#12): ataca todos los personajes que hacen parte de la lista de objetivos. En caso de que la vida de uno de los personajes pase a ser negativa, este se debe eliminar de la lista de objetivos.                                                                                             |
| Región    | 15     | [**añadirPersonaje**](src/main/java/com/javeriana/model/Region.java#12): este método recibe un string con la palabra "dragon" o"soldado", definiendo el tipo de Personaje que se debe crear. En caso de crear un Soldado, este cuesta 5 recursos y en caso de ser Dragón cuesta 10 recursos. Lanzar una excepción en caso de que no haya recursos necesarios.              |
| Región    | 10     | [**cantidadDragonesPoderosos**](src/main/java/com/javeriana/model/Region.java#12): retorna la cantidad de dragones en el ejército cuyo daño de fuego sea mayor a 50.                                                                                                                                                                                                       |
| Región    | 5      | [**guardarPersonajesBinario**](src/main/java/com/javeriana/model/Region.java#12): guardar en un archivo binario todos los personajes que hacen parte de la región.                                                                                                                                                                                                         |
| Región    | 10     | [**guardarPersonajesTexto**](src/main/java/com/javeriana/model/Region.java#12): guardar en un archivo de texto la información de los personajes, en el siguiente formato:<br/><br/>Tipo de personaje: «Soldado o dragón»<br/> Ataque base: «ataqueBase»<br/>Vida: «vida»<br/>Ataque adicional: «para Dragón poner el ataque de fuego y para Soldado el ataque de su arma». |

> [!NOTE]
> Para cualquiera de estos métodos puede usar métodos desarrollados en otros puntos del parcial. En caso de usar métodos adicionales o auxiliares que no estén incluidos en este enunciado, debe implementarlos completamente.
