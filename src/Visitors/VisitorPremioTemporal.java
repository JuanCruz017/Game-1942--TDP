package Visitors;

import Entidades.Entidad;

public class VisitorPremioTemporal extends Visitor{
	protected int duracion;

	public VisitorPremioTemporal(Entidad entidad) {
		super(entidad);
	}
}
