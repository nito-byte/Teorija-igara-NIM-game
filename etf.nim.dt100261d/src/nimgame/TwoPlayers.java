package nimgame;


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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;


public class TwoPlayers extends JFrame {
	private static final long serialVersionUID = 2L;
	
	private NimGame game;
	private JPanel contentPane;
	private JLabel[][] lblPiles;
	private JLabel lblPlayersTurn;
	private JLabel label;
	private JLabel lblNimGame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwoPlayers frame = new TwoPlayers();
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
	public TwoPlayers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPlayersTurn = new JLabel("Player 1's turn!");
		lblPlayersTurn.setForeground(new Color(0, 150, 0));
		lblPlayersTurn.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPlayersTurn.setBounds(44, 592, 150, 20);   // ovde podesavam  gde mi ide ovaj tekst
		contentPane.add(lblPlayersTurn);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "U Nim igri dva igraca "
						+ "se medjusobno smenjuju pri uklanjanju zetona sa razlicitih stubova.\n"
						+ "Igrac mora ukloniti najmanje jedan zeton. "
						+ "Poslednji igrac koji ukloni zeton gubi igru.");
			}
		});
		   getContentPane().setBackground(new Color(172, 229, 238));
		   setPreferredSize(new Dimension(1050,700));  //  ovo je dimenzija samog rama
		   setResizable(true);
		   pack();
		   setVisible(true);
		
		label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/nim.gif")).getImage();
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
		//addPiles(5);
		addPiles(RasporedZetona.broj);
		game = new NimGame(RasporedZetona.broj, 10);
	}

	/**
	 * adds nPiles piles to the frame, each of them with a number of objects.
	 * @param nPiles the number of piles to add to the frame.
	 */
	private void addPiles(int nPiles) {
		lblPiles = new JLabel[nPiles][nPiles];
		int verSpace = 20, horSpace = 50;
		
		// ovo je sada deo u kome cu morati da promenim 
		// koliko tacno treba da mi se prikaze 
		
		
		for (int i = 0; i < nPiles; i++) {
			for (int j = 0; j < RasporedZetona.zetoni[i]; j++) {   //greska je bila kad je ovde bilo <=
				lblPiles[i][j] = new JLabel("");
				lblPiles[i][j].setIcon(new ImageIcon("img/1.png"));
				lblPiles[i][j].setBounds(horSpace, 25 + verSpace, 70, 70);
				contentPane.add(lblPiles[i][j]);
				verSpace += 52;//67
				
				final int column = i, limit = j;
				lblPiles[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						for (int k = 0; k <= limit; ++k) {
							if (lblPiles[column][k].isVisible()) {  //ovim se dohvata tacno odredjeni zeton, oni su oznaceni kao matrica   npr [3][1]  
								game.makeAMove(column, 1);
								if (game.gameOver()) {  // treba da proverim da li su na svim stubovima skinuti svi zetoni
									String winner;
									if (game.currentPlayer == The100Game.PLAYER1)
										winner = "Player 2";    //winner = "Player 1";
									else
										winner = "Player 1";    //winner = "Player 2";
									lblPiles[column][k].setVisible(false);
									
									if(winner.equals("Player 2")){
										lblPlayersTurn.setText("Player 1's turn!");
										lblPlayersTurn.setForeground(new Color(0, 150, 0));
									}else{
										lblPlayersTurn.setText("Player 2's turn!");
										lblPlayersTurn.setForeground(new Color(150, 0, 0));
									}
									
									JOptionPane.showMessageDialog(null, winner + " wins!");
									//ovo je greska, sad treba da se samo vratim na prozor izbor igre, nista drugo
									//da bi mi se samo jednom ispisalo ovo player wins
									
									dispose();
									IzborIgre nimGame = new IzborIgre();
									nimGame.setVisible(true);
									
									
									return;
								}
								lblPiles[column][k].setVisible(false);
								lblPiles[column][k].dispatchEvent(e);
							}
						}
						if (game.currentPlayer == The100Game.PLAYER1) {
							game.currentPlayer = The100Game.PLAYER2;
							lblPlayersTurn.setText("Player 2's turn!");
							lblPlayersTurn.setForeground(new Color(150, 0, 0));
						} else {
							game.currentPlayer = The100Game.PLAYER1;
							lblPlayersTurn.setText("Player 1's turn!");
							lblPlayersTurn.setForeground(new Color(0, 150, 0));
						}
					}
				});
			}
			horSpace += 100;
			verSpace = 20;
		}
	}
	
	/**
	 * resets the frame to the intial state of the game.
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
