package EntidadesGraficas;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelEnemigo6 extends LabelEnemigo{

	public LabelEnemigo6(Point p) {
		super(p);
		muerto = false;
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosEnemigos/Enemigo6.png"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	public void setDerecha() {
		if(muerto == false)
			reDimensionar(this, new ImageIcon(LabelJugador.class.getResource("/RecursosEnemigos/Enemigo6H.png")));
	}
	
	public void setAbajo() {
		if(muerto == false)
			reDimensionar(this, new ImageIcon(LabelJugador.class.getResource("/RecursosEnemigos/Enemigo6D .png")));
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(grafico.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}
}
