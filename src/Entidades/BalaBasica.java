package Entidades;

import java.awt.Point;
import EntidadesGraficas.LabelBalaBasica;
import EstrategiasMovimiento.VerticalRemove;

/*
 * Implementacion principal de las balas enemigas
 * 
 */

public class BalaBasica extends Bala {

	public BalaBasica(Point posicion, int pos) {
		super(new LabelBalaBasica(posicion));
		velocidad = 6;
		damage = 5;
		rango = 400;
		movimiento = new VerticalRemove(this, pos);
	}

}