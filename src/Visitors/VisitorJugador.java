package Visitors;

import Entidades.Jugador;

/*
 * Visitor del jugador.
 * 
 */

public class VisitorJugador extends Visitor{

	public VisitorJugador(Jugador entidad) {
		super(entidad);
	}
}
