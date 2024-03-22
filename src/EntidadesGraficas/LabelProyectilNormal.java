package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelProyectilNormal extends LabelProyectilJugador {

	public LabelProyectilNormal(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(LabelProyectilNormal.class.getResource("/RecursosGraficos_Jugador/Missiles.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}