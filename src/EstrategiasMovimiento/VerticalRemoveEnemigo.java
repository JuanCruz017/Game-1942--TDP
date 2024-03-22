package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;
import EntidadesGraficas.LabelEnemigo;

/*
 * Clase que modela el movimiento de los enemigos y que desaparezcan en base a su altura de manerea adecuada (sin que se note).
 * 
 */

public class VerticalRemoveEnemigo extends Vertical {
	private LabelEnemigo entidadGraf;

	public VerticalRemoveEnemigo(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	public void mover() {
		entidadGraf = (LabelEnemigo) entidad.getGrafico();
		if(!entidadGraf.estaMuerto()) {
			if(direccion == Vertical.ABAJO)
				moverAbajo();
			else moverArriba();
		}
	}

	private void moverAbajo() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY+entidad.getGrafico().getHeight()) {
			entidad.eliminar();
		}else 
			g.setLocation(g.getX(), siguientePosY);
	}

	private void moverArriba() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

		if (siguientePosY < -entidad.getGrafico().getHeight()) { 
			entidad.eliminar();
		}else
			g.setLocation(g.getX(), siguientePosY);
	}
}