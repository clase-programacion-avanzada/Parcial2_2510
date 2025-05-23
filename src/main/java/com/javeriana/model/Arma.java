package com.javeriana.model;

import java.io.Serializable;

public class Arma implements Serializable {
    private int ataque;
    private int durabilidad;

    public Arma(int ataque, int durabilidad) {
        this.ataque = ataque;
        this.durabilidad = durabilidad;
    }

    // Getters and setters
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }

    public void disminuirDurabilidad() {
        this.durabilidad -= 1;
    }
}
