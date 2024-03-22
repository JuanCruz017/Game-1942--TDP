package Entidades;

import java.awt.Point;

import Entidades.BalaBasica;
import EntidadesGraficas.LabelBalaBasica;
import EntidadesGraficas.LabelBalaBasica1;

import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;

/*
 * Implementacion auxiliar de las balas enemigas utilizadas para Enemigo5 y Enemigo6 porque aparecen por el norte del mapa
 * 
 */

public class BalaBasica1 extends Bala {

	public BalaBasica1(Point posicion, int pos) {
		super(new LabelBalaBasica1(posicion));
		velocidad = 6;
		damage = 5;
		rango = 400;
		movimiento = new VerticalRemove(this, pos);
	}

}