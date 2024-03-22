package Premios;

import java.awt.Point;

import EntidadesGraficas.LabelOrangeInmunidad;
import Visitors.Visitor;
import Visitors.VisitorOrangeInmunidad;

/**
 * Clase que modela al powerUp Orangeinmunidad.
 * Da inmunidad por 3 segundos.
 */

public class OrangeInmunidad extends PremioTemporal{

	public OrangeInmunidad(Point p) {
		super(new LabelOrangeInmunidad(p));
		velocidad = 2;
		duracion = 3000;
		visitor = new VisitorOrangeInmunidad(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);	
	}
}
