package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;
import EntidadesGraficas.LabelEnemigo5;


/**
 * Clase que modela el movimiento del Shoryu.
 * Hace una especie de loop.
 */

public class EstrategiaEnemigo5 extends EstrategiaMovimiento {
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;
	private LabelEnemigo5 entidadGraf;

	public EstrategiaEnemigo5(Entidad entidad, int direccion) {
		super(entidad, direccion); 
		LabelEnemigo5 e5 = (LabelEnemigo5) entidad.getGrafico();
		e5.setDireccion(direccion);
	}

	public void mover() {
		entidadGraf = (LabelEnemigo5) entidad.getGrafico();
		if(!entidadGraf.estaMuerto()) {
			if(direccion == DERECHA)
				moverD();
			else moverI();
		}
	}

	private void moverI() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() - this.direccion * entidad.getVelocidad();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY+100 || siguientePosX < 0) {
			entidad.eliminar();
		}else 
			g.setLocation(siguientePosX, siguientePosY);
	}

	private void moverD() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY+100 || siguientePosX > limiteX+100) {
			entidad.eliminar();
		}else 
			g.setLocation(siguientePosX, siguientePosY);
	}
}
