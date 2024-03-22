package Logica;

import Entidades.Enemigo;

/**
 * clase que se encarga de la construccion de un nivel
 */

public class BuilderDefault extends BuilderNivel {

	private Tanda tandaActual;
	private int nivelesCreados;
	private boolean primerTanda;

	public BuilderDefault() {
		super();
		misFabricas.add(new FactoryEne1());
		misFabricas.add(new FactoryEne2());
		misFabricas.add(new FactoryEne3());
		misFabricas.add(new FactoryEne4());
		misFabricas.add(new FactoryEne5());
		misFabricas.add(new FactoryEne6());
		
		nivelesCreados = 0;
		tandaActual = new Tanda();
		primerTanda = true;
	}

	public void reset() {
		nivel = new Nivel(nivelesCreados);
		tandaActual = new Tanda();
		primerTanda = true;
	}

	public void construirEnemigo(int tipoEnemigo) {
		// tipoEnemigo debe coincidir con un indice valido de la lista de fabricas.
		// el tipo i es creado por la fabrica i
		Enemigo ene = misFabricas.get(tipoEnemigo).crearEnemigo(!primerTanda);
		if(ene == null)
			System.out.println("NULO");
		tandaActual.agregarEnemigo(ene);
	}

	public Nivel getNivel() {
		Nivel aRetornar = nivel;
		nivel = new Nivel(nivelesCreados);
		tandaActual = new Tanda();
		primerTanda=true;
		return aRetornar;
	}

	public void siguienteTanda() {
		for (Factory f : misFabricas) {
			f.reiniciar();
		}
		nivel.agregarTanda(tandaActual);
		tandaActual = new Tanda(); 
		primerTanda = false;
	}
}