package Logica;

import java.awt.Point;

import Entidades.Enemigo;
import Entidades.Enemigo1;

/**
 * clase que se encarga de construir los enemigos tipo Daihiryu
 *
 */
public class FactoryEne1 extends Factory {

	public FactoryEne1() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Enemigo1(p, tiempo+3000, enEspera);
		tiempo = tiempo + 5000;
		return ene;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth() - 60), mapa.getHeight()+100); //CAMBIAR POSICION SPAWN
	}

	protected void reiniciar() {
		tiempo = 1;
	}

}