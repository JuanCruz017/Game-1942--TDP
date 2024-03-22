package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;

public class Horizontal extends EstrategiaMovimiento {
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;

	public Horizontal(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	public void mover() {
		EntidadGrafica g = this.entidad.getGrafico();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();
		if (siguientePosX > limiteX)
			g.setLocation(limiteX, g.getY());
		else {
			if (siguientePosX < 0)
				g.setLocation(0, g.getY());
			else
				g.setLocation(siguientePosX, g.getY());
		}
	}
}