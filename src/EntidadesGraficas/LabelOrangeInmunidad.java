package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelOrangeInmunidad extends LabelPremioTemporal {

	public LabelOrangeInmunidad(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/inmunidad.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}