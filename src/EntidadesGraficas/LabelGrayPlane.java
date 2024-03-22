package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelGrayPlane extends LabelPremioEspecial{

	public LabelGrayPlane(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/plane.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
