package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;
import Logica.Juego;

/*
 * Visitor del powerUP blackLife.
 * 
 */

public class VisitorBlackLife extends VisitorPremioEspecial {

	public VisitorBlackLife(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		entidad.eliminar();
		Juego.getJuego().premioAgarrado();
		jugador.incrementarVida();
	}

}
