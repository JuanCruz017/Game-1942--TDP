package Premios;

import java.awt.Point;
import EntidadesGraficas.LabelGrayPlane;
import Visitors.Visitor;
import Visitors.VisitorGrayPlane;

/*
 * Clase que modela al powerUp GrayPlane.
 * Crea los aviones laterales del jugador.
 */

public class GrayPlane extends PremioEspecial{

	public GrayPlane(Point p) {
		super(new LabelGrayPlane(p));
		velocidad = 2;
		visitor = new VisitorGrayPlane(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
}
