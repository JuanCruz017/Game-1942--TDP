package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelEnemigo1;

import EstrategiasMovimiento.EliminarTotal;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import EstrategiasMovimiento.VerticalRemoveEnemigo;
import Logica.GeneradorDePremio;
import Visitors.Visitor;

public class Enemigo1 extends Enemigo{

	public Enemigo1(Point p, int duracion, boolean enEspera) {
		super(new LabelEnemigo1(p), duracion, enEspera);
		vida = 40;
		velocidad = 2 ;
	}

	
	public void desaparecer() {
		LabelEnemigo1 li = (LabelEnemigo1) this.getGrafico();
		li.seMato();
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
				movimiento = new EliminarTotal(Enemigo1.this,1);
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
					movimiento = new VerticalRemoveEnemigo(Enemigo1.this, Vertical.ARRIBA);
				timer.cancel();
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}
	
	public void disminuirVida(int danio) {
		vida = vida-danio;
		if(vida < 0)
			desaparecer();
		
	}

	public Proyectil disparar() {
		return new BalaBasica(new Point(entidad_graf.getX()+60, entidad_graf.getY() - entidad_graf.getHeight()/2), Vertical.ARRIBA);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
