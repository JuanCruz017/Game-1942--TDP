package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelEnemigo2 extends LabelEnemigo{

	public LabelEnemigo2(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosEnemigos/Enemigo2.png"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
