package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelEnemigo2;

import EstrategiasMovimiento.EliminarTotal;
import EstrategiasMovimiento.Vertical;
import Logica.GeneradorDePremio;
import Visitors.Visitor;

public class Enemigo2 extends Enemigo{

	public Enemigo2(Point p, int duracion, boolean enEspera) {
		super(new LabelEnemigo2(p), duracion, enEspera);
		velocidad = 2;
	}

	
	public void desaparecer() {
		LabelEnemigo2 e2 = (LabelEnemigo2) this.getGrafico();
		e2.seMato();
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
				movimiento = new EliminarTotal(Enemigo2.this,1);
				timer.cancel();
			}

		}, 1 * 1000);

	}
	
	public void disminuirVida(int danio) {
		vida = vida-danio;
		if(vida < 0)
			super.desaparecer();
	}

	public Proyectil disparar() {
		return new BalaBasica1(new Point(entidad_graf.getX()+15, entidad_graf.getY() + 40), Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
