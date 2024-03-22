package Premios;

import java.awt.Point;
import EntidadesGraficas.LabelRedPoint;
import Visitors.Visitor;
import Visitors.VisitorRedPoint;

/**
 * Clase que modela al powerUp RedPoint.
 * Da 1000 puntos al jugador.
 */

public class RedPoint extends PremioEspecial{

	public RedPoint(Point p) {
		super(new LabelRedPoint(p));
		velocidad = 2;
		visitor = new VisitorRedPoint(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
