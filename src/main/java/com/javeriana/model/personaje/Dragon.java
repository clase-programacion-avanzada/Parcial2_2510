package com.javeriana.model.personaje;

public class Dragon extends Personaje {
    private int danoFuego;

    public Dragon(int vida, int ataqueBase, int danoFuego) {
        super(ataqueBase, vida);
        this.danoFuego = danoFuego;
    }

    @Override
    public void atacar(Personaje objetivo) {
        int danoTotal = getAtaqueBase() + danoFuego;
        objetivo.recibirDano(danoTotal);

        //Alternariva
        /*
        int nuevaVida = objetivo.getVida() - danoTotal;
        objetivo.setVida(nuevaVida < 0 ? 0 : nuevaVida);

        */
    }

    // Getters and setters
    public int getDanoFuego() {
        return danoFuego;
    }

    public void setDanoFuego(int danoFuego) {
        this.danoFuego = danoFuego;
    }
}
