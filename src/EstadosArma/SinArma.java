package EstadosArma;

import Entidades.Jugador;
import Entidades.Proyectil;

/*
 * Clase que inhabilita al jugador disparar el arma. 
 * Se aplica cuando el jugador divea.
 *
 */

public class SinArma extends EstadoArma {

	public SinArma(Jugador jugador) {
		super(jugador);
	}

	public Proyectil disparar() {
		return null;
	}
}