package Premios;

import java.awt.Point;

import EntidadesGraficas.LabelBlackLife;
import Visitors.Visitor;
import Visitors.VisitorBlackLife;

/**
 * Clase que modela al powerUp BlackPOW.
 * Incrementa la vida en 1.
 */

public class BlackLife extends PremioEspecial{

	public BlackLife(Point p) {
		super(new LabelBlackLife(p));
		velocidad = 2;
		visitor = new VisitorBlackLife(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
}
