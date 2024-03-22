package Logica;

import java.awt.Container;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import Entidades.Enemigo;
import Entidades.Entidad;

import Entidades.Jugador;

import EntidadesGraficas.EntidadGrafica;
import EntidadesGraficas.LabelJugador;
import GUI.GUI;

/**
 * clase que modela la logica del juego. se utilizo el patron de diseño
 * singleton para que no se pueda tener dos instancias del juego distintas al
 * mismo tiempo y la instancia actual pueda se accedida desde cualquier parte
 * del programa. 

 */

public class Juego implements Runnable {

	// Atributos booleanos que indican el comportamiento del usuario
	
	private boolean moviendoIzquierda;
	private boolean moviendoDerecha;
	private boolean moviendoArriba;
	private boolean moviendoAbajo;	
	private boolean disparando;
	private boolean diveando;
	private boolean powerUpTemporal;

	// Atributo utilizado para el patron singleton
	
	private static Juego juego;

	// Listas de entidades
	
	private List<Entidad> entidades;
	private List<Entidad> aEliminar;
	private List<Entidad> aAgregar;

	// Otros atributos
	
	private boolean jugando;
	private GUI gui;
	//private Planeta p;
	private Jugador jugador;
	private Director director;
	private Nivel nivelActual;
	
	/**
	 * El constructor es privado para que funcione el patron singleton
	 */
	
	private Juego() {
		juego = this;
		moviendoIzquierda = false;
		moviendoDerecha = false;
 		disparando = false;
		entidades = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
		aAgregar = new LinkedList<Entidad>();
		powerUpTemporal = false;
	}

	/**
	 * metodo estatico para que se pueda obtener la instancia de Juego desde
	 * cualquier parte del programa
	 * 
	 */
	
	public static Juego getJuego() {
		if (juego == null) {
			juego = new Juego();
		}
		return juego;
	}

	// metodos para actualizar el comportamiento del usuario/jugador

	public boolean moviendoIzquierda() {
		return moviendoIzquierda;
	}

	public boolean moviendoDerecha() {
		return moviendoDerecha;
	}
	
	public boolean moviendoArriba(){
		return moviendoArriba;
	}
	
	public boolean moviendoAbajo() {
		return moviendoAbajo;
	}

	public boolean disparando() {
		return disparando;
	}

	public void setMoviendoIzquierda(boolean mov) {
		this.moviendoIzquierda = mov;
	}

	public void setMoviendoDerecha(boolean mov) {
		this.moviendoDerecha = mov;
	}
	
	public void setMoviendoArriba(boolean mov) {
		this.moviendoArriba = mov;
	}

	public void setMoviendoAbajo(boolean mov) {
		this.moviendoAbajo = mov;
	}

	public void setDisparando(boolean mov) {
		this.disparando = mov;
	}
	
	public void setDiveo(boolean b) {
		diveando = b;
	}
	
	public boolean getDiveo() {
		return diveando;
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void agregarEntidad(Entidad nueva) {
		aAgregar.add(nueva);// se agrega en la lista auxiliar por que no se puede modificar la lista de
							// entidades actuales mientras se ejecuta los accionar
	}

	public void eliminarEntidad(Entidad a_eliminar) {
		aEliminar.add(a_eliminar);	// se agrega en la lista auxiliar de entidades para eliminar por que no se puede
									// modificar la lista de entidades actuales mientras se ejecuta los accionar
		EntidadGrafica ent = a_eliminar.getGrafico();
		if (jugando) {
			getMapa().remove(ent);
			getMapa().repaint();
		}
	}

	public void nivelCompleto() {
		if (director.finJuego()) {				// el director se encarga de saber si existe un proximo nivel
			int puntaje = jugador.getPuntos();
			juego = null;						// se setea nulo para que al empezar otra partida se cree otra instancia deJuego
			gui.gano(puntaje);
			jugando = false;					// corta la ejecucion del juego
		} else {
			siguienteNivel();
		}
	}

	private void siguienteNivel() {
		for (Entidad e : entidades) {			// se remueve las entidades del mapa excepto el jugador y el fondo (proyectiles, premios,etc)
			if (e != jugador && e != jugador.getNaveDerecha() && e != jugador.getNaveIzquierda()) {
					
						gui.getMapa().remove(e.getGrafico());
			}
		}
		entidades = new LinkedList<Entidad>();	// reinicio la lista de entidades
		entidades.add(jugador);
		if(jugador.getNaveDerecha() != null)
			entidades.add(jugador.getNaveDerecha());
		if(jugador.getNaveIzquierda() != null)
			entidades.add(jugador.getNaveIzquierda());
		nivelActual = director.construirSiguienteNivel();
		this.gui.cambioNivel(nivelActual.getValor() + 1);
	}

	public void setGUI(GUI gui) {
		this.gui = gui;
	}

	public int getNivel() {
		return this.nivelActual.getValor();
	}

	private void actualizarDatosJuego() {	
		gui.actualizarPuntos(jugador.getPuntos());
		gui.actualizarVida(jugador.getVidas());
		LabelJugador labelJugador=(LabelJugador)jugador.getGrafico();
	}

	private void detectarColisiones() {
		int cantEntidades = entidades.size();
		for (int i = 0; i < cantEntidades; i++) {
			Entidad a = entidades.get(i);
			for (int j = i + 1; j < cantEntidades; j++) {
				Entidad b = entidades.get(j);
				if (colisionan(a, b)) {
					a.accept(b.getVisitor());
					b.accept(a.getVisitor());
				}
			}
		}
	}

	private boolean colisionan(Entidad a, Entidad b) {
		Rectangle A = a.getGrafico().getBounds();
		Rectangle B = b.getGrafico().getBounds();
		return A.intersects(B);
	}

	private void removerEntidadesEliminadas() {
		for (Entidad e : aEliminar) {
			if(e == null)
				System.out.println("es nulo");
			entidades.remove(e);
		}
		aEliminar = new LinkedList<Entidad>();
	}

	private void agregarEntidadesNuevas() {
		for (Entidad e : aAgregar) {
			entidades.add(e);
			if(e == null)
				System.out.println("es nulo");
		}
		aAgregar = new LinkedList<Entidad>();
	}

	public Container getMapa() {	
		if(gui != null)
				return gui.getMapa();
		else return null;
	}

	@Override
	public void run() {
		try {
			gui.musica();
			jugando = true;
			director = new Director();
			this.gui.cambioNivel(1);
			nivelActual = director.construirSiguienteNivel();
			jugador = new Jugador(true);
			while (jugando) {
				for (Entidad e : entidades) {
					e.accionar();		//pone en movimiento a las entidades
				}
				Thread.sleep(10);
				removerEntidadesEliminadas();
				agregarEntidadesNuevas();
				detectarColisiones();
				actualizarDatosJuego();
			}
		} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void eliminarEnemigo(Enemigo avion) {
		nivelActual.eliminarEnemigo(avion);
		eliminarEntidad(avion);
	}

	/**
	 * detiene la ejecucion del juego brevemente, por 3 segundos
	 */
		
	public void pausa() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * metodo para notificar que el jugador perdio
	 */
	
	public void perdio() {
		int puntaje = jugador.getPuntos();
		this.juego = null;
		jugando = false;
		gui.perdio(puntaje);
	}

	public List<Enemigo> getEnemigos() {
		return nivelActual.getTanda().getEnemigos();
	}

	/**
	 * metodo para notificar al juego que se genero un proyectil lanzado por el
	 * jugador
	 */
	
	public void seDisparo() {
		if(diveando == false)
			gui.sonidoDisparar();
	}
	
	/**
	 * metodo para notificar al juego que se murio un enemigo
	 */
	
	public void seMurio() {
		if(gui != null)
			gui.sonidoMuerte();
	}
	
	/**
	 * metodo para notificar al juego que se agarro un premio
	 */
	
	public void premioAgarrado() {
		if(gui != null)
			gui.sonidoPremio();
	}

	public boolean jugando() {
		return jugando;
	}

	public boolean getEstadoPremio() {
		return powerUpTemporal;
	}
	
	/**
	 * metodo para sumarle los puntos al jugador
	 */
	
	public void sumarPuntos(int p) {
		jugador.setPuntos(p);
	}
}