package com.javeriana.model;

import com.javeriana.model.personaje.Dragon;
import com.javeriana.model.personaje.Personaje;
import com.javeriana.model.personaje.Soldado;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Region {
    private String capital;
    private int recursos;
    private List<Personaje> ejercito;

    public Region(String capital, int recursos) {
        this.capital = capital;
        this.recursos = recursos;
        this.ejercito = new ArrayList<>();
    }

    /* **AñadirPersonaje**: este método recibe un string con la palabra "dragon" o"soldado", definiendo el tipo de Personaje que se debe crear.
                                    En caso de crear un Soldado, este cuesta 5 recursos y en caso de ser Dragón cuesta 10 recursos.
                                    Lanzar una excepción en caso de que no haya recursos necesarios.

     */
    public void anadirPersonaje(String tipoPersonaje) throws Exception {

        // Verificar si hay suficientes recursos
        if (tipoPersonaje.equalsIgnoreCase("soldado") && recursos < 5) {
            throw new Exception("No hay suficientes recursos para crear un Soldado.");
        } else if (tipoPersonaje.equalsIgnoreCase("dragon") && recursos < 10) {
            throw new Exception("No hay suficientes recursos para crear un Dragón.");
        }

        /* Alternativa 1
        Personaje personaje = null;
        if (tipoPersonaje.equalsIgnoreCase("soldado")) {
            personaje = new Soldado(1000, 100, 10, 40);
            recursos -= 5;
        } else if (tipoPersonaje.equalsIgnoreCase("dragon")) {
            personaje = new Dragon(500, 200, 20);
            recursos -= 10;
        } else {
            //No es necesario en el parcial, pero se deja para evitar errores
            throw new IllegalArgumentException("Tipo de personaje no válido.");
        }

         */

        //Alternativa 2
        Personaje nuevoPersonaje = switch(tipoPersonaje.toLowerCase()) {
            case "soldado" -> new Soldado(1000, 100, 10, 40);
            case "dragon" -> new Dragon(500, 200, 50);
            // No es necesario en el parcial, pero se deja para evitar errores
            default -> throw new IllegalArgumentException("Tipo de personaje no válido.");
        };

        ejercito.add(nuevoPersonaje);

    }
    /* **cantidadDragonesPoderosos**: retorna la cantidad de dragones en el ejército cuyo daño de fuego sea mayor a 50.
    */
    public int cantidadDragonesPoderosos() {
        //Alternativa 1
        int contador = 0;
        for (Personaje personaje : ejercito) {
            if (personaje instanceof Dragon dragon && dragon.getDanoFuego() > 50) {
                contador++;
            }
        }
        return contador;

        // Alternativa 2 usando streams
        /*
        return Math.toIntExact(ejercito.stream()
            .filter(personaje -> personaje instanceof Dragon dragon && dragon.getDanoFuego() > 50)
            .count());

         */
    }

    /* **guardarPersonajesBinario**: guardar en un archivo binario todos los personajes que hacen parte de la región.

     */
    public void guardarPersonajesBinario(String ruta) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(ejercito);
        }
    }

    /* **guardarPersonajesTexto**: guardar en un archivo de texto la información de los personajes, en el siguiente formato:
        Tipo de personaje: «Soldado o dragón»
        Ataque base: «ataqueBase»
        Vida: «vida»
        Ataque adicional: «para Dragón poner el ataque de fuego y para Soldado el ataque de su arma».
     */
    public void guardarPersonajesTexto(String ruta) throws IOException {
        Path rutaArchivo = Path.of(ruta);

        List<String> lineas = new ArrayList<>();

        for (Personaje personaje : ejercito) {
            String tipo = personaje instanceof Dragon ? "Dragón" : "Soldado";
            lineas.add("Tipo de personaje: " + tipo);
            lineas.add("Ataque base: " + personaje.getAtaqueBase());
            lineas.add("Vida: " + personaje.getVida());

            if (personaje instanceof Dragon dragon) {
                lineas.add("Ataque adicional: " + dragon.getDanoFuego());
            } else if (personaje instanceof Soldado soldado) {
                lineas.add("Ataque adicional: " + soldado.getAtaqueArma());
            }

            //Alternativa usando pattern matching
            /*
            int danoAdicional = switch (personaje) {
                case Dragon dragon -> dragon.getDanoFuego();
                case Soldado soldado -> soldado.getAtaqueArma();
                default -> 0; // No debería llegar aquí
            };

            lineas.add("Ataque adicional: " + danoAdicional);
            */

            lineas.add(""); // Línea en blanco entre personajes

        }

        Files.write(rutaArchivo, lineas);

    }

    // Getters and setters
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getRecursos() {
        return recursos;
    }

    public void setRecursos(int recursos) {
        this.recursos = recursos;
    }

    public List<Personaje> getEjercito() {
        return ejercito;
    }

    public void setEjercito(List<Personaje> ejercito) {
        this.ejercito = ejercito;
    }
}
