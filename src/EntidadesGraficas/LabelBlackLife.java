package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelBlackLife extends LabelPremioEspecial{

	public LabelBlackLife(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/vida.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
}
