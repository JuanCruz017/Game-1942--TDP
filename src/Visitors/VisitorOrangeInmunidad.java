package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.AvionLateral;
import Entidades.Entidad;
import Entidades.Jugador;
import EntidadesGraficas.LabelJugador;
import EstadosJugador.EstadoInmune;
import EstadosJugador.EstadoJugador;
import Logica.Juego;
import Premios.PremioTemporal;

/*
 * Visitor del powerUP orangeInmunidad.
 * 
 */

public class VisitorOrangeInmunidad extends VisitorPremioTemporal{

	public VisitorOrangeInmunidad(PremioTemporal entidad) {
		super(entidad);
		this.duracion = entidad.getDuracion();
	}
	
	public void visit(Jugador jug) {
		
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new EstadoInmune(jug));
		entidad.eliminar();
		Juego.getJuego().premioAgarrado();
		LabelJugador j1 = (LabelJugador) jug.getGrafico();
		j1.setInmune(true);
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoJugador(estado_actual);
				j1.setInmune(false);
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion, 1);
	}
}