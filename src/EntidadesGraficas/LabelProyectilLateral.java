package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelProyectilLateral extends LabelProyectilJugador {

	public LabelProyectilLateral(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(LabelProyectilLateral.class.getResource("/RecursosGraficos_Jugador/BalaBasica.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}