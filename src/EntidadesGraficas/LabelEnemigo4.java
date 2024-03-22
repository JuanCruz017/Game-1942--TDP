package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelEnemigo4 extends LabelEnemigo{

	public LabelEnemigo4(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon((LabelEnemigo4.class.getResource("/RecursosEnemigos/Enemigo4.png")));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
