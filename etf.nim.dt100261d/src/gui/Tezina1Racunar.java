package gui;


import java.awt.*;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import nimgame.Resenje_AlfaBeta;
import nimgame.Resenje_Takmicar;
import nimgame.SimpleMinimaxPlayer;
import nimgame.TwoComputers;
import nimgame.TwoPlayers;
import pomocno.DrugiIgrac;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class Tezina1Racunar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;

	public static int tezina;
	public static int tipRacunara;
	
	public static int takmicar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tezina1Racunar window = new Tezina1Racunar();
					window.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tezina1Racunar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel welcomeLabel = new JLabel("Nim game!");
		welcomeLabel.setFont(new Font("Tibetan Machine Uni", Font.BOLD, 22));
		welcomeLabel.setBounds(22, 12, 340, 35);
		contentPane.add(welcomeLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 450, 12);
		contentPane.add(separator);

		lblNewLabel_1 = new JLabel("Tezina igre:");
		lblNewLabel_1.setFont(new Font("Phetsarath OT", Font.BOLD, 16));
		lblNewLabel_1.setBounds(22, 78, 150, 37);
		contentPane.add(lblNewLabel_1);

		JButton btnPotvrdi = new JButton("");
		btnPotvrdi.setBackground(new Color(210, 203, 225));
		btnPotvrdi.setBorder(null);
		btnPotvrdi.setBounds(203, 249, 32, 32);
		Image ok = null;
		try {
			ok = ImageIO.read(getClass().getResource("/ok.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnPotvrdi.setIcon(new ImageIcon(ok));

		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				System.out.println("Odabrani tezina igre=" + textField.getText());
				String s = textField.getText();
				tezina = Integer.parseInt(s);

				Integer pom = IzborIgre.tipIgre;
				if (pom.equals(2)) {
					if(tipRacunara==1){
					SimpleMinimaxPlayer game2 = new SimpleMinimaxPlayer();
					game2.setVisible(true);
					}else if(tipRacunara == 2){
						Resenje_AlfaBeta game3 = new Resenje_AlfaBeta();
						game3.setVisible(true);
					}else if(tipRacunara ==3){
						
						Resenje_Takmicar game4 = new Resenje_Takmicar();
						game4.setVisible(true);
						
					}
				} else if (pom.equals(3)) {
					TwoComputers game3 = new TwoComputers();

				}

			}
		});
		contentPane.add(btnPotvrdi);

		JButton btnPotvrdi1 = new JButton("");
		btnPotvrdi1.setBackground(new Color(158, 225, 225));
		btnPotvrdi1.setBorder(null);
		btnPotvrdi1.setBounds(343, 15, 32, 32);
		Image back = null;
		try {
			back = ImageIO.read(getClass().getResource("/back2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnPotvrdi1.setIcon(new ImageIcon(back));
		btnPotvrdi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IzborIgre nimGame = new IzborIgre();
				nimGame.setVisible(true);
			}
		});
		contentPane.add(btnPotvrdi1);

		JButton btnPotvrdi2 = new JButton("");
		btnPotvrdi2.setBackground(new Color(158, 208, 220));
		btnPotvrdi2.setBorder(null);
		btnPotvrdi2.setBounds(391, 15, 32, 32);
		Image back1 = null;
		try {
			back1 = ImageIO.read(getClass().getResource("/home2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnPotvrdi2.setIcon(new ImageIcon(back1));
		btnPotvrdi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame nimGame = new MainFrame();
				nimGame.frame.setVisible(true);
			}
		});
		contentPane.add(btnPotvrdi2);
	
		
		/* postavljanje JRadioButona za odabir tipa racunara*/
		JTextField t = new JTextField(15);

		ButtonGroup g = new ButtonGroup();

		JLabel lblIzaberiteTipRacunara = new JLabel("Izaberite tip racunara:");
		lblIzaberiteTipRacunara.setFont(new Font("Phetsarath OT", Font.BOLD, 16));
		lblIzaberiteTipRacunara.setBounds(22, 160, 233, 35);
		contentPane.add(lblIzaberiteTipRacunara);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 190, 185, 12);
		contentPane.add(separator_1);

		JRadioButton rdbtnJednostavan = new JRadioButton("jednostavan igrac", false),
				     rdbtnAlfabetaIgrac = new JRadioButton("alfa-beta igrac", false),
				     rdbtnTakmicarskiIgrac = new JRadioButton("takmicarski igrac", false);

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//t.setText("Radio button " + ((JRadioButton) e.getSource()).getText());
				String pom =  ((JRadioButton) e.getSource()).getText();
				System.out.println(pom);
				
				if(pom.equals("jednostavan igrac")){
					tipRacunara = 1;
				}else if(pom.equals("alfa-beta igrac")){
					tipRacunara = 2;
				}else if(pom.equals("takmicarski igrac")){
					tipRacunara = 3;
				}
				
				
				
			}
		};

		// dodaj im ActionListenere na svaki
		rdbtnJednostavan.addActionListener(al);
		rdbtnAlfabetaIgrac.addActionListener(al);
		rdbtnTakmicarskiIgrac.addActionListener(al);

		// dodaj na ButtonGroup
		g.add(rdbtnJednostavan);
		g.add(rdbtnAlfabetaIgrac);
		g.add(rdbtnTakmicarskiIgrac);

		
		rdbtnJednostavan.setBounds(33, 196, 168, 23);
		contentPane.add(rdbtnJednostavan);

		rdbtnAlfabetaIgrac.setBounds(33, 226, 168, 23);
		contentPane.add(rdbtnAlfabetaIgrac);

		rdbtnTakmicarskiIgrac.setBounds(33, 256, 168, 23);
		contentPane.add(rdbtnTakmicarskiIgrac);
		
		


		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(253, 242, 200, 86);
		Image img = new ImageIcon(this.getClass().getResource("/nim.gif")).getImage();

		textField = new JTextField();
		textField.setBounds(22, 110, 114, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		Image img1 = new ImageIcon(this.getClass().getResource("/4.png")).getImage();

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(0, 153, 204));
		lblNewLabel_2.setBounds(0, -99, 450, 577);
		Image img2 = new ImageIcon(this.getClass().getResource("/a4.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_2);
		Image img3 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();

	}
}
