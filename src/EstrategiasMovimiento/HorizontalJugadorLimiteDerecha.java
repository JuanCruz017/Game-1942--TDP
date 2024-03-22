package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;

/**
 * Clase que modela el movimiento del jugador al tener un avion lateral derecho y se desea mover a derecha.
 */

public class HorizontalJugadorLimiteDerecha extends Horizontal {
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;
	private int limiteXDer = limiteX - 50;

	public HorizontalJugadorLimiteDerecha(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		EntidadGrafica g = this.entidad.getGrafico();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();
		if (siguientePosX > limiteXDer)
			g.setLocation(limiteXDer, g.getY());
		else {
			if (siguientePosX < 0)
				g.setLocation(0, g.getY());
			else
				g.setLocation(siguientePosX, g.getY());
		}

	}
}