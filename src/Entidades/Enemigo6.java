package Entidades;

import java.awt.Point;

import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelEnemigo6;

import EstrategiasMovimiento.EliminarTotal;
import EstrategiasMovimiento.EstrategiaEnemigo6;
import EstrategiasMovimiento.Vertical;
import Logica.GeneradorDePremio;
import Visitors.Visitor;

public class Enemigo6 extends Enemigo{

	public Enemigo6(Point p, int duracion, boolean enEspera) {
		super(new LabelEnemigo6(p), duracion, enEspera);
		velocidad = 5;
	}

	public void disminuirVida(int danio) {
		vida = vida-danio;
		if(vida < 0) {
			desaparecer();
		}
	}
	
	public void desaparecer() {
		LabelEnemigo6 e6 = (LabelEnemigo6) this.getGrafico();
		e6.seMato();
		if (suelta_premio) {
			GeneradorDePremio.generar(entidad_graf.getLocation());
		}
		if(muerto == false) {
			juego.sumarPuntos(puntos);
			muerto = true;
		}
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				movimiento = new EliminarTotal(Enemigo6.this,1);
				timer.cancel();
			}

		}, 1 * 1000);

	}
	
	public void aparecer() {
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new EstrategiaEnemigo6(Enemigo6.this, Vertical.ARRIBA);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}

	public Proyectil disparar() {
		return new BalaBasica1(new Point(entidad_graf.getX(), entidad_graf.getY() + 40), Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
