package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;
import EntidadesGraficas.LabelEnemigo6;

/**
 * Clase que modela el movimiento del enemigo Zero.
 * Se mueve en diagonal.
 */

public class EstrategiaEnemigo6 extends EstrategiaMovimiento {

	private int targetY = 100;
	private int targetX = 400;
	private boolean objetivoAlcanzado = false;
	private LabelEnemigo6 entidadGraf;

	public EstrategiaEnemigo6(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	public void mover() {
		entidadGraf = (LabelEnemigo6) entidad.getGrafico();
		if(!entidadGraf.estaMuerto()) {
			if(objetivoAlcanzado == false) {
	
				if (entidad.getGrafico().getY() > targetY) {
					moverArriba();
				} else if (entidad.getGrafico().getX() < targetX) {
					moverDerecha();
				}
	
			}else moverAbajo();
		}
	}

	private void moverDerecha() { 
		EntidadGrafica g = entidad.getGrafico();
		LabelEnemigo6 lz = (LabelEnemigo6)g;
		lz.setDerecha();
		int siguientePosX = g.getX() - this.direccion * entidad.getVelocidad();

		if (siguientePosX >= targetX) {
			objetivoAlcanzado = true;
			siguientePosX = targetX;
		}

		g.setLocation(siguientePosX, g.getY());
	}

	private void moverArriba() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > targetY) {
			g.setLocation(g.getX(), siguientePosY);
		} else {
			g.setLocation(g.getX(), targetY);
		}
	}

	private void moverAbajo() { 	
		EntidadGrafica g = entidad.getGrafico();
		LabelEnemigo6 lz = (LabelEnemigo6)g;
		lz.setAbajo();
		int siguientePosY = g.getY() - this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY+100) {
			entidad.eliminar();
		} else {
			g.setLocation(g.getX(), siguientePosY);
		}
	}
}
