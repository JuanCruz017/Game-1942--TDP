package Visitors;


import Entidades.Enemigo1;
import Entidades.Enemigo2;
import Entidades.Enemigo3;
import Entidades.Enemigo4;
import Entidades.Enemigo5;
import Entidades.Enemigo6;
import Entidades.Entidad;

import Entidades.ProyectilNormal;


/*
 * Visitor del proyectil del jugador.
 * 
 */

public class VisitorProyectilNormal extends Visitor{

	public VisitorProyectilNormal(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Enemigo1 i) {
		ProyectilNormal e = (ProyectilNormal) entidad;
		e.eliminar();
		i.disminuirVida(e.getDamage());		
	}

	public void visit(Enemigo2 i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Enemigo3 i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Enemigo4 i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Enemigo5 i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Enemigo6 i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}

}
