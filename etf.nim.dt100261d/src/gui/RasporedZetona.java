package gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import nimgame.TwoPlayers;
import nimgame.TwoComputers;
import nimgame.SimpleMinimaxPlayer;
import gui.Tezina2Racunara;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class RasporedZetona extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1 = new JLabel("Raspored zetona:");
	private ChangeListener listener;
	private JTextField textField;
	private JPanel sliderPanel;
	public static int[] zetoni = new int[10];
	private JSlider niz[] = new JSlider[10];
	public static int broj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RasporedZetona window = new RasporedZetona();
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
	public RasporedZetona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		broj = Integer.parseInt(IzborIgre.kk);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JButton btnPotvrdi = new JButton("");
		btnPotvrdi.setBackground(new Color(178, 176, 227));
		btnPotvrdi.setBorder(null);
		btnPotvrdi.setBounds(22, 500, 32, 32);
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

				for (int i = 0; i < broj; i++) {
					System.out.println("broj je: " + niz[i].getValue());

				}

				boolean duplicates = false;
				System.out.println("Broj stubova je: " + broj);
				int j, m;
				for (j = 0; j < broj; j++) {
					for (m = j + 1; m < broj; m++) {
						if ((niz[m].getValue()) == (niz[j].getValue())) { 
							duplicates = true;
						}
					}
				}

				for (int i = 0; i < broj; i++) {
					int value = niz[i].getValue();
					zetoni[i] = value;

				}

				System.out.println("Postoje iste vrednosti? " + duplicates);

				if (duplicates == true) {
					JOptionPane.showMessageDialog(null, "Greska: isti broj zetona na stubovima!");
					duplicates = false;
					dispose();
					RasporedZetona nimGame = new RasporedZetona();
					nimGame.setVisible(true);
				} else {

					dispose();
					Integer pom = IzborIgre.tipIgre;
					if (pom.equals(1)) {
						TwoPlayers game1 = new TwoPlayers();
						game1.setVisible(true);
					} else if (pom.equals(2)) {

						Tezina1Racunar t = new Tezina1Racunar();
						t.setVisible(true);
					} else if (pom.equals(3)) {

						Tezina2Racunara t = new Tezina2Racunara();
						t.setVisible(true);

					}
				}
			}
		});

		// ************************************************************************

		// common listener for all sliders
		listener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				// update text field when the slider value changes
				JSlider source = (JSlider) event.getSource();
				textField.setText("" + source.getValue());
			}
		};

		int a = 54;
		int k = 4;

		for (int i = 0; i < 10; i++) {
			JSlider slider = new JSlider();
			niz[i] = slider;
			slider.setPaintTicks(true);
			slider.setMinorTickSpacing(1);
			slider.setMajorTickSpacing(4);
			slider.setMaximum(10);
			slider.setMinimum(1);
			slider.setValue(0);
			a += 40;
			slider.setBounds(22, a, 200, 30);
			contentPane.add(slider);
			addSlider(slider, "Stub" + (i + 1), i);

			if (broj - 1 < i)
				slider.setEnabled(false);

		}

		// add the text field that displays the slider value

		textField = new JTextField();
		// add(sliderPanel, BorderLayout.CENTER);
		getContentPane().add(textField, BorderLayout.SOUTH);

		contentPane.add(btnPotvrdi);

		JButton btnPotvrdi1 = new JButton("");
		btnPotvrdi1.setBackground(new Color(163, 220, 224));
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
		btnPotvrdi2.setBackground(new Color(163, 226, 224));
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

		JLabel welcomeLabel = new JLabel("Nim game!");
		welcomeLabel.setFont(new Font("Tibetan Machine Uni", Font.BOLD, 20));
		welcomeLabel.setBounds(22, 12, 340, 35);
		contentPane.add(welcomeLabel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(261, 438, 200, 86);
		Image img = new ImageIcon(this.getClass().getResource("/nim.gif")).getImage();
		lblNewLabel_1.setFont(new Font("Phetsarath OT", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 39, 150, 37);
		contentPane.add(lblNewLabel_1);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		Image img1 = new ImageIcon(this.getClass().getResource("/4.png")).getImage();

		JLabel lblNewLabel_2 = new JLabel("Stub1");
		lblNewLabel_2.setForeground(new Color(0, 153, 204));
		lblNewLabel_2.setBounds(0, -16, 450, 586);
		Image img2 = new ImageIcon(this.getClass().getResource("/a4.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBounds(164, 548, -132, 10);
		contentPane.add(panel);

	}

	public void addSlider(JSlider s, String description, int i) {
		s.addChangeListener(listener);

	}

}
