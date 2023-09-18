//package nimgame;
//
//import gui.Nim;

//import gui.Node;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.Image;
//
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import gui.IzborIgre;
//import gui.RasporedZetona;
//
//import javax.swing.JLabel;
//import javax.swing.JButton;
//
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.ActionEvent;
//
//import javax.swing.ImageIcon;
//
//
//
//public class Ispravno1 extends JFrame {
//	private static final long serialVersionUID = 2L;
//
//	private NimGame game;
//	private JPanel contentPane;
//	private JLabel[][] lblPiles;
//	private JLabel lblPlayersTurn;
//	private JLabel label;
//	private JLabel lblNimGame;
//	private boolean currentPlayer;
//	private int postavi;
//
//	public static int stanje[] = new int[10];
//	public static int playerAlfaBeta = 0;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ispravno1 frame = new Ispravno1();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Ispravno1() {
//		currentPlayer = true;
//		postavi = 0;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(200, 200, 550, 400);
//		contentPane = new JPanel();
//		contentPane.setForeground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		lblPlayersTurn = new JLabel("Player's turn!");
//		lblPlayersTurn.setForeground(new Color(0, 150, 0));
//		lblPlayersTurn.setFont(new Font("Dialog", Font.BOLD, 17));
//		lblPlayersTurn.setBounds(44, 592, 233, 20);
//		contentPane.add(lblPlayersTurn);
//
//		JButton btnHelp = new JButton("Help");
//		btnHelp.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null,
//						"U Nim igri igrac i racunar  "
//								+ "se medjusobno smenjuju pri uklanjanju zetona sa razlicitih stubova. "
//								+ "Svako od igraca mora ukloniti najmanje jedan zeton. "
//								+ "Poslednji koji ukloni zeton dobija igru.");
//			}
//		});
//		getContentPane().setBackground(new Color(172, 229, 238));
//		setPreferredSize(new Dimension(1050, 700));
//		setResizable(true);
//		pack();
//		setVisible(true);
//
//		label = new JLabel("");
//		Image img = new ImageIcon(this.getClass().getResource("/nim.gif")).getImage();
//		label.setIcon(new ImageIcon(img));
//		getContentPane().add(label);
//		label.setBounds(860, 568, 168, 90);
//		contentPane.add(label);
//		btnHelp.setBounds(44, 633, 117, 25);
//		contentPane.add(btnHelp);
//
//		lblNimGame = new JLabel("Nim game!");
//		lblNimGame.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 21));
//		lblNimGame.setBounds(26, 8, 168, 47);
//		contentPane.add(lblNimGame);
//		// addPiles(5);
//		game = new NimGame(RasporedZetona.broj, 10);
//		addPiles(RasporedZetona.broj);
//
//		System.out.println("Pozdrav svima");
//	}
//
//	/**
//	 * adds nPiles piles to the frame, each of them with a number of objects.
//	 * 
//	 * @param nPiles
//	 *            the number of piles to add to the frame.
//	 */
//	private void addPiles(int nPiles) {
//		lblPiles = new JLabel[nPiles][nPiles];
//
//		int verSpace = 20, horSpace = 50;
//
//		for (int i = 0; i < nPiles; i++) {
//			for (int j = 0; j < RasporedZetona.zetoni[i]; j++) {
//				lblPiles[i][j] = new JLabel("");
//				lblPiles[i][j].setIcon(new ImageIcon("img/1.png"));
//				lblPiles[i][j].setBounds(horSpace, 25 + verSpace, 70, 70);
//				contentPane.add(lblPiles[i][j]);
//				verSpace += 52;
//
//				final int column = i, limit = j, a = RasporedZetona.zetoni[i];
//
//				for (int p = 0; p < nPiles; p++)
//					stanje[p] = RasporedZetona.zetoni[p];
//
//				lblPiles[i][j].addMouseListener(new MouseAdapter() {
//					// int a;
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						if (currentPlayer == true) {
//
//							for (int k = 0; k <= limit; ++k) {
//
//								/// if(k==limit)a=1;
//
//								if (lblPiles[column][k].isVisible()) {
//									stanje[column] -= 1; 
//									postavi = 0;
//									game.igraj(column, 1); 
//									if (game.gameOver()) { 
//										String winner;
//
//										lblPiles[column][k].setVisible(false);
//										lblPlayersTurn.setText("Computer's turn!");
//										lblPlayersTurn.setForeground(new Color(0, 150, 0));
//
//										if (currentPlayer == true)
//											winner = "Computer"; 
//										else
//											winner = "Player"; 
//										JOptionPane.showMessageDialog(null, winner + " wins!");
//										dispose();
//										IzborIgre nimGame = new IzborIgre();
//										nimGame.setVisible(true);
//										return;
//									}
//									lblPiles[column][k].setVisible(false);
//									lblPiles[column][k].dispatchEvent(e);
//
//								}
//
//							}
//							if (postavi == 0)
//								currentPlayer = false;
//						}
//						if ((currentPlayer == false) && (limit == a - 1) && (postavi == 0))
//							funkcija(nPiles);
//
//						// if(a==1)currentPlayer=false;
//					}
//
//				});
//
//			}
//			horSpace += 100;
//			verSpace = 20;
//
//		}
//	}
//
//	public void funkcija(int nPiles) {
//		if ((currentPlayer == false)&& (postavi==0)) {
//			System.out.println("Caos!");
//
//			postavi = 1;
//
//			lblPlayersTurn.setText("Racunar na potezu!");
//
//		}
//
//		if (game.gameOver()) {
//			String winner;
//			if (currentPlayer == false)
//				winner = "Igrac"; // winner = "Player 1";
//			else
//				winner = "Racunar"; // winner = "Player 2";
//			JOptionPane.showMessageDialog(null, winner + " je pobedio!");
//
//			dispose();
//			IzborIgre nimGame = new IzborIgre();
//			nimGame.setVisible(true);
//			return;
//		}
//
//		
//		playerAlfaBeta = 1;
//		Nim computerMove = new gui.Nim();
//		Node node = new Node();
//		node = computerMove.novoStanje(); 
//		playerAlfaBeta = 0; 
//
//		int stub = 0, zetona = 0;
//		for (int p = 0; p < nPiles; p++) {
//			if (stanje[p] != node.getPiles().get(p)) {
//				stub = p;
//				zetona = Math.abs((stanje[p]) - (node.getPiles().get(p)));
//				System.out.println("Stub: " + (stub + 1) + ", " + "zetona: " + zetona);
//
//			}
//		}
//		
//		racunarSkidaZetone(stub, zetona);
//		System.out.println(node);
//		lblPlayersTurn.setForeground(new Color(150, 0, 0));
//
//		currentPlayer = true;
//	}
//
//	public void racunarSkidaZetone(int column, int limit) {
//		int p = 0;
//		for (int k = 0; p < limit; ++k) {
//
//			if (lblPiles[column][k].isVisible()) {
//				p++;
//				game.igraj(column, 1); 
//
//				lblPiles[column][k].setVisible(false);
//				//game.currentPlayer = The100Game.PLAYER1;
//				lblPlayersTurn.setText("Igrac na redu!");
//				lblPlayersTurn.setForeground(new Color(0, 150, 0));
//			}
//		}
//		stanje[column] -= limit;
//	}
//
//	/**
//	 * resets the frame to the intial state of the game.
//	 * 
//	 * @param nPiles
//	 */
//	private void resetFrame(int nPiles) { 
//		for (int i = 0; i < nPiles; i++) {
//			for (int j = 0; j <= i; j++) {
//				lblPiles[i][j].setVisible(true);
//			}
//		}
//	}
//
//}
