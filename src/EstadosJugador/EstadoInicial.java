package EstadosJugador;

import Entidades.Jugador;
import Visitors.VisitorJugador;

/**
 * Clase que modela el estado inicial del jugador.
 */

public class EstadoInicial extends EstadoJugador {

	public EstadoInicial(Jugador jugador) {
		super(jugador);
		velocidad=7; 
		this.jugador.setVisitor(new VisitorJugador(jugador));
	}
}