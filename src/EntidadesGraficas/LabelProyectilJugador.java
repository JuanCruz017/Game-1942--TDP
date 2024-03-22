package EntidadesGraficas;

import java.awt.Point;

public abstract class LabelProyectilJugador extends LabelProyectil {

	public LabelProyectilJugador(Point p) {
		super(p);
		this.setBounds(this.getX()+7, this.getY(), 60, 60);
	}

}