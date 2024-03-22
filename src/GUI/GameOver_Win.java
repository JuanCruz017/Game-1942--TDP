package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import Logica.Ranking;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GameOver_Win extends JFrame implements Disposable{

	private JPanel contentPane;
	private Ranking ranking;

	public GameOver_Win(int p, int puntaje, GUI gui) {// si es 1 entonces gano, 0 caso contrario 
		
		ranking = new Ranking();
		setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/icon.jpg")).getImage());
		
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();    
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		

		JButton tryAgain = new JButton("");
		tryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.frenarMusicaGO();
				Menu frame = new Menu();
				frame.setVisible(true);
				dispose();
			}
		});
		tryAgain.setBackground(Color.BLACK);
		tryAgain.setBorder(new LineBorder(Color.BLACK));
		tryAgain.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/start.png")));
		tryAgain.setBounds(459, 527, 198, 49);
		reDimensionar(tryAgain, (ImageIcon) tryAgain.getIcon());
		tryAgain.setEnabled(false);
		contentPane.add(tryAgain);
		
		JButton salir = new JButton("");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				gui.setGameOver(false);
				dispose();
			}
		});
		salir.setBackground(Color.BLACK);
		salir.setBorder(new LineBorder(Color.BLACK));
		salir.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/exit.png")));
		salir.setBounds(669, 527, 184, 49);
		salir.setBorder(new EmptyBorder(0, 0, 0, 0)); 
		salir.setEnabled(false);
		contentPane.add(salir);
		
		JButton botonRanking = new JButton("");
		botonRanking.setBorder(new LineBorder(Color.BLACK));
		botonRanking.setBackground(new Color(0, 0, 0));
		botonRanking.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/ranking.png")));
		botonRanking.setEnabled(false);
		botonRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRanking rankingWindow = new VentanaRanking(GameOver_Win.this);
			 	rankingWindow.setVisible(true);
			}
		});
		botonRanking.setBounds(817, 11, 91, 65);
		contentPane.add(botonRanking);
		
		JLabel gameOverL = new JLabel("");
		gameOverL.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/gameOver"+p+".png ")));
		gameOverL.setBounds(213, 77, 499, 70);
		gameOverL.setEnabled(true);
		contentPane.add(gameOverL);
		
		JTextField miBox = new JTextField(20);
		miBox.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 16));
		miBox.setText("Ingrese su nombre");
		miBox.setForeground(Color.BLACK);
		miBox.setEditable(true);
		miBox.setEnabled(true);
		miBox.setVisible(true);
		miBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        String nombre = miBox.getText();
		        tryAgain.setEnabled(true);
		        salir.setEnabled(true);
		        ranking.addPlayer(nombre, puntaje);
		        botonRanking.setEnabled(true);
		    }
		});
		
		JPanel panelBox = new JPanel();
		panelBox.setLayout(new FlowLayout());
		panelBox.setBounds(300, 180, 300, 60); 
		panelBox.add(miBox);
		panelBox.setOpaque(false);
		contentPane.add(panelBox);
		
		
		JLabel gameOver = new JLabel("");
		gameOver.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/fondoR.jpg")));
		gameOver.setOpaque(false);
		gameOver.setBounds(0, 0, 921, 643);
		gameOver.setBorder(new EmptyBorder(0, 0, 0, 0)); 
		contentPane.add(gameOver);
		
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
	
	public void frameVentanaClosed() {
		this.getContentPane().requestFocus();
	}
}