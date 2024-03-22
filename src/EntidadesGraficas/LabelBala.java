package EntidadesGraficas;

import java.awt.Point;

public abstract class LabelBala extends LabelProyectil {
	
	public LabelBala(Point p) {
		super(p);
		this.setSize(50, 50);
	}
}