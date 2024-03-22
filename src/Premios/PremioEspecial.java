package Premios;

import EntidadesGraficas.EntidadGrafica;
import Visitors.Visitor;

public abstract class PremioEspecial extends Premio{

	public PremioEspecial(EntidadGrafica entidad_graf) {
		super(entidad_graf);
	}
	
	public abstract void accept(Visitor visitor);
}
