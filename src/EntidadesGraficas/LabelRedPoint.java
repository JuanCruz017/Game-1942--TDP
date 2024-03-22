package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelRedPoint extends LabelPremioEspecial{

	public LabelRedPoint(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/puntos.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}	
}
