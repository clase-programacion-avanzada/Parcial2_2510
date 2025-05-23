package com.javeriana;

import com.javeriana.model.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear una región
            Region region = new Region("Capital del Reino", 50);
            
            // Añadir personajes
            region.anadirPersonaje("soldado");
            region.anadirPersonaje("dragon");
            
            System.out.println("Personajes en el ejército: " + region.getEjercito().size());
            System.out.println("Recursos restantes: " + region.getRecursos());
            System.out.println("Dragones poderosos: " + region.cantidadDragonesPoderosos());
            
            // Guardar personajes en archivos
            region.guardarPersonajesBinario("personajes.dat");
            region.guardarPersonajesTexto("personajes.txt");
            
            System.out.println("Archivos guardados exitosamente");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}