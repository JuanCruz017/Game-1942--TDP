package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Menu extends JFrame implements Disposable{

	private JPanel contentPane;

	public static void main(String[] args) {
		SplashScreen splash = new SplashScreen(2000);
		splash.showSplash();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Menu frame = new Menu();

					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
					e.getMessage();
				}
			}
		});
	}

	public Menu() {

		setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/icon.jpg")).getImage());

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton botonNormal = 
				new JButton("");
		botonNormal.setBorder(new LineBorder(Color.BLACK));
		botonNormal.setBackground(Color.BLUE);
		botonNormal.setBorder(new EmptyBorder(0, 0, 0, 0)); 
		botonNormal.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/start.gif")));
		botonNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GUI frame = new GUI();
				frame.setVisible(true);
				dispose();
			}
		});
		botonNormal.setBounds(491, 546, 417, 53);
		contentPane.add(botonNormal);
		
		JButton botonRanking = new JButton("");
		botonRanking.setBorder(new LineBorder(Color.BLACK));
		botonRanking.setBackground(new Color(0, 0, 0));
		botonRanking.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/ranking.png")));
		botonRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRanking rankingWindow = new VentanaRanking(Menu.this);
			 	rankingWindow.setVisible(true);
			}
		});
		botonRanking.setBounds(817, 11, 91, 65);
		contentPane.add(botonRanking);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/1942.png")));
		lblNewLabel_1.setBounds(339, 51, 249, 72);
		lblNewLabel_1.setEnabled(true);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/fondoR.jpg")));
		lblNewLabel.setBounds(0, 0, 1032, 647);
		lblNewLabel.setOpaque(false);
		contentPane.add(lblNewLabel);

	}
	
	public void frameVentanaClosed() {
		this.getContentPane().requestFocus();
	}
}