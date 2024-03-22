package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Ranking;

public class VentanaRanking extends JFrame{
	private FondoPanel panelJuego;
	private JLabel[] estados;
	private JLabel fondoJuego;
	private Disposable padre;


	public VentanaRanking(Disposable parent) {
		padre = parent;
		this.setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/icon.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 700);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		setAlwaysOnTop(true);
		panelJuego = new FondoPanel();
		panelJuego.setBounds(0, 60, 933, 601);
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setLayout(null);
		contentPane.add(panelJuego);

		fondoJuego = new JLabel("New label");
		fondoJuego.setIcon(new ImageIcon(GUI.class.getResource("/RecursosGraficos_Extras/fondo2.png")));
		fondoJuego.setBounds(1, 0, 933,601);
		reDimensionar(fondoJuego, (ImageIcon) fondoJuego.getIcon());
		panelJuego.add(fondoJuego);
		panelJuego.moveToBack(fondoJuego);


		JPanel labelsPanel = new JPanel();
		labelsPanel.setLayout(new GridBagLayout());
		labelsPanel.setOpaque(false); 

		/*
		 * headers de la tabla
		 * 	
		 */
		
		JLabel headerPosicion = new JLabel("Posición");
		JLabel headerJugador = new JLabel("Jugador");
		JLabel headerPuntaje = new JLabel("Puntaje");

		Font headerFont = new Font(headerPosicion.getFont().getName(), Font.BOLD, 20);
		headerPosicion.setFont(headerFont);
		headerJugador.setFont(headerFont);
		headerPuntaje.setFont(headerFont);

		headerPosicion.setForeground(Color.WHITE);
		headerJugador.setForeground(Color.WHITE);
		headerPuntaje.setForeground(Color.WHITE);

		GridBagConstraints gbcHeaders = new GridBagConstraints();
		gbcHeaders.gridx = 0;
		gbcHeaders.gridy = 0;
		gbcHeaders.anchor = GridBagConstraints.CENTER;
		gbcHeaders.insets = new Insets(10, 20, 10, 20); 

		labelsPanel.add(headerPosicion, gbcHeaders);

		gbcHeaders.gridx = 1;
		labelsPanel.add(headerJugador, gbcHeaders);

		gbcHeaders.gridx = 2;
		labelsPanel.add(headerPuntaje, gbcHeaders);

		Ranking rangos_actuales = new Ranking();

		for (int i = 0; i < 5; i++) {
		    int j = i + 1;

		    JLabel pos = new JLabel(Integer.toString(j));
		    pos.setFont(new Font(pos.getFont().getName(), Font.PLAIN, 20));
		    pos.setForeground(Color.WHITE);
		    pos.setHorizontalAlignment(JLabel.CENTER);
		    pos.setVerticalAlignment(JLabel.CENTER);

		    // Crea JLabel para los jugadores del ranking
		    
		    String nombreJugador = " " + rangos_actuales.nombreJugador(i);
		    JLabel label = new JLabel(nombreJugador);
		    label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
		    label.setForeground(Color.WHITE);
		    label.setHorizontalAlignment(JLabel.CENTER);
		    label.setVerticalAlignment(JLabel.CENTER);

		    String puntajeJugador = " " + rangos_actuales.puntajeJugador(i);
		    JLabel puntaje = new JLabel(puntajeJugador);
		    puntaje.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
		    puntaje.setForeground(Color.WHITE);
		    puntaje.setHorizontalAlignment(JLabel.CENTER);
		    puntaje.setVerticalAlignment(JLabel.CENTER);

		    // Agrego los labels
		    
		    GridBagConstraints gbc = new GridBagConstraints();
		    gbc.gridx = 0;
		    gbc.gridy = i + 1; 
		    gbc.anchor = GridBagConstraints.CENTER;
		    gbc.insets = new Insets(10, 20, 10, 20);
		    
		    pos.setBackground(Color.BLACK);
		    label.setBackground(Color.BLACK);
		    puntaje.setBackground(Color.BLACK);
		    
		    labelsPanel.add(pos, gbc);

		    gbc.gridx = 1;
		    labelsPanel.add(label, gbc);

		    gbc.gridx = 2;
		    labelsPanel.add(puntaje, gbc);
		}

		// Centro los labelsPanel en el panelJuego
		
		int x = (panelJuego.getWidth() - labelsPanel.getPreferredSize().width) / 2;
		int y = (panelJuego.getHeight() - labelsPanel.getPreferredSize().height) / 2;

		labelsPanel.setBounds(x, y, labelsPanel.getPreferredSize().width, labelsPanel.getPreferredSize().height);

		panelJuego.add(labelsPanel);
		panelJuego.moveToFront(labelsPanel);
		panelJuego.repaint();
		
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBounds(0, 0, 933, 60);
		contentPane.add(barraSuperior);
		barraSuperior.setLayout(null);
		barraSuperior.setBackground(Color.BLACK);

		JPanel panelVolver = new JPanel();

		panelVolver.setBounds(700, 0, 120, 70);
		panelVolver.setBackground(Color.BLACK);
		panelVolver.setLayout(new GridLayout(1, 1));
		panelVolver.setVisible(true);
		estados = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			estados[i] = new JLabel();
			estados[i].setSize(70, 70); 
		}

		JButton volver = new JButton();
		volver.setSize(115,60);
		panelVolver.add(volver);
		volver.setEnabled(true);
		volver.setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/back.png")));
		volver.setBackground(Color.BLACK);
		volver.setBorder(new EmptyBorder(0, 0, 0, 0)); 
		reDimensionar(volver, (ImageIcon) volver.getIcon());

		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}        
		});

		barraSuperior.add(panelVolver);
		this.setFocusable(true);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
	}

	public void dispose() {
		padre.frameVentanaClosed();
		super.dispose();
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

	private void reDimensionar(JButton boton, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newimg = image.getScaledInstance(boton.getWidth(), boton.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			boton.setIcon(grafico);
			boton.repaint();
		}
	}
}
