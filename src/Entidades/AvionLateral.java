package Entidades;

import java.util.Timer;
import java.util.TimerTask;
import EntidadesGraficas.LabelAvionLateral;
import EstadosArma.ConArmaNormalLateral;
import EstadosArma.EstadoArma;
import EstadosArma.SinArma;
import EstadosJugador.EstadoInicial;
import EstadosJugador.EstadoInmune;
import EstadosJugador.EstadoJugador;
import EstrategiasMovimiento.Horizontal;
import EstrategiasMovimiento.HorizontalAvionLateralDerecha;
import EstrategiasMovimiento.HorizontalAvionLateralIzquierdo;
import EstrategiasMovimiento.Vertical;
import Visitors.Visitor;
import Visitors.VisitorAvionLateral;

/*
 * Clase que modela aviones laterales que se unen al jugador al agarrar el powerUp Gray
 * 
 */


public class AvionLateral extends Jugador {
	protected EstadoArma estado_arma;
	protected EstadoJugador estado_avion;
	protected int vidas, tiros, desplazamientoI, tipo;
	protected Jugador jugadorPadre;
	private boolean restandoVida;

	public AvionLateral(Jugador j, int i) {
		super(false);  
		jugadorPadre = j;
		entidad_graf = new LabelAvionLateral();
		desplazamientoI = 0;
		tipo = i;
		if(tipo == -1) { 
			desplazamientoI = -60;
			movimiento = new HorizontalAvionLateralIzquierdo(this, Horizontal.DERECHA);
		}else { 
			desplazamientoI = 75;
			movimiento = new HorizontalAvionLateralDerecha(this, Horizontal.DERECHA);
		}
		entidad_graf.setBounds(jugadorPadre.getGrafico().getX()+desplazamientoI, jugadorPadre.getGrafico().getY(), entidad_graf.getWidth(), entidad_graf.getHeight());
		estado_arma = new ConArmaNormalLateral(this);
		estado_avion = new EstadoInicial(this);
		visitor = new VisitorAvionLateral(this);
		vidas = 20;
		tiros = 0;
		puntos = 0;
	}
	
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public int getVidas() {
		return vidas;
	}

	public void restarVida() {
		vidas--;
		restandoVida = false;
	}

	public void incrementarVida() {
		vidas++;
	}

	public boolean getRestandoVidas() {
		return restandoVida;
	}

	public void decrementarVidas() {
		if(jugadorPadre.getRestandoVidas() == false) { 
			restandoVida = true; 
			estado_avion.decrementarVidaJugador();

			if (vidas <= 0) {
				jugadorPadre.destruirNave(tipo);
				juego.eliminarEntidad(this);
			}
		} 
 
	}

	public void accionar() {
		if(jugadorPadre.getCreando() == false) {
			if (juego.moviendoDerecha()) {
				if(tipo == -1)  
					movimiento = new HorizontalAvionLateralIzquierdo(this, Horizontal.DERECHA);
				else movimiento = new HorizontalAvionLateralDerecha(this, Horizontal.DERECHA);
				this.movimiento.mover();
			}

			if (juego.moviendoIzquierda()) {
				if(tipo == -1) 
					movimiento = new HorizontalAvionLateralIzquierdo(this, Horizontal.IZQUIERDA);
				else movimiento = new HorizontalAvionLateralDerecha(this, Horizontal.IZQUIERDA);
				this.movimiento.mover();
			}

			if (juego.moviendoArriba()) {
				setMovimiento(new Vertical(this, Vertical.ARRIBA));
				this.movimiento.mover();
			}

			if (juego.moviendoAbajo()) {
				setMovimiento(new Vertical(this, Vertical.ABAJO));
				this.movimiento.mover();
			}

			if (juego.disparando()) {
				tiros++;
				if (tiros == 8) {
					this.estado_arma.disparar();
					tiros = 0;
					juego.seDisparo();
				}
			}

			if(juego.getDiveo()) {
				setEstadoJugador(new EstadoInmune(this));
				
				setEstadoArma(new SinArma(this));
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					public void run() {
						setEstadoJugador(new EstadoInicial(AvionLateral.this));
						setEstadoArma(new ConArmaNormalLateral(AvionLateral.this));
						timer.cancel();
					}

				}, 5 * 1000); 

			}
		}
	}

	public void CrearNavesLaterales() {

	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public Proyectil disparar() {
		return estado_arma.disparar();
	}

	public void setEstadoJugador(EstadoJugador estado_jugador) {
		this.estado_jugador = estado_jugador;
	}

	public void setEstadoArma(EstadoArma estado_arma) {
		this.estado_arma = estado_arma;
	}

	public EstadoArma getEstadoArma() {
		return estado_arma;
	}

	public EstadoJugador getEstadoJugador() {
		return estado_jugador;
	}

	@Override
	public int getVelocidad() {
		return estado_jugador.getVelocidad();
	}

	public void setPuntos(int p) {
		jugadorPadre.setPuntos(p);
	}

	public int getPuntos() {
		return puntos;
	}

	public int getTipo() {
		return tipo;
	}
}