package Entidades;

import java.awt.Point;

import EntidadesGraficas.LabelProyectilLateral;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import Visitors.Visitor;
import Visitors.VisitorProyectilNormal;
import Visitors.VisitorProyectilNormalLateral;

/*
 * Proyectil de los aviones laterales en caso de tenerlos.
 * 
 */

public class ProyectilNormalLateral extends Proyectil {

	public ProyectilNormalLateral(Point posicion) {
		super(new LabelProyectilLateral(posicion));
		movimiento = new VerticalRemove(this, Vertical.ARRIBA);
		visitor = new VisitorProyectilNormalLateral(this);
		velocidad = 6;
		damage = 3;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}