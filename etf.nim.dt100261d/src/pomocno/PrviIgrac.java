//package pomocno;
///**
// * @author Shokry
// * @version 1.00
// */
//
//import java.awt.*;
//
//import javax.swing.JFrame;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.awt.image.ImageObserver;
//import java.io.File;
//import java.io.IOException;
//import java.awt.event.ActionEvent;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//
//import nimgame.TwoPlayers;
//import pomocno.DrugiIgrac;
//
//import javax.swing.JPanel;
//import javax.swing.JSeparator;
//import javax.swing.UIManager;
//
//public class PrviIgrac extends JFrame{
//
//	private JPanel contentPane;
//	//private JFrame frame;
//	private JTextField textField;
//	private  JLabel lblNewLabel_1 = new JLabel("Prvi igrac:");
//	
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PrviIgrac window = new PrviIgrac();
//					window.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public PrviIgrac() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 220);
//		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		
//		JButton btnPotvrdi = new JButton("");
//		btnPotvrdi.setBackground(new Color(210, 208,255));
//		btnPotvrdi.setBorder(null);
//		btnPotvrdi.setBounds(190, 102, 32, 32);
//		Image ok = null;
//		try {
//			ok = ImageIO.read(getClass().getResource("/ok.png"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		btnPotvrdi.setIcon(new ImageIcon(ok));
//		
//		
//		btnPotvrdi.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				DrugiIgrac nimGame = new DrugiIgrac();
//				nimGame.setVisible(true);
//			}
//		});
//		contentPane.add(btnPotvrdi);
//		
//		JButton btnPotvrdi1 = new JButton("");
//		btnPotvrdi1.setBackground(new Color(158, 208, 220));
//		btnPotvrdi1.setBorder(null);
//		btnPotvrdi1.setBounds(343, 15, 32, 32);
//		Image back = null;
//		try {
//			back = ImageIO.read(getClass().getResource("/back2.png"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		btnPotvrdi1.setIcon(new ImageIcon(back));
//		btnPotvrdi1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				IzborIgre nimGame = new IzborIgre();
//				nimGame.setVisible(true);
//			}
//		});
//		contentPane.add(btnPotvrdi1);
//		
//		
//		JButton btnPotvrdi2 = new JButton("");
//		btnPotvrdi2.setBackground(new Color(158, 208, 220));
//		btnPotvrdi2.setBorder(null);
//		btnPotvrdi2.setBounds(391, 15, 32, 32);
//		Image back1 = null;
//		try {
//			back1 = ImageIO.read(getClass().getResource("/home2.png"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		btnPotvrdi2.setIcon(new ImageIcon(back1));
//		btnPotvrdi2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				MainFrame nimGame = new MainFrame();
//				nimGame.frame.setVisible(true);
//			}
//		});
//		contentPane.add(btnPotvrdi2);
//	
//		
//		
//		
//		JLabel welcomeLabel = new JLabel("Nim game!");
//		welcomeLabel.setFont(new Font("Tibetan Machine Uni", Font.BOLD, 20));
//		welcomeLabel.setBounds(22, 12, 340, 35);
//		contentPane.add(welcomeLabel);
//		
//		
//		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setBounds(280, 102, 200, 86);
//		Image img=new ImageIcon(this.getClass().getResource("/nim.gif")).getImage();
//		lblNewLabel_1.setFont(new Font("Phetsarath OT", Font.BOLD, 14));
//		lblNewLabel_1.setBounds(22, 68, 150, 37);
//		contentPane.add(lblNewLabel_1);
//		
//		textField = new JTextField();
//		textField.setBounds(22, 102, 150, 30);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		lblNewLabel.setIcon(new ImageIcon(img));
//		contentPane.add(lblNewLabel);
//		Image img1=new ImageIcon(this.getClass().getResource("/4.png")).getImage();
//		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setForeground(new Color(0, 153, 204));
//		lblNewLabel_2.setBounds(0, -16, 450, 304);
//		Image img2=new ImageIcon(this.getClass().getResource("/a4.jpg")).getImage();
//		lblNewLabel_2.setIcon(new ImageIcon(img2));
//		contentPane.add(lblNewLabel_2);
//		Image img3=new ImageIcon(this.getClass().getResource("/back.png")).getImage();
//		
//	
//		
//		
//	    
//	
//	}
//}
