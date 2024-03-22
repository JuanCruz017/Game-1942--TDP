package Logica;

import java.awt.Point;
import Entidades.Enemigo;
import Entidades.Enemigo6;


/**
 * clase que se encarga de construir los enemigos tipo Zero
 *
 */

public class FactoryEne6 extends Factory {

	public FactoryEne6() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Enemigo6(p, tiempo+5000, enEspera);
		tiempo = tiempo + 3000;
		return ene;
	}

	private Point posicion() {
		return new Point(330, mapa.getWidth()+100); 
	}
	
	protected void reiniciar() {
		tiempo = 1;
	}

}