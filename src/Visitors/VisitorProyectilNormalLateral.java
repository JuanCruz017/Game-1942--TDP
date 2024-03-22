package Visitors;


import Entidades.*;

import Entidades.ProyectilNormalLateral;


/*
 * Visitor del proyectil de los aviones laterales de los jugadores.
 * 
 */

public class VisitorProyectilNormalLateral extends Visitor{

	public VisitorProyectilNormalLateral(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Enemigo1 i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;
		e.eliminar();
		i.disminuirVida(e.getDamage());		
	}

	public void visit(Enemigo2 i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Enemigo3 i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Enemigo4 i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Enemigo5 i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Enemigo6 i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}

}
