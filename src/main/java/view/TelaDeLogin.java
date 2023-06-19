package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeLogin {

	private JFrame frmTitle;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin window = new TelaDeLogin();
					window.frmTitle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaDeLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTitle = new JFrame();
		frmTitle.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDeLogin.class.getResource("/icones/icons8-seguran\u00E7a-verificada-64.png")));
		frmTitle.getContentPane().setBackground(new Color(26, 158, 230));
		frmTitle.setTitle("LDF CORRETORA DE SEGUROS");
		frmTitle.setBounds(100, 100, 772, 450);
		frmTitle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTitle.getContentPane().setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(192, 192, 192));
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsuario.setBounds(264, 142, 199, 31);
		frmTitle.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setForeground(new Color(192, 192, 192));
		txtSenha.setBackground(new Color(255, 255, 255));
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSenha.setBounds(264, 245, 199, 31);
		frmTitle.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnAcesso = new JButton("");
		btnAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
//				Menu menu = new Menu();
//				frmMenu.setContentPane(menu);
//				frmMenu.revalidate();
			
			
			}
		});
		btnAcesso.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/icones/icons8-login-arredondado-\u00E0-direita-64 (2).png")));
		btnAcesso.setBounds(337, 303, 63, 60);
		frmTitle.getContentPane().add(btnAcesso);
		
		JLabel lblUsuarioIcone = new JLabel("New label");
		lblUsuarioIcone.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/icones/icons8-usu\u00E1rio-de-g\u00EAnero-neutro-64.png")));
		lblUsuarioIcone.setBounds(337, 80, 57, 51);
		frmTitle.getContentPane().add(lblUsuarioIcone);
		
		JLabel lblSenhaIcone = new JLabel("");
		lblSenhaIcone.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/icones/icons8-senha-48.png")));
		lblSenhaIcone.setBounds(346, 184, 48, 50);
		frmTitle.getContentPane().add(lblSenhaIcone);
	}
}
