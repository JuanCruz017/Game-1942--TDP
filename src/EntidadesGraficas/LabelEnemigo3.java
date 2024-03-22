package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelEnemigo3 extends LabelEnemigo{

	public LabelEnemigo3(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon((LabelEnemigo3.class.getResource("/RecursosEnemigos/Enemigo3.png")));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
