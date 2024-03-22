package EstadosJugador;

import Entidades.Jugador;

/**
 * Clase que modela el estado del jugador.
 */

public abstract class EstadoJugador {
	protected Jugador jugador;
	protected int velocidad;

	public EstadoJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void decrementarVidaJugador() {
		jugador.restarVida();
	}
}