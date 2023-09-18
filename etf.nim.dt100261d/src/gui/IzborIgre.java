package gui;


import java.awt.*;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
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
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import nimgame.TwoPlayers;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class IzborIgre extends JFrame {

	private JPanel contentPane;
	// private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_1 = new JLabel("Odaberite tip igre:    \n");
	private final JSeparator separator_1 = new JSeparator();
	protected static String kk = "0";

	public static int tipIgre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzborIgre window = new IzborIgre();
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
	public IzborIgre() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(51, 102, 255), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ComboBox - izbor broja stubova
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(22, 93, 58, 24);
		contentPane.add(comboBox);

		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.setEditable(true);
		// System.out.println("#items=" + comboBox.getItemCount());

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kk = comboBox.getSelectedItem().toString();
				System.out.println("Odabrani broj stubova=" + comboBox.getSelectedItem());

			}
		});

		////////////////////////////////////////////////////////////////

		JLabel welcomeLabel = new JLabel("Nim game!");
		welcomeLabel.setFont(new Font("Tibetan Machine Uni", Font.BOLD, 20));
		welcomeLabel.setBounds(22, 12, 340, 35);
		contentPane.add(welcomeLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 134, 438, 79);
		contentPane.add(separator);

		JLabel lblUnesite = new JLabel("Unesite 1, 2 ili 3");
		lblUnesite.setFont(new Font("Waree", Font.BOLD, 14));
		lblUnesite.setBounds(22, 229, 528, 35);
		contentPane.add(lblUnesite);

		JLabel lblIgracProtiv = new JLabel("1) igrac protiv igraca");
		lblIgracProtiv.setFont(new Font("Waree", Font.BOLD, 14));
		lblIgracProtiv.setBounds(32, 165, 528, 35);
		contentPane.add(lblIgracProtiv);

		JLabel lblIgracProtiv_1 = new JLabel("2) igrac protiv racunara");
		lblIgracProtiv_1.setFont(new Font("Waree", Font.BOLD, 14));
		lblIgracProtiv_1.setBounds(32, 185, 528, 35);
		contentPane.add(lblIgracProtiv_1);

		JLabel lblRacunarProtiv = new JLabel("3) racunar protiv racunara\n");
		lblRacunarProtiv.setFont(new Font("Waree", Font.BOLD, 14));
		lblRacunarProtiv.setBounds(32, 205, 528, 35);
		contentPane.add(lblRacunarProtiv);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(256, 230, 264, 96);
		Image img = new ImageIcon(this.getClass().getResource("/nim.gif")).getImage();
		lblNewLabel_1.setFont(new Font("Waree", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 143, 528, 35);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(22, 260, 130, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Odabrani tip igre=" + textField.getText() + " (igrac protiv igraca)");
				String s = textField.getText();
				tipIgre = Integer.parseInt(s);
				if (s.equals("1") || s.equals("2") || s.equals("3")) {
					dispose();
					RasporedZetona nimGame = new RasporedZetona();
					nimGame.setVisible(true);
				} else {
					dispose();
					TwoPlayers nimGame = new TwoPlayers();
					nimGame.setVisible(true);
				}
			}
		});

		JLabel lblOdaberiteBrojStubova = new JLabel("Odaberite broj stubova: ");
		lblOdaberiteBrojStubova.setFont(new Font("Waree", Font.BOLD, 14));
		lblOdaberiteBrojStubova.setBounds(22, 59, 528, 35);
		contentPane.add(lblOdaberiteBrojStubova);
		separator_1.setToolTipText("");
		separator_1.setBackground(new Color(255, 255, 255));
		separator_1.setBounds(0, 52, 438, 70);
		contentPane.add(separator_1);

		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		Image img1 = new ImageIcon(this.getClass().getResource("/4.png")).getImage();

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(0, 153, 204));
		lblNewLabel_2.setBounds(0, -16, 438, 386);
		Image img2 = new ImageIcon(this.getClass().getResource("/a4.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_2);

		JButton btnPotvrdi2 = new JButton("");
		btnPotvrdi2.setBackground(new Color(158, 208, 220));
		btnPotvrdi2.setBorder(null);
		btnPotvrdi2.setBounds(375, 15, 32, 32);
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

	}
}
