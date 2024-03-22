package Visitors;

import Entidades.AvionLateral;
import Entidades.Bala;
import Entidades.Enemigo1;
import Entidades.Enemigo2;
import Entidades.Enemigo3;
import Entidades.Enemigo4;
import Entidades.Enemigo5;
import Entidades.Enemigo6;
import Entidades.Entidad;
import Entidades.Jugador;
import Entidades.ProyectilNormal;
import Entidades.ProyectilNormalLateral;
import Premios.BlackLife;
import Premios.GrayPlane;
import Premios.OrangeInmunidad;
import Premios.RedPoint;

/**
 * Clase que modela las interacciones al colisionar.
 */

public abstract class Visitor {
	protected Entidad entidad;

	public Visitor(Entidad entidad) {
		this.entidad = entidad;
	}

	public void visit(Jugador jugador) {
	
	}
	
	public void visit(AvionLateral avion) {
		
	}

	public void visit(Enemigo3 e3) {
	
	}
	
	public void visit(Bala bala) {
		
	}

	public void visit(Enemigo4 e4) {
		
	}

	public void visit(ProyectilNormal proyectilNormal) {
		
	}

	public void visit(Enemigo1 e1) {
		
	}

	public void visit(Enemigo5 e5) {

	}

	public void visit(RedPoint redPoint) {
		
	}

	public void visit(BlackLife blackLife) {
		
	}

	public void visit(GrayPlane grayPlane) {
		
	}

	public void visit(OrangeInmunidad orangeinmunidad) {
		
	}

	public void visit(Enemigo2 e) {

	}

	public void visit(Enemigo6 e6) {
		
	}

	public void visit(ProyectilNormalLateral proyectilNormalLateral) {
		
	}
}