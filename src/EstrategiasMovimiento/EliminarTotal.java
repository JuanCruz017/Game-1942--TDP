package EstrategiasMovimiento;

import Entidades.Entidad;

/**
 * Clase que modela la eliminacion de la entidad.
 */

public class EliminarTotal extends EstrategiaMovimiento {

	public EliminarTotal(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	public void mover() {
		entidad.eliminar();
	}
}