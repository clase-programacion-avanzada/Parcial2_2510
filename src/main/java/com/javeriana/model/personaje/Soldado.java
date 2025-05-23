package com.javeriana.model.personaje;

import com.javeriana.model.Arma;

public class Soldado extends Personaje {
    private Arma arma;

    public Soldado(int vida, int ataqueBase, int ataqueArma, int durabilidad) {
        super(ataqueBase, vida);
        this.arma = new Arma(ataqueArma, durabilidad);
    }


    @Override
    public void atacar(Personaje objetivo) {
        int danoTotal = getAtaqueBase() + arma.getAtaque();

        objetivo.recibirDano(danoTotal);
        arma.disminuirDurabilidad();
        //Alternativa
        /*
        objetivo.setVida(objetivo.getVida() - danoTotal);
        arma.setDurabilidad(arma.getDurabilidad() - 1);

         */
    }

    // Getters and setters
    public Arma getArma() {
        return arma;
    }

    public int getAtaqueArma() {
        return arma.getAtaque();
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
}
