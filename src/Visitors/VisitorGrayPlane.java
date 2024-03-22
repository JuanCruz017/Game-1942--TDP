package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;
import Logica.Juego;

/*
 * Visitor del powerUP GrayPlane.
 * 
 */

public class VisitorGrayPlane extends VisitorPremioEspecial {

	public VisitorGrayPlane(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		jugador.CrearNavesLaterales();
		entidad.eliminar();
		Juego.getJuego().premioAgarrado();
	}

}
