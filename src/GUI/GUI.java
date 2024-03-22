package GUI;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Logica.Juego;
import javax.swing.JLabel;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GUI extends JFrame {

	private FondoPanel panelJuego;
	private Juego juego;
	private Thread hiloJuego;
	private JLabel[] estados;
	private String[] niveles = {"/RecursosGraficosNiveles/fondo.png", "/RecursosGraficosNiveles/fondo1.png", "/RecursosGraficosNiveles/fondo2.png"};
	private JLabel fondoJuego;
	private boolean gameOver;
	Clip musica, musicaGO;
	Clip disparo, muerte, premioAgarrado;

	public GUI() {
		
		gameOver = false;
		
		this.setResizable(false);

		setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/icon.jpg")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 700);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);

		panelJuego = new FondoPanel();
		panelJuego.setBounds(0, 60, 933, 601);
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setLayout(null);
		contentPane.add(panelJuego);

		fondoJuego = new JLabel();
		URL imageUrl = getClass().getResource("/RecursosGraficosNiveles/fondo.png");
		ImageIcon gifIcon = new ImageIcon(imageUrl);
		fondoJuego.setIcon(gifIcon);
		fondoJuego.setBounds(0, 0, 933,601);
		reDimensionar(fondoJuego, (ImageIcon) fondoJuego.getIcon());
		panelJuego.add(fondoJuego);
		panelJuego.moveToBack(fondoJuego);

		panelJuego.repaint();
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBounds(0, 0, 933, 60);
		contentPane.add(barraSuperior);
		barraSuperior.setLayout(null);
		barraSuperior.setBackground(Color.BLACK);

		JPanel panelMejoras = new JPanel();

		panelMejoras.setBounds(615, 0, 258, 60);
		panelMejoras.setBackground(Color.BLACK);
		panelMejoras.setLayout(new GridLayout(1, 4));
		panelMejoras.setVisible(true);
		estados = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			estados[i] = new JLabel();
			estados[i].setSize(70, 70); 
			panelMejoras.add(estados[i]);
			estados[i].setEnabled(true);

		}
		estados[1].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/corazon.png")));
		estados[4].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/star.png")));

		reDimensionar(estados[1], (ImageIcon) estados[1].getIcon());
		reDimensionar(estados[4], (ImageIcon) estados[4].getIcon());

		estados[0].setForeground(Color.WHITE);
		estados[0].setText("");
		estados[2].setForeground(Color.WHITE);
		estados[2].setText("");
		estados[3].setForeground(Color.WHITE);
		estados[3].setText("");

		Font font = estados[2].getFont();
		estados[0].setFont(new Font(font.getName(), Font.PLAIN, 20)); 
		estados[3].setFont(new Font(font.getName(), Font.PLAIN, 20));
		estados[0].setHorizontalAlignment(JLabel.CENTER);
		estados[0].setVerticalAlignment(JLabel.CENTER);
		estados[3].setHorizontalAlignment(JLabel.CENTER);
		estados[3].setVerticalAlignment(JLabel.CENTER);


		barraSuperior.add(panelMejoras);

		this.setFocusable(true);

		setContentPane(contentPane);
		setLocationRelativeTo(null);

		juego = Juego.getJuego();
		juego.setGUI(this);

		this.addKeyListener(new OyenteTeclado(juego));

		hiloJuego = new Thread() {
			public void run() {
				juego.run();
			}
		};
		hiloJuego.start();
		this.repaint();
		panelJuego.repaint();
	}

	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.setIcon(grafico);
			label.repaint();
		}
	}

	/**
	 * Se crea abre un nuevo frame donde se muestra que se gano el juego
	 */
	
	public void gano(int puntaje) {
		GameOver_Win win;
		this.juego = null;
		musica.stop();
		musicaGO(1);
		if(gameOver == false) {
			win = new GameOver_Win(1, puntaje, this);
			gameOver = true;
			win.setVisible(true);
		}
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
	}

	/**
	 * Se crea abre un nuevo frame donde se muestra que se perdio el juego
	 */
	
	public void perdio(int puntaje) {
		GameOver_Win win;
		this.juego = null;
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
		musica.stop();
		musicaGO(0);
		if(gameOver == false) {
			win = new GameOver_Win(0, puntaje, this);
			gameOver = true;
			win.setVisible(true);
		}
	}

	public Container getMapa() {
		if(panelJuego == null)
			System.out.println("Mapa es nulo wtf");
		return panelJuego;
	}

	/**
	 * Muestra en el panel de juego la transicion del nivel. Esta transicion muestra el nivel actual
	 * 
	 */
	
	public void cambioNivel(int nivel) {
		URL imageUrl = getClass().getResource(niveles[nivel-1]);
		ImageIcon gifIcon = new ImageIcon(imageUrl);
		fondoJuego.setIcon(gifIcon);
		panelJuego.moveToBack(fondoJuego);
		panelJuego.pantallaNivel(nivel - 1);
		juego.pausa();
		panelJuego.CambioDeLvl();
		panelJuego.repaint();
	}

	/**
	 * Actualiza los puntos del jugador
	 */
	
	public void actualizarPuntos(int puntos) {
		estados[3].setText(""+puntos+"");
	}

	public void actualizarVida(int vida) {
		estados[0].setText(""+vida+"");
	}
	
	
	/**
	 * Activa la musica de fondo
	 */
	
	public void musica() {
		try {
			musica = AudioSystem.getClip();
			musica.open(AudioSystem.getAudioInputStream(getClass().getResource("/RecursosWAV/AcrossTheStars1.wav")));
			musica.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}

	/**
	 * Activa la musica de victoria o perdida
	 */
	
	public void musicaGO(int p) {
		try {
			musicaGO = AudioSystem.getClip();
			if(p == 0) {
				musicaGO.open(AudioSystem.getAudioInputStream(getClass().getResource("/RecursosWAV/Anakin's Betrayal.wav")));
			}else {
				musicaGO.open(AudioSystem.getAudioInputStream(getClass().getResource("/RecursosWAV/Star Wars Main Title and the Arrival at Naboo.wav")));

			}
			musicaGO.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}
	
	/**
	 * Frena la musica de victoria o perdida.
	 */
	
	public void frenarMusicaGO() {
		if (musicaGO != null && musicaGO.isRunning()) {
			musicaGO.stop();
		}
	}
	
	/**
	 * Activa el sonido de disparo.
	 */
	
	public void sonidoDisparar() {
		try {
			disparo = AudioSystem.getClip();
			disparo.open(AudioSystem.getAudioInputStream(getClass().getResource("/RecursosWAV/disparo.wav")));
			disparo.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}

	/**
	 * Activa el sonido de haber agarrado un premio.
	 */
	
	
	public void sonidoPremio() {
		try {
			premioAgarrado= AudioSystem.getClip();
			premioAgarrado.open(AudioSystem.getAudioInputStream(getClass().getResource("/RecursosWAV/premio.wav")));
			premioAgarrado.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}
	
	/**
	 * Activa el sonido de haber matado un enemigo.
	 */
	
	public void sonidoMuerte() {
		try {
			muerte = AudioSystem.getClip();
			muerte.open(AudioSystem.getAudioInputStream(getClass().getResource("/RecursosWAV/death.wav")));
			muerte.start();
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					muerte.stop();
					timer.cancel();
				}

			}, 1 * 1000);

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}
	
	public void setGameOver(boolean modo) {
		gameOver = modo;
	}
}