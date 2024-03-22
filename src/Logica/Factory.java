package Logica;

import java.awt.Container;
import java.util.Random;
import Entidades.Enemigo;

/**
 * clase abstracta que modela la creacion de los enemigos, cada tipo concreto
 * de Factory realiza la construccion de un tipo distinto de Enemigo
 */

public abstract class Factory {
	protected Container mapa;
	protected Random r;
	protected int tiempo;

	public Factory() {
		tiempo = 1;
		mapa = Juego.getJuego().getMapa();
		r = new Random();
	}

	public abstract Enemigo crearEnemigo(boolean enEspera);

	protected abstract void reiniciar();
}