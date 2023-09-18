package nimgame;

import gui.Nim;
/**
 * @author Shokry
 * @version 1.00
 */
import gui.Node;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.IzborIgre;
import gui.RasporedZetona;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class TwoComputers extends JFrame {
	private static final long serialVersionUID = 2L;

	private NimGame game;
	private JPanel contentPane;
	private JLabel[][] lblPiles;
	private JLabel lblPlayersTurn;
	private JLabel label;
	private JLabel lblNimGame;
	public static boolean currentPlayer = true;   
	public static int vrstaIgraca;
	public static int stanje[] = new int[10];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwoComputers frame = new TwoComputers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TwoComputers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPlayersTurn = new JLabel("Player's turn!");
		lblPlayersTurn.setForeground(new Color(0, 150, 0));
		lblPlayersTurn.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPlayersTurn.setBounds(44, 592, 233, 20);
		contentPane.add(lblPlayersTurn);

		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"U Nim igri dva racunara  "
								+ "se medjusobno smenjuju pri uklanjanju zetona sa razlicitih stubova. "
								+ "Racunar mora ukloniti najmanje jedan zeton. "
								+ "Poslednji racunar koji ukloni zeton dobija igru.");
			}
		});
		getContentPane().setBackground(new Color(172, 229, 238));
		setPreferredSize(new Dimension(1050, 700));
		setResizable(true);
		pack();
		setVisible(true);

		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/nim.gif")).getImage();
		label.setIcon(new ImageIcon(img));
		getContentPane().add(label);
		label.setBounds(860, 568, 168, 90);
		contentPane.add(label);
		btnHelp.setBounds(44, 633, 117, 25);
		contentPane.add(btnHelp);

		lblNimGame = new JLabel("Nim game!");
		lblNimGame.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 21));
		lblNimGame.setBounds(26, 8, 168, 47);
		contentPane.add(lblNimGame);
		// addPiles(5);
		game = new NimGame(RasporedZetona.broj, 10);
		addPiles(RasporedZetona.broj);

		System.out.println("Pozdrav svima");
	}

	/**
	 * adds nPiles piles to the frame, each of them with a number of objects.
	 * 
	 * @param nPiles
	 *            the number of piles to add to the frame.
	 */
	private void addPiles(int nPiles) {
		lblPiles = new JLabel[nPiles][nPiles]; // !!$$$$$mislim da je zbog ovoga
												// greska sa onim preko 7
		int verSpace = 20, horSpace = 50; 


		for (int i = 0; i < nPiles; i++) {
			for (int j = 0; j < RasporedZetona.zetoni[i]; j++) {
				lblPiles[i][j] = new JLabel("");
				lblPiles[i][j].setIcon(new ImageIcon("img/1.png"));
				lblPiles[i][j].setBounds(horSpace, 25 + verSpace, 70, 70);
				contentPane.add(lblPiles[i][j]);
				verSpace += 52;

				final int column = i, limit = j;

				for (int p = 0; p < nPiles; p++)
					stanje[p] = RasporedZetona.zetoni[p];

			}
			horSpace += 100;
			verSpace = 20;
		}
		funkcija(nPiles);

	}

	public void funkcija(int nPiles) {
		while (true) {
			if (currentPlayer == true) {
				lblPlayersTurn.setText("Racunar1 na potezu!");

				for (int p = 0; p < nPiles; p++) {
					System.out.println(stanje[p]); // ovde se sada nalazi u nizu
													// stanje koliko ima na
													// svakom od stubova zetona
				}
				if (game.gameOver()) { // treba da proverim da li su na svim
					String winner;
					

					if (game.currentPlayer == The100Game.PLAYER1)
						winner = "Racunar2"; // winner = "Player 1";
					else
						winner = "Racunar1"; // winner = "Player 2";
					JOptionPane.showMessageDialog(null, winner + " je pobedio!");
					

					dispose();
					IzborIgre nimGame = new IzborIgre();
					nimGame.setVisible(true);

					break;
				}
				vrstaIgraca=gui.Tezina2Racunara.tipRacunara;
				Nim computerMove = new gui.Nim(1);
				Node node = new Node();
				node = computerMove.novoStanje(); // ovde u node dobijem korak

				int stub = 0, zetona = 0;
				for (int p = 0; p < nPiles; p++) {
					if (stanje[p] != node.getPiles().get(p)) {
						stub = p;
						zetona = Math.abs((stanje[p]) - (node.getPiles().get(p)));
						System.out.println("Stub: " + (stub + 1) + ", " + "zetona: " + zetona);

					}
				}
				// sad cu da pozovem funkciju koja ce da mi skine computerove
				// zetone za skidanje

				racunarSkidaZetone(stub, zetona);
				System.out.println(node);

				// sad treba da na osnovu tog novog stanja kreiram ovo ovde
				// pocetno stanje za igraca
				// newState=computerMove.getStateAfterComputer();
				lblPlayersTurn.setForeground(new Color(150, 0, 0));
				currentPlayer = false;
			} else if (currentPlayer == false) {
				lblPlayersTurn.setText("Racunar2 na potezu!");

				
				if (game.gameOver()) { // treba da proverim da li su na svim
					// stubovima skinuti svi zetoni
					String winner;
					

					if (game.currentPlayer == The100Game.PLAYER1)
						winner = "Racunar1"; // winner = "Player 1";
					else
						winner = "Racunar2"; // winner = "Player 2";
					JOptionPane.showMessageDialog(null, winner + " je pobedio!");
					

					dispose();
					IzborIgre nimGame = new IzborIgre();
					nimGame.setVisible(true);

					break;
				}
				
				
				vrstaIgraca=gui.Tezina2Racunara.tipRacunara2;
				Nim computerMove = new gui.Nim(1);
				Node node = new Node();
				node = computerMove.novoStanje(); // ovde u node dobijem korak
													// koji je odigrao jedan od
													// racunara, on ce da mi
													// promeni stanje i stavice
													// ovde vrednost

				// sad cu da izracunam sa kog tacno stuba je kompjuter skinuo
				// koliko zetona
				int stub = 0, zetona = 0;
				for (int p = 0; p < nPiles; p++) {
					if (stanje[p] != node.getPiles().get(p)) {
						stub = p;
						zetona = Math.abs((stanje[p]) - (node.getPiles().get(p)));
						System.out.println("Stub: " + (stub + 1) + ", " + "zetona: " + zetona);

					}
				}

				racunarSkidaZetone(stub, zetona);
				System.out.println(node);

				lblPlayersTurn.setForeground(new Color(150, 0, 0));

				currentPlayer = true;
			}
		}
	}

	public void racunarSkidaZetone(int column, int limit) {
		int p = 0;
		for (int k = 0; p < limit; ++k) {

			if (lblPiles[column][k].isVisible()) {
				p++;
				game.makeAMove(column, 1); // ovim cu da skinem sa stubova
											// zetone za prvog igraca

				lblPiles[column][k].setVisible(false);
				game.currentPlayer = The100Game.PLAYER1;
				lblPlayersTurn.setText("Player's turn!");
				lblPlayersTurn.setForeground(new Color(0, 150, 0));
			}
		}
		stanje[column] -= limit;
	}

	/**
	 * resets the frame to the intial state of the game.
	 * 
	 * @param nPiles
	 */
	private void resetFrame(int nPiles) { 
											
		for (int i = 0; i < nPiles; i++) {
			for (int j = 0; j <= i; j++) {
				lblPiles[i][j].setVisible(true);
			}
		}
	}

}
