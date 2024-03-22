package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;


import EntidadesGraficas.LabelEnemigo4;

import EstrategiasMovimiento.EliminarTotal;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import EstrategiasMovimiento.VerticalRemoveEnemigo;
import Logica.GeneradorDePremio;
import Visitors.Visitor;

public class Enemigo4 extends Enemigo{

	public Enemigo4(Point p, int duracion, boolean enEspera) {
		super(new LabelEnemigo4(p), duracion, enEspera);
		velocidad = 3;
	}

	public void disminuirVida(int danio) {
		vida = vida-danio;
		if(vida < 0)
			super.desaparecer();
	}
	
	public void desaparecer() {
		LabelEnemigo4 e4 = (LabelEnemigo4) this.getGrafico();
		e4.seMato();
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
				movimiento = new EliminarTotal(Enemigo4.this,1);
				timer.cancel();
			}

		}, 1 * 1000);

	}
	
	public void aparecer() {
		Enemigo inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new VerticalRemoveEnemigo(inf, Vertical.ARRIBA);
				timer.cancel();
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}

	public Proyectil disparar() {
		return new BalaBasica(new Point(entidad_graf.getX()+10, entidad_graf.getY() - entidad_graf.getHeight()/2), Vertical.ARRIBA);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
