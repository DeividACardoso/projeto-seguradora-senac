package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

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
		frmMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/icones/icons8-cardápio-64.png")));
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 656, 569);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBackground(new Color(26, 158, 230));
		frmMenu.setJMenuBar(menuBar);
		
		JMenu mnConsultarE = new JMenu("Consultar");
		mnConsultarE.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-análise-de-crescimento-financeiro-64.png")));
		menuBar.add(mnConsultarE);
		
		JMenu mnCadastro = new JMenu("Cadastrar");
		mnCadastro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-adicionar-64.png")));
		menuBar.add(mnCadastro);
		
		JMenu mnRelatorios = new JMenu("Relatórios");
		mnRelatorios.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-partilhar-2-64 (1).png")));
		menuBar.add(mnRelatorios);
		
		JMenu mnSinistro = new JMenu("Sinistro");
		mnSinistro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-alerta-64 (1).png")));
		menuBar.add(mnSinistro);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-sobre-64.png")));
		menuBar.add(mnSobre);
		frmMenu.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));
	}

}
