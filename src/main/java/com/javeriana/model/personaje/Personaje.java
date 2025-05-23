package com.javeriana.model.personaje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Personaje implements Serializable {
    private int vida;
    private int ataqueBase;
    private List<Personaje> objetivos;

    public Personaje(int ataqueBase, int vida) {
        this.ataqueBase = ataqueBase;
        this.vida = vida;
        this.objetivos = new ArrayList<>();
    }


    public void atacarObjetivos() {

        List<Personaje> objetivosAEliminar = new ArrayList<>();

        for (Personaje objetivo : this.objetivos) {
            atacar(objetivo);
            if (objetivo.getVida() <= 0) {
                objetivosAEliminar.add(objetivo);
            }
        }
    }

    public abstract void atacar(Personaje objetivo);

    // Getters and setters
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public void setAtaqueBase(int ataqueBase) {
        this.ataqueBase = ataqueBase;
    }

    public List<Personaje> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(List<Personaje> objetivos) {
        this.objetivos = objetivos;
    }

    public void anadirObjetivo(Personaje objetivo) {
        this.objetivos.add(objetivo);
    }

    protected int recibirDano(int danoTotal) {

        int nuevaVida = this.vida - danoTotal;

        //En el parcial no dice nada de que la vida no puede ser negativa
        this.vida = nuevaVida;

        return this.vida;
    }
}
