package Visitors;

import Entidades.AvionLateral;

/*
 * Visitor de aviones laterales del jugador.
 * 
 */

public class VisitorAvionLateral extends Visitor{

	public VisitorAvionLateral(AvionLateral entidad) {
		super(entidad);
	}
}
