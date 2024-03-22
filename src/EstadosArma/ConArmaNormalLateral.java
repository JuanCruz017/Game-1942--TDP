package EstadosArma;

import java.awt.Point;
import Entidades.AvionLateral;
import Entidades.Proyectil;
import Entidades.ProyectilNormalLateral;
import EntidadesGraficas.EntidadGrafica;

/*
 * Clase que representa el estado normal de un avion lateral.
 * 
 */

public class ConArmaNormalLateral extends EstadoArma {

	public ConArmaNormalLateral(AvionLateral jugador) {
		super(jugador);
	}

	public Proyectil disparar() {
		EntidadGrafica g = this.jugador.getGrafico();
		return new ProyectilNormalLateral(new Point(g.getX()-10, g.getY() - 30));
	}
}