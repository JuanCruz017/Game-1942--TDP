package Entidades;

import java.awt.Point;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import EntidadesGraficas.LabelEnemigo5;

import EstrategiasMovimiento.EliminarTotal;
import EstrategiasMovimiento.EstrategiaEnemigo5;
import EstrategiasMovimiento.Vertical;
import Logica.GeneradorDePremio;
import Visitors.Visitor;

public class Enemigo5 extends Enemigo{

	public Enemigo5(Point p, int duracion, boolean enEspera) {
		super(new LabelEnemigo5(p), duracion, enEspera);
	}

	public void disminuirVida(int danio) {
		vida = vida-danio;
		if(vida < 0)
			desaparecer();
		
	}
	
	public void desaparecer() {
		LabelEnemigo5 e5 = (LabelEnemigo5) this.getGrafico();
		e5.seMato();
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
				movimiento = new EliminarTotal(Enemigo5.this,1);
				timer.cancel();
			}

		}, 1 * 1000);

	}
	
	public void aparecer() {
		Random r = new Random();
		int[] doI = new int[2];
		doI[0] = -1;
		doI[1] = 1;
		Enemigo inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new EstrategiaEnemigo5(Enemigo5.this, doI[r.nextInt(2)]);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}

	public Proyectil disparar() {
		return new BalaBasica1(new Point(entidad_graf.getX()+10, entidad_graf.getY() + 40), Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
