package Premios;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import Visitors.Visitor;

/**
 * Clase que modela un premio del juego
 *
 */

public abstract class Premio extends Entidad {

	public Premio(EntidadGrafica entidad_graf) {
		super(entidad_graf);
		velocidad = 4;
		movimiento = new VerticalRemove(this,Vertical.ABAJO);		
	}
	
	public abstract void accept(Visitor visitor);
}