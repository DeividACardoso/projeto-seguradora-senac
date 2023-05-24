package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TelaCadastroCliente {

	private JFrame frmCadstroClientes;
	private JTextField txtNome;
	private JTextField textField;
	private JTextField txtDtNascimento;
	private JTextField txtTelefone;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmCadstroClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadstroClientes = new JFrame();
		frmCadstroClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroCliente.class.getResource("/icones/icons8-adicionar-usu\u00E1rio-masculino-64.png")));
		frmCadstroClientes.setTitle("Cadastro Clientes");
		frmCadstroClientes.getContentPane().setBackground(new Color(26, 158, 230));
		frmCadstroClientes.setBounds(100, 100, 607, 386);
		frmCadstroClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadstroClientes.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNome = new JLabel("NOME DO SEGURADO");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCadstroClientes.getContentPane().add(lblNome, "4, 4");
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCadstroClientes.getContentPane().add(lblEndereo, "14, 4");
		
		txtNome = new JTextField();
		frmCadstroClientes.getContentPane().add(txtNome, "4, 6, 8, 1, fill, default");
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		frmCadstroClientes.getContentPane().add(txtEndereco, "14, 6, 7, 1, fill, default");
		
		JLabel lblDocumentoCpf = new JLabel("DOCUMENTO CPF");
		lblDocumentoCpf.setForeground(Color.WHITE);
		lblDocumentoCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCadstroClientes.getContentPane().add(lblDocumentoCpf, "4, 8, left, default");
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCadstroClientes.getContentPane().add(lblTelefone, "14, 8");
		
		textField = new JTextField();
		textField.setColumns(10);
		frmCadstroClientes.getContentPane().add(textField, "4, 10, 8, 1, fill, default");
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		frmCadstroClientes.getContentPane().add(txtTelefone, "14, 10, 7, 1, fill, default");
		
		JLabel lblDataDeNascimento = new JLabel("DATA DE NASCIMENTO");
		lblDataDeNascimento.setForeground(Color.WHITE);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCadstroClientes.getContentPane().add(lblDataDeNascimento, "4, 12");
		
		txtDtNascimento = new JTextField();
		txtDtNascimento.setColumns(10);
		frmCadstroClientes.getContentPane().add(txtDtNascimento, "4, 14, 8, 1, fill, default");
		
		JMenuBar menuBar = new JMenuBar();
		frmCadstroClientes.setJMenuBar(menuBar);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/icones/icons8-adicionar-50.png")));
		menuBar.add(btnIncluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/icones/icons8-editar-48.png")));
		menuBar.add(btnEditar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/icones/icons8-salvar-50.png")));
		menuBar.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/icones/icons8-cancelar-48.png")));
		menuBar.add(btnCancelar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/icones/icons8-excluir-48.png")));
		menuBar.add(btnExcluir);
	}

}
