package Logica;

import java.util.LinkedList;
import java.util.List;

public abstract class BuilderNivel {

	
	protected List<Factory> misFabricas; //almacena una fabrica por cada tipo de enemigo
	protected Nivel nivel;

	public BuilderNivel() {
		nivel = new Nivel(0);
		misFabricas = new LinkedList<Factory>();
	}

	public abstract void reset();

	public abstract void construirEnemigo(int tipoEnemigo);

	public abstract Nivel getNivel();

	public abstract void siguienteTanda();
}