package Logica;

import java.awt.Point;
import Entidades.Enemigo;
import Entidades.Enemigo4;

/**
 * clase que se encarga de construir los enemigos tipo Raizan
 *
 */
public class FactoryEne4 extends Factory {

	public FactoryEne4() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Enemigo4(p, tiempo+2000, enEspera);
		tiempo = tiempo + 3000;
		return ene;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth() - 60), mapa.getHeight()+100); //CAMBIAR POSICION SPAWN
	}

	protected void reiniciar() {
		tiempo = 1;
	}
}