package Entidades;

import java.awt.Point;

import EntidadesGraficas.LabelProyectilNormal;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import Visitors.Visitor;
import Visitors.VisitorProyectilNormal;

/*
 * Proyectil del jugador principal.
 * 
 */

public class ProyectilNormal extends Proyectil {

	public ProyectilNormal(Point posicion) {
		super(new LabelProyectilNormal(posicion));
		movimiento = new VerticalRemove(this, Vertical.ARRIBA);
		visitor = new VisitorProyectilNormal(this);
		velocidad = 6;
		damage = 7;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}