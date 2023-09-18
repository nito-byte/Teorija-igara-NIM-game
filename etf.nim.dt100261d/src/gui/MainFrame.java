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

public class MainFrame {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel welcomeLabel = new JLabel("Nim game! Dobrodosli!");
		welcomeLabel.setFont(new Font("Tibetan Machine Uni", Font.BOLD, 25));
		welcomeLabel.setBounds(70, 45, 340, 35);
		frame.getContentPane().add(welcomeLabel);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Icon.png"));

		JButton playNim = new JButton("Igraj");
		playNim.setFont(new Font("Waree", Font.BOLD, 12));
		playNim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				IzborIgre nimGame = new IzborIgre();
				nimGame.setVisible(true);
			}
		});
		playNim.setBounds(152, 97, 150, 36);
		frame.getContentPane().add(playNim);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(150, 180, 210, 90);
		Image img = new ImageIcon(this.getClass().getResource("/nim.gif")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(120, 97, 40, 36);
		Image img1 = new ImageIcon(this.getClass().getResource("/4.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, -14, 452, 392);
		Image img2 = new ImageIcon(this.getClass().getResource("/a4.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		frame.getContentPane().add(lblNewLabel_2);

	}
}
