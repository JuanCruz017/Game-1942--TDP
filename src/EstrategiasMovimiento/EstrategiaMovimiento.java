package EstrategiasMovimiento;

import java.awt.Container;
import Entidades.Entidad;
import Logica.Juego;

public abstract class EstrategiaMovimiento {
	protected int direccion;
	protected Entidad entidad;
	protected int limiteX, limiteY;

	/**
	 * Crea la estrategia de movimiento de la entidad
	 * 
	 */
	
	public EstrategiaMovimiento(Entidad entidad, int direccion) {
		this.direccion = direccion;
		this.entidad = entidad;
		if(Juego.getJuego().getMapa() != null && entidad.getGrafico() != null) {
			Container mapa = Juego.getJuego().getMapa();
			limiteX = (int) mapa.getWidth() - (int) entidad.getGrafico().getWidth();
			limiteY = (int) mapa.getHeight() - (int) entidad.getGrafico().getHeight();
		}
	}

	/**
	 * Mueve la entidad a su posicion siguiente 
	 */
	
	public abstract void mover();

	/**
	 * Settea la direccionde movimiento de la entidad
	 * 
	 */
	
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
}