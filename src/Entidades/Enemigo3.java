package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelEnemigo3;

import EstrategiasMovimiento.EliminarTotal;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import EstrategiasMovimiento.VerticalRemoveEnemigo;
import Logica.GeneradorDePremio;
import Visitors.Visitor;

public class Enemigo3 extends Enemigo{

	public Enemigo3(Point p, int duracion, boolean enEspera) {
		super(new LabelEnemigo3(p), duracion, enEspera);
		velocidad = 3;
	}

	public void disminuirVida(int danio) {
		vida = vida-danio;
		if(!muerto && vida < 0)
			super.desaparecer();
		
	}
	
	public void desaparecer() {
		LabelEnemigo3 e3 = (LabelEnemigo3) this.getGrafico();
		e3.seMato();
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
				movimiento = new EliminarTotal(Enemigo3.this,1);
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
		return new BalaBasica(new Point(entidad_graf.getX()+10, entidad_graf.getY() + 40), Vertical.ARRIBA);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
