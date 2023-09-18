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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;



public class Resenje_AlfaBeta extends JFrame {
	private static final long serialVersionUID = 2L;
	
	private NimGame game;
	private JPanel contentPane;
	private JLabel[][] lblPiles;
	private JLabel lblPlayersTurn;
	private JLabel label;
	private JLabel lblNimGame;
	private int tipRacunara;
	
	public static int stanje[] = new int[10];
	public static int playerAlfaBeta = 0;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resenje_AlfaBeta frame = new Resenje_AlfaBeta();
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
	public Resenje_AlfaBeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPlayersTurn = new JLabel("Player's turn!");
		lblPlayersTurn.setForeground(new Color(150, 0, 0));
		lblPlayersTurn.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPlayersTurn.setBounds(44, 592, 184, 20);   
		contentPane.add(lblPlayersTurn);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"U Nim igri igrac i racunar  "
								+ "se medjusobno smenjuju pri uklanjanju zetona sa razlicitih stubova. "
								+ "Svako od igraca mora ukloniti najmanje jedan zeton. "
								+ "Poslednji koji ukloni zeton dobija igru.");
			}
		});
		   getContentPane().setBackground(new Color(172, 229, 238));
		   setPreferredSize(new Dimension(1050,700));  
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
		
	
		
		
		for (int i = 0; i < nPiles; i++) {
			for (int j = 0; j < RasporedZetona.zetoni[i]; j++) {   
				lblPiles[i][j] = new JLabel("");
				lblPiles[i][j].setIcon(new ImageIcon("img/1.png"));
				lblPiles[i][j].setBounds(horSpace, 25 + verSpace, 70, 70);
				contentPane.add(lblPiles[i][j]);
				verSpace += 52;
				
				final int column = i, limit = j;
				
				
				for (int p = 0; p < nPiles; p++) {
					stanje[p]=RasporedZetona.zetoni[p];  
				}
				
				lblPiles[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						if (game.currentPlayer == The100Game.PLAYER1){  //ako igra prvi igrac, onda skini tacno onoliko koliko sam ja kliknula da se skine
						  for (int k = 0; k <= limit; ++k) {  
							  
							  for (int p = 0; p < nPiles; p++) {
								  System.out.println(stanje[p]);  
								}
							  
							  
							  
							  
							if (lblPiles[column][k].isVisible()) {  
								
								
								stanje[column]-=1; 
								
								
								
								System.out.println("Limit je "+limit);
								game.makeAMove(column, 1);     
								if (game.gameOver()) {  
									String winner;
									
									lblPiles[column][k].setVisible(false);
									//game.currentPlayer = The100Game.PLAYER1;
									lblPlayersTurn.setText("Computer's turn!");
									lblPlayersTurn.setForeground(new Color(0, 150, 0));
									
									if (game.currentPlayer == The100Game.PLAYER1)
										winner = "Computer";    //winner = "Player 1";
									else
										winner = "Player";    //winner = "Player 2";
									JOptionPane.showMessageDialog(null, winner + " wins!");
									
									
									dispose();
									IzborIgre nimGame = new IzborIgre();
									nimGame.setVisible(true);
									
									
									
									return;
								}
								lblPiles[column][k].setVisible(false);
								lblPiles[column][k].dispatchEvent(e);
							}
						}
						}else if(game.currentPlayer == The100Game.PLAYER2){
							
							
							
							  for (int k = 0; k <= limit; ++k) {  
									if (lblPiles[column][k].isVisible()) {    
										game.makeAMove(column, 1);     
										if (game.gameOver()) {  
											String winner;
											if (game.currentPlayer == The100Game.PLAYER1)
												winner = "Player";    //winner = "Player 1";
											else
												winner = "Computer";    //winner = "Player 2";
											JOptionPane.showMessageDialog(null, winner + " wins!");
											
											dispose();
											IzborIgre nimGame = new IzborIgre();
											nimGame.setVisible(true);
											
											
											return;
										}
										lblPiles[column][k].setVisible(false);
										lblPiles[column][k].dispatchEvent(e);
									}
								}
						}
						if (game.currentPlayer == The100Game.PLAYER1) {
							game.currentPlayer = The100Game.PLAYER2;
							lblPlayersTurn.setText("Computer's turn!");
							
							for (int p = 0; p < nPiles; p++) {
								  System.out.println(stanje[p]);  
								}
							
							playerAlfaBeta = 1;
							Nim computerMove= new gui.Nim();
							Node node = new Node();
							node=computerMove.novoStanje();
							playerAlfaBeta = 0;  // ovo cu kasnije dodati kad realizujem  alfaBeta
							
							int stub=0,zetona=0;
							for (int p = 0; p < nPiles; p++) {
								  if(stanje[p]!=node.getPiles().get(p)) {
									  stub=p;
									  zetona=Math.abs((stanje[p])-(node.getPiles().get(p)));
									  System.out.println("Stub: "+(stub+1)+", "+"zetona: "+zetona);
									  
								  }
								}
							
							
							racunarSkidaZetone(stub, zetona);
							System.out.println(node);
							
							lblPlayersTurn.setForeground(new Color(0, 150, 0));
						} else {
							game.currentPlayer = The100Game.PLAYER1;
							lblPlayersTurn.setText("Player's turn!");
							lblPlayersTurn.setForeground(new Color(150, 0, 0));
						}
					}
				});
			}
			horSpace += 100;
			verSpace = 20;
		}
	}
	
	public void racunarSkidaZetone(int column, int limit){
	int p=0;
	for (int k = 0;  p<limit; ++k) {  
		if (lblPiles[column][k].isVisible()) { 
			p++;
			game.makeAMove(column, 1);     //ovim cu da skinem sa stubova zetone za prvog igraca
			if (game.gameOver()) {  // treba da proverim da li su na svim stubovima skinuti svi zetoni
				String winner;
				lblPiles[column][k].setVisible(false);
				game.currentPlayer = The100Game.PLAYER1;
				lblPlayersTurn.setText("Player's turn!");
				lblPlayersTurn.setForeground(new Color(150, 0, 0));
				
				if (game.currentPlayer == The100Game.PLAYER1)
					winner = "Computer";    //winner = "Player 1";
				else
					winner = "Player";    //winner = "Player 2";
				JOptionPane.showMessageDialog(null, winner + " wins!");
				
				dispose();
				IzborIgre nimGame = new IzborIgre();
				nimGame.setVisible(true);
				
				
				return;
			}
			
			lblPiles[column][k].setVisible(false);
			game.currentPlayer = The100Game.PLAYER1;
			lblPlayersTurn.setText("Player's turn!");
			lblPlayersTurn.setForeground(new Color(150, 0, 0));
		}
	}stanje[column]-=limit;
	}
	
	
	
	
	
	
	
	/**
	 * resets the frame to the intial state of the game.
	 * @param nPiles
	 */
	private void resetFrame(int nPiles) {                  //  mislim da mi ova funkcija uopste nece trebati
		for (int i = 0; i < nPiles; i++) {
			for (int j = 0; j <= i; j++) {
				lblPiles[i][j].setVisible(true);
			}
		}
	}

}
