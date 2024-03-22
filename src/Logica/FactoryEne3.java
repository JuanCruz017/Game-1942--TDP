package Logica;

import java.awt.Point;
import Entidades.Enemigo;
import Entidades.Enemigo3;


/**
 * clase que se encarga de construir los enemigos tipo Qing
 *
 */

public class FactoryEne3 extends Factory {

	public FactoryEne3() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Enemigo3(p, tiempo, enEspera);
		tiempo = tiempo + 1000;
		return ene;
	}

	private Point posicion() {
		return new Point(150, mapa.getHeight()+100); //CAMBIAR POSICION SPAWN
	}

	protected void reiniciar() {
		tiempo = 1;
	}
}