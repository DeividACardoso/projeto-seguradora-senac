package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.privatejgoodies.forms.layout.ColumnSpec;
import com.privatejgoodies.forms.layout.FormLayout;
import com.privatejgoodies.forms.layout.RowSpec;

public class Menu {

	private JFrame frmMenu;
	private PainelCadastroCliente painelCadastroCliente;
	private PainelConsultaCliente painelConsultaCliente;
	private PainelConsultaSeguro painelConsultaSeguroAlterado;
	private PainelCadastroSeguro painelCadastroSeguro;
	private PainelConsultaSinistro painelConsultaSinistro;
	private PainelCadastroSinistro painelCadastroSinistro;
	protected PainelConsultaSeguro painelConsultaSeguro;
	private JMenuItem mnItemCadastroCliente;
	private JMenuItem mnItemConsultarCliente;
	private JMenu mnItemCliente;

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
		frmMenu.setIconImage(

				Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/icones/icons8-card\u00E1pio-64.png")));
		// Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/icones/icons8-cardápio-64.png")));
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 631, 569);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBackground(new Color(26, 158, 230));
		frmMenu.setJMenuBar(menuBar);
		
		
		// PARTE DE CLIENTE DO MENU//////////////////////////////////////////////////////////////////////////////////////////////
		mnItemCliente = new JMenu("Cliente");
		mnItemCliente.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-cliente-64 (3).png")));
		menuBar.add(mnItemCliente);
				
				//CADASTRAR
				mnItemCadastroCliente = new JMenuItem("Cadastro");
				mnItemCadastroCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						painelCadastroCliente = new PainelCadastroCliente();
						registrarCliqueBotaoVoltarDoPainelCadastroPessoa();
						// ATUALIZA TELA PRINCIPAL
						frmMenu.setContentPane(painelCadastroCliente);
						frmMenu.revalidate();
					}
				});						
				mnItemCadastroCliente.setIcon(
						new ImageIcon(Menu.class.getResource("/icones/icons8-adicionar-usu\u00E1rio-masculino-64.png")));
				mnItemCliente.add(mnItemCadastroCliente);

				//CONSULTAR
				mnItemConsultarCliente = new JMenuItem("Consultar");
				mnItemConsultarCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						painelConsultaCliente = new PainelConsultaCliente();
						registrarCliqueBotaoEditarDoPainelConsultaCliente();
						// ATUALIZA TELA PRINCIPAL
						frmMenu.setContentPane(painelConsultaCliente);
						frmMenu.revalidate();
					}
				});	
				mnItemConsultarCliente.setIcon(
						new ImageIcon(Menu.class.getResource("/icones/icons8-an\u00E1lise-de-crescimento-financeiro-64.png")));
				mnItemCliente.add(mnItemConsultarCliente);



		// PARTE DE SEGURO DO MENU//////////////////////////////////////////////////////////////////////////////////////////////
		JMenu mnSeguros = new JMenu("Seguros");
		mnSeguros.setBackground(new Color(26, 158, 230));
		mnSeguros.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-alerta-64 (1).png")));
		menuBar.add(mnSeguros);

		JMenuItem mnItemConsultaSeguro = new JMenuItem("Consulta");
		mnItemConsultaSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelConsultaSeguro = new PainelConsultaSeguro();
				painelConsultaSeguro.setVisible(true);
				registrarCliqueBotaoEditarDoPainelConsultaSeguro();
				painelConsultaSeguro.getBtnEditar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PainelCadastroSeguro telaEdicaoSeguro = new PainelCadastroSeguro(
								painelConsultaSeguro.getSeguroSelecionado());
					}
				});
				frmMenu.setContentPane(painelConsultaSeguro);
				frmMenu.revalidate();
			}

		});
		mnItemConsultaSeguro.setIcon(
				new ImageIcon(Menu.class.getResource("/icones/icons8-an\u00E1lise-de-crescimento-financeiro-64.png")));
		mnSeguros.add(mnItemConsultaSeguro);

		JMenuItem mnItemCadastroSeguro = new JMenuItem("Cadastro");
		mnItemCadastroSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroSeguro = new PainelCadastroSeguro(null);
				painelCadastroSeguro.setVisible(true);
				registrarCliqueBotaoVoltarDoPainelCadastroSeguro();
				// Atualiza a tela principal
				frmMenu.setContentPane(painelCadastroSeguro);
				frmMenu.revalidate();
			}

		});

		mnItemCadastroSeguro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-carro-64 (1).png")));
		mnSeguros.add(mnItemCadastroSeguro);

		// PARTE DE SINISTRO DO MENU////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JMenu mnSinistro = new JMenu("Sinistro");
		mnSinistro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-servi\u00E7o-de-carro-64.png")));
		menuBar.add(mnSinistro);

		JMenuItem mnItemCadastroSinistro = new JMenuItem("Cadastrar");
		mnItemCadastroSinistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroSinistro = new PainelCadastroSinistro(null);
				painelCadastroSinistro.setVisible(true);
				registrarCliqueBotaoVoltarDoPainelCadastroSinistro();
				frmMenu.setContentPane(painelCadastroSinistro);
				frmMenu.revalidate();
			}
		});
		mnItemCadastroSinistro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-adicionar-64.png")));
		mnSinistro.add(mnItemCadastroSinistro);

		JMenuItem mnItemConsultarSinistro = new JMenuItem("Consultar");
		mnItemConsultarSinistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelConsultaSinistro = new PainelConsultaSinistro();
				painelConsultaSinistro.setVisible(true);
				registrarCliqueBotaoEditarDoPainelConsultaSinistro();
				frmMenu.setContentPane(painelConsultaSinistro);
				frmMenu.revalidate();
			}
		});


		mnItemConsultarSinistro.setIcon(
		new ImageIcon(Menu.class.getResource("/icones/icons8-análise-de-crescimento-financeiro-64.png")));

		new ImageIcon(Menu.class.getResource("/icones/icons8-análise-de-crescimento-financeiro-64.png"));

		mnItemConsultarSinistro.setIcon(
				new ImageIcon(Menu.class.getResource("/icones/icons8-análise-de-crescimento-financeiro-64.png")));
		mnSinistro.add(mnItemConsultarSinistro);

				
		//SOBRE
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				JOptionPane.showMessageDialog(null, "LDF Corretora de Seguros");
			}
		});
		mnSobre.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-sobre-64.png")));
		menuBar.add(mnSobre);
		frmMenu.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {}, new RowSpec[] {}));
	}
	
//////////////////////////////////METODOS DO PAINEL PESSOA///////////////////////////////////////////////////////////////////////////
	

	
	protected void registrarCliqueBotaoVoltarDoPainelCadastroPessoa() {
		if (painelConsultaCliente == null) {
			painelConsultaCliente = new PainelConsultaCliente();
		}
		painelCadastroCliente.getbtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// CLIQUE DO BOTÃO VOLTAR
				// ABRE PAINEL CONSULTA
				painelConsultaCliente = new PainelConsultaCliente();
				painelConsultaCliente.setVisible(true);
				registrarCliqueBotaoEditarDoPainelConsultaCliente();				
				frmMenu.setContentPane(painelConsultaCliente);
				frmMenu.revalidate();
			}

		});
	}
	
	
	protected void registrarCliqueBotaoEditarDoPainelConsultaCliente() {
		painelConsultaCliente.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelConsultaCliente = new PainelConsultaCliente();//painelConsultaCliente.getPessoaSelecionada()
				painelConsultaCliente.setVisible(true);
				registrarCliqueBotaoEditarDoPainelConsultaCliente();
				frmMenu.setContentPane(painelConsultaCliente);
				frmMenu.revalidate();
			}
		});
	}
	

	//////////////////////////////////METODOS DO PAINEL SINISTRO///////////////////////////////////////////////////////////////////////////
	protected void registrarCliqueBotaoVoltarDoPainelCadastroSinistro() {
		if (painelCadastroSinistro == null) {
			painelCadastroSinistro = new PainelCadastroSinistro(null);
		}
		painelCadastroSinistro.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painelConsultaSinistro = new PainelConsultaSinistro();
				painelConsultaSinistro.setVisible(true);
				registrarCliqueBotaoEditarDoPainelConsultaSinistro();
				
				frmMenu.setContentPane(painelConsultaSinistro);
				frmMenu.revalidate();
			}

		});
	}
	protected void registrarCliqueBotaoEditarDoPainelConsultaSinistro() {
		painelConsultaSinistro.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroSinistro = new PainelCadastroSinistro(painelConsultaSinistro.getSinistroSelecionado());
				painelCadastroSinistro.setVisible(true);
				registrarCliqueBotaoVoltarDoPainelCadastroSinistro();
				
				frmMenu.setContentPane(painelCadastroSinistro);
				frmMenu.revalidate();
			}
		});

	}
	
	//////////////////////////////////METODOS DO PAINEL SEGURO///////////////////////////////////////////////////////////////////////////
	protected void registrarCliqueBotaoVoltarDoPainelCadastroSeguro() {
		if (painelCadastroSeguro == null) {
			painelCadastroSeguro = new PainelCadastroSeguro(null);
		}
		painelCadastroSeguro.getbtnVoltar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica do clique no botão Voltar
				// Mostra o painel de listagem de clientes
				painelConsultaSeguroAlterado = new PainelConsultaSeguro();
				painelConsultaSeguroAlterado.setVisible(true);
				registrarCliqueBotaoEditarDoPainelConsultaSeguro();
				frmMenu.setContentPane(painelConsultaSeguroAlterado);
				frmMenu.revalidate();
			}
		});
	}

	protected void registrarCliqueBotaoEditarDoPainelConsultaSeguro() {
		painelConsultaSeguro.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroSeguro = new PainelCadastroSeguro(painelConsultaSeguro.getSeguroSelecionado());
				painelCadastroSeguro.setVisible(true);
				registrarCliqueBotaoVoltarDoPainelCadastroSeguro();
				//Atualiza a tela principal
				frmMenu.setContentPane(painelCadastroSeguro);
				frmMenu.revalidate();
			}
		});
	}

}
