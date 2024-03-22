package Visitors;

import Entidades.AvionLateral;
import Entidades.Bala;
import Entidades.Entidad;
import Entidades.Jugador;

/*
 * Visitor de las balas del enemigo.
 * 
 */

public class VisitorBala extends Visitor{

	public VisitorBala(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador j) {
		Bala p = (Bala) entidad;
		p.eliminar();
		j.decrementarVidas();
		j.decrementarVidas(); //resta mas vida que el resto
	}
	
	public void visit(AvionLateral j) {
		Bala p = (Bala) entidad;
		p.eliminar();
		j.decrementarVidas();
		j.decrementarVidas(); //resta mas vida que el resto
	}

}
