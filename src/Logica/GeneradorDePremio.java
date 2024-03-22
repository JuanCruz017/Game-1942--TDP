package Logica;

import java.awt.Point;
import java.util.Random;

import Premios.BlackLife;
import Premios.GrayPlane;
import Premios.OrangeInmunidad;
import Premios.RedPoint;

/**
 * clase que se encarga de crear los premios de forma aleatoria 
 */

public class GeneradorDePremio {

	private static final int cantidadPremiosTemporales=1;
	private static final int cantidadPremios=4;
	
	public static void generar(Point p) {
		Random r= new Random();
		int indice=r.nextInt(cantidadPremios);
		Juego juego=Juego.getJuego();
		while(indice<cantidadPremiosTemporales && juego.getEstadoPremio()) {
			indice=r.nextInt(cantidadPremios);
		}
		switch(indice) {
			case 0: new RedPoint(p);
				break;
			case 1: new GrayPlane(p);
				break;
			case 2: new OrangeInmunidad(p);
				break;
			case 3: new BlackLife(p);
				break;
		}
	}
}