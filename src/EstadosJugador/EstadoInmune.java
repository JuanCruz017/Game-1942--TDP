package EstadosJugador;

import Entidades.Jugador;

/**
 * Clase que modela el estado del jugador cuando divea o agarra el powerUp powOrange.
 */

public class EstadoInmune extends EstadoJugador {

	public EstadoInmune(Jugador jugador) {
		super(jugador);
		velocidad = jugador.getVelocidad();
	}

	public void decrementarVidaJugador() {
		//no hace nada porque es inmune 
	}
}