//package nimgame;
//
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
//import javax.swing.JPanel;
//import javax.swing.border.EtchedBorder;
//import javax.swing.border.LineBorder;
//import javax.swing.UIManager;
//
//public class Frame3 extends JFrame{
//
//	private JPanel contentPane;
//	private JTextField textField;
//	private  JLabel lblNewLabel_1 = new JLabel("Odaberite tip igre:    \n");
//	
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frame3 window = new Frame3();
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
//	public Frame3() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 430, 270);
//		contentPane = new JPanel();
//		contentPane.setBorder(new LineBorder(new Color(51, 102, 255), 2));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblUnesite = new JLabel("Unesite 1, 2 ili 3");
//		lblUnesite.setFont(new Font("Waree", Font.BOLD, 14));
//		lblUnesite.setBounds(22, 138, 528, 35);
//		contentPane.add(lblUnesite);
//		
//		JLabel lblRacunarProtiv = new JLabel("3) racunar protiv racunara\n");
//		lblRacunarProtiv.setFont(new Font("Waree", Font.BOLD, 14));
//		lblRacunarProtiv.setBounds(49, 118, 528, 35);
//		contentPane.add(lblRacunarProtiv);
//		
//		JLabel lblIgracProtiv_1 = new JLabel("2) igrac protiv racunara");
//		lblIgracProtiv_1.setFont(new Font("Waree", Font.BOLD, 14));
//		lblIgracProtiv_1.setBounds(49, 98, 528, 35);
//		contentPane.add(lblIgracProtiv_1);
//		
//		JLabel lblIgracProtiv = new JLabel("1) igrac protiv igraca");
//		lblIgracProtiv.setFont(new Font("Waree", Font.BOLD, 14));
//		lblIgracProtiv.setBounds(49, 79, 528, 35);
//		contentPane.add(lblIgracProtiv);
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
//		lblNewLabel.setBounds(240, 145, 264, 96);
//		Image img=new ImageIcon(this.getClass().getResource("/nim.gif")).getImage();
//		lblNewLabel_1.setFont(new Font("Waree", Font.BOLD, 14));
//		lblNewLabel_1.setBounds(22, 59, 528, 35);
//		contentPane.add(lblNewLabel_1);
//		
//		textField = new JTextField();
//		textField.setBounds(22, 170, 140, 30);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		lblNewLabel.setIcon(new ImageIcon(img));
//		contentPane.add(lblNewLabel);
//		Image img1=new ImageIcon(this.getClass().getResource("/4.png")).getImage();
//		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setForeground(new Color(0, 153, 204));
//		lblNewLabel_2.setBounds(0, -16, 438, 304);
//		Image img2=new ImageIcon(this.getClass().getResource("/a4.jpg")).getImage();
//		lblNewLabel_2.setIcon(new ImageIcon(img2));
//		contentPane.add(lblNewLabel_2);
//		
//	
//		
//		
//	    
//	
//	}
//}
