package Entidades;

import java.util.Timer;
import java.util.TimerTask;
import EntidadesGraficas.LabelJugador;
import EstadosArma.ConArmaNormal;
import EstadosArma.EstadoArma;
import EstadosArma.SinArma;
import EstadosJugador.EstadoInicial;
import EstadosJugador.EstadoInmune;
import EstadosJugador.EstadoJugador;
import EstrategiasMovimiento.Horizontal;
import EstrategiasMovimiento.HorizontalJugadorLimiteDerecha;
import EstrategiasMovimiento.HorizontalJugadorLimiteIzquierda;
import EstrategiasMovimiento.Vertical;
import Visitors.Visitor;

/*
 * Clase que modela al jugador. 
 * Tiene un arma, un estado propio, vida, puntos y una cierta cantidad de tiros.
 * Puede tener aviones laterales.
 * 
 */

public class Jugador extends Entidad {
	protected EstadoArma estado_arma;
	protected EstadoJugador estado_jugador;
	protected int vidas, tiros, puntos;
	protected AvionLateral avionDerecho, avionIzquierdo;
	private boolean creando, restandoVida;

	public Jugador(boolean inicializar) {
		super(null);
		if (inicializar) {
			entidad_graf = new LabelJugador();
		}
		avionDerecho = null;
		avionIzquierdo = null;
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_arma = new ConArmaNormal(this);
		estado_jugador = new EstadoInicial(this);
		vidas = 20;
		tiros = 0;
		puntos = 0;
		creando = false;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public int getVidas() {
		return vidas;
	}

	public boolean getRestandoVidas() {
		return restandoVida;
	}

	public void restarVida() {
		if(avionDerecho != null)
			avionDerecho.restarVida();
		else if(avionIzquierdo != null)
			avionIzquierdo.restarVida();
		else
			vidas--;
		restandoVida = false;
	}

	public void incrementarVida() {
		vidas++;
	}

	public void decrementarVidas() {
		if(avionDerecho != null) {
			if(avionDerecho.getRestandoVidas() == false) {
				restandoVida = true;
				estado_jugador.decrementarVidaJugador();
			}
		}else{

			if(avionIzquierdo != null) {
				if(avionIzquierdo.getRestandoVidas() == false) {
					restandoVida = true;
					estado_jugador.decrementarVidaJugador();
				}
			}else{ 
				estado_jugador.decrementarVidaJugador();

				if (vidas <= 0) {
					juego.eliminarEntidad(this);
					juego.perdio();
				}
			}
		}
	}

	public void accionar() {
		if(!creando) {
			if (juego.moviendoDerecha()) {
				if(avionDerecho == null)
					setMovimiento(new Horizontal(this, Horizontal.DERECHA));
				else setMovimiento(new HorizontalJugadorLimiteDerecha(this, Horizontal.DERECHA));
				this.movimiento.mover();
			}

			if (juego.moviendoIzquierda()) {
				if(avionIzquierdo == null)
					setMovimiento(new Horizontal(this, Horizontal.IZQUIERDA));
				else setMovimiento(new HorizontalJugadorLimiteIzquierda(this, Horizontal.IZQUIERDA));
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
				((LabelJugador) entidad_graf).setDiveo(true);
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					public void run() {
						setEstadoJugador(new EstadoInicial(Jugador.this));
						setEstadoArma(new ConArmaNormal(Jugador.this));
						((LabelJugador) entidad_graf).setDiveo(false);
						timer.cancel();
					}

				}, 3 * 1000);

			}
		}
	}

	public void CrearNavesLaterales() {
		if(avionDerecho == null && avionIzquierdo == null) {
			creando = true;
			avionDerecho = new AvionLateral(this,1);
			avionIzquierdo = new AvionLateral(this,-1);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					creando = false;
					timer.cancel();
				}

			}, 1 * 1000);
		}

		if(avionDerecho == null) { 
			creando = true;
			avionDerecho = new AvionLateral(this,1);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					creando = false;
					timer.cancel();
				}

			}, 0,5* 1000);
		}

		if(avionIzquierdo == null) {
			creando = true;
			avionIzquierdo = new AvionLateral(this,-1);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					creando = false;
					timer.cancel();
				}

			}, 0,5 * 1000);
		}
	}

	public boolean getCreando() {
		return creando;
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
		puntos+=p;
	}

	public int getPuntos() {
		return puntos;
	}

	public Entidad getNaveDerecha() {
		return avionDerecho;
	}

	public Entidad getNaveIzquierda() {
		return avionIzquierdo;
	}

	public void destruirNave(int tipo) {
		if(tipo == 1)
			avionDerecho = null;
		else avionIzquierdo = null;

	}
}