package Entidades;


import EntidadesGraficas.EntidadGrafica;
import Visitors.Visitor;
import Visitors.VisitorBala;


public abstract class Bala extends Proyectil {
	
	protected int rango;
	
	public Bala(EntidadGrafica entidad_graf) {
		super(entidad_graf);		
		visitor = new VisitorBala(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public int getRango() {
		return rango;
	}
	
	public void setDanio(int d) {
		damage = d;
	}
}