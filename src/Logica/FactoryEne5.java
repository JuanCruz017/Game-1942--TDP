package Logica;

import java.awt.Point;
import Entidades.Enemigo;
import Entidades.Enemigo5;


/**
 * clase que se encarga de construir los enemigos tipo Shoryu
 *
 */

public class FactoryEne5 extends Factory {

	public FactoryEne5() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Enemigo5(p, tiempo+4000, enEspera);
		tiempo = tiempo + 3000;
		return ene;
	}

	private Point posicion() {
		return new Point(360, -100);
	}

	protected void reiniciar() {
		tiempo = 1;
	}
}