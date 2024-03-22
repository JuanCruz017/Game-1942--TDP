package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;
import Logica.Juego;

/*
 * Visitor del powerUP redPoint.
 * 
 */

public class VisitorRedPoint extends VisitorPremioEspecial {

	public VisitorRedPoint(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		entidad.eliminar();
		Juego.getJuego().premioAgarrado();
		jugador.setPuntos(1000);
	}

}
