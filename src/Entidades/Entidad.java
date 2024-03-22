package Entidades;

import EntidadesGraficas.EntidadGrafica;
import EstrategiasMovimiento.EstrategiaMovimiento;
import Logica.Juego;
import Visitors.Element;
import Visitors.Visitor;

/**
 * Clase que modela la Entidad del juego
 * Todas tienen una determinada velocidad, entidad grafica y estrategia de movimiento.
 *
 */

public abstract class Entidad extends Element {
	protected int velocidad;
	protected EntidadGrafica entidad_graf;
	protected EstrategiaMovimiento movimiento;
	protected Juego juego;
	protected Visitor visitor;

	public Entidad(EntidadGrafica entidad_graf) {
		this.juego = Juego.getJuego();
		this.juego.agregarEntidad(this);
		this.entidad_graf = entidad_graf;
	}

	public void accionar() {
		this.movimiento.mover();
	}
	
	public abstract void accept(Visitor visitor);

	public void setMovimiento(EstrategiaMovimiento movimiento) {
		this.movimiento = movimiento;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void eliminar() {
		juego.eliminarEntidad(this);
	}

	public EntidadGrafica getGrafico() {
		return entidad_graf;
	}

	public Visitor getVisitor() {
		return visitor;
	}
}