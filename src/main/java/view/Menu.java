package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.privatejgoodies.forms.layout.ColumnSpec;
import com.privatejgoodies.forms.layout.FormLayout;
import com.privatejgoodies.forms.layout.RowSpec;
import javax.swing.JMenuItem;
import java.awt.Font;



public class Menu {

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.getContentPane().setBackground(new Color(26, 156, 238));
		frmMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/icones/icons8-card�pio-64.png")));
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 511, 569);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBackground(new Color(26, 158, 230));
		frmMenu.setJMenuBar(menuBar);
		
		JMenu mnItemCliente = new JMenu("Cliente");
		mnItemCliente.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-cliente-64 (3).png")));
		menuBar.add(mnItemCliente);
		
		JMenuItem mnItemConsultaCliente = new JMenuItem("Consultar");
		mnItemConsultaCliente.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-an\u00E1lise-de-crescimento-financeiro-64.png")));
		mnItemCliente.add(mnItemConsultaCliente);
		
		JMenuItem mnItemCadastroCliente = new JMenuItem("Cadastro");
		mnItemCadastroCliente.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-adicionar-usu\u00E1rio-masculino-64.png")));
		mnItemCliente.add(mnItemCadastroCliente);
		
		JMenu mnSinistro = new JMenu("Seguros");
		mnSinistro.setBackground(new Color(26, 158, 230));
		mnSinistro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-alerta-64 (1).png")));
		menuBar.add(mnSinistro);
		
		JMenuItem mnItemConsultaSeguro = new JMenuItem("Consulta");
		mnItemConsultaSeguro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-an\u00E1lise-de-crescimento-financeiro-64.png")));
		mnSinistro.add(mnItemConsultaSeguro);
		
		JMenuItem mnItemCadastroSeguro = new JMenuItem("Cadastro");
		mnItemCadastroSeguro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-carro-64 (1).png")));
		mnSinistro.add(mnItemCadastroSeguro);
		
		JMenuItem mnItemSinistor = new JMenuItem("Sinistro");
		mnItemSinistor.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-servi\u00E7o-de-carro-64.png")));
		mnSinistro.add(mnItemSinistor);
		
		JMenu mnRelatorios = new JMenu("Relat�rios");
		mnRelatorios.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-partilhar-2-64 (1).png")));
		menuBar.add(mnRelatorios);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-sobre-64.png")));
		menuBar.add(mnSobre);
		frmMenu.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));
	}

}