package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;

/**
 * Clase que modela el movimiento de una avion lateral derecha.
 */

public class HorizontalAvionLateralDerecha extends EstrategiaMovimiento {
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;
	private int limiteAvionX = 125;

	public HorizontalAvionLateralDerecha(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	public void mover() {
		EntidadGrafica g = this.entidad.getGrafico();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();
		if (siguientePosX > limiteX)
			g.setLocation(limiteX, g.getY());
		else {
			if (siguientePosX < limiteAvionX)
				g.setLocation(limiteAvionX, g.getY());
			else
				g.setLocation(siguientePosX, g.getY());
		}
	}
}