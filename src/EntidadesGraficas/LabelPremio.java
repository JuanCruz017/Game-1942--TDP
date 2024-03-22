package EntidadesGraficas;

import java.awt.Point;

public abstract class LabelPremio extends EntidadGrafica{

	public LabelPremio(Point p) {
		super();
		this.setLocation(p);
		this.setSize(50,50);
	}
}