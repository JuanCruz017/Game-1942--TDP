package EstadosArma;

import Entidades.Jugador;
import Entidades.Proyectil;

/*
 * Representa el estado del arma de un jugador.
 * 
 */

public abstract class EstadoArma {
	protected int velocidad_disparo;
	protected Jugador jugador;

	public EstadoArma(Jugador jugador) {
		this.jugador = jugador;
		velocidad_disparo = 10;
	}

	public abstract Proyectil disparar();
}