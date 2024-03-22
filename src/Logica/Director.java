package Logica;

/**
 * clase que se encarga de dirigir al builderNivel, se encarga de ordenarle
 * cuantos aviones de cada tipo se debera construir para cada tanda de cada
 * nivel y cuantas tandas tiene un nivel
 *
 */
public class Director {

	private int enemigosPorNivel[][];
	// almacena cuantos enemigos de cada tipo se deberan construir para cada tanda
	// del juego. Cada fila i de la matriz representa una tanda cada columna j
	// representa un tipo de avion. entoces el numero en (i,j) representa la
	// cantidad de enemigos de tipo j en la tanda i

	private int nivelActual;
	private int ultimoNivel;
	private BuilderNivel builder;
	private final int tandasPorNivel = 2;

	public Director() {
		nivelActual = 0;
		LectorArchivo l = new LectorArchivo();
		enemigosPorNivel = l.obtenerMatrizEnemigo();
		builder = new BuilderDefault();
		ultimoNivel = (enemigosPorNivel.length / tandasPorNivel);
	}

	public Nivel construirSiguienteNivel() {
		int cantEnemigos;
		for (int n = 0; n < tandasPorNivel; n++) {// recorre cada tanda del nivel a construir
			for (int j = 0; j < enemigosPorNivel[0].length; j++) {
				// recorre cada columna de la matriz, cada iteracion correspondera a un tipo de
				// avion distinto
				cantEnemigos = enemigosPorNivel[nivelActual * tandasPorNivel + n][j];
				for (int i = 0; i < cantEnemigos; i++) {
					builder.construirEnemigo(j);
				}
			}
			builder.siguienteTanda();
		}
		Nivel retorno = builder.getNivel();
		retorno.setValor(nivelActual++);
		return retorno;
	}

	public boolean finJuego() {
		return nivelActual == ultimoNivel;
	}
}