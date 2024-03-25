package EntidadesGraficas;

import javax.swing.ImageIcon;

public class LabelAvionLateral extends EntidadGrafica {
	
	private String ruta = "/RecursosGraficos_Jugador/AvionLateral.png";

	public LabelAvionLateral() {
		super();
		this.setSize(50, 50);
		ImageIcon imagen = new ImageIcon(getClass().getResource(ruta));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setVisible(true);
	}
	
	public void setDiveo(boolean diveo) {
		//se queda con la misma identidad grafica
	}
}