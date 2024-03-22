package Visitors;

import Entidades.AvionLateral;
import Entidades.Enemigo;
import Entidades.Entidad;
import Entidades.Jugador;

/*
 * Visitor de enemigo.
 * 
 */

public class VisitorEnemigo extends Visitor{

	public VisitorEnemigo(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador j) {
		Enemigo enemigo = (Enemigo) this.entidad;
		j.decrementarVidas();
	}
	
	public void visit(AvionLateral j) {
		Enemigo enemigo = (Enemigo) this.entidad;
		j.decrementarVidas();
	}
}