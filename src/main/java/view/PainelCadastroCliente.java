package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.PessoaController;
import model.exception.CampoInvalidoException;
import model.vo.Pessoa;

public class PainelCadastroCliente extends JPanel {
	private Pessoa cliente;
	private JTextField txtNome;
	private JTextField txtDtnascimento;
	private JTextField txtEndereco;
	private MaskFormatter mascaraCpf;
	private JFormattedTextField txtCPF;
	private JButton btnSalvar;
	
	private MaskFormatter mascaraTelefone;
	private JFormattedTextField txtTelefone;

	/**
	 * Create the panel.
	 */
	public PainelCadastroCliente() {
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(36dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(105dlu;default)"),
				ColumnSpec.decode("max(68dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(32dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(54dlu;default)"),}));
		
		JLabel lblTitulo = new JLabel("Novo Cliente");
		lblTitulo.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icones/icons8-adicionar-64.png")));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		add(lblTitulo, "3, 1, 3, 1, center, default");
		
		JLabel lblNomeSegurado = new JLabel("Nome segurado:");
		lblNomeSegurado.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNomeSegurado.setForeground(new Color(255, 255, 255));
		add(lblNomeSegurado, "2, 5, right, default");
		
		txtNome = new JTextField();
		add(txtNome, "3, 5, 3, 1, fill, default");
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCpf, "2, 11, right, default");
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValueContainsLiteralCharacters(false);
		} catch (ParseException erro) {
			//silent
		}
		
		txtCPF = new JFormattedTextField(mascaraCpf);
		add(txtCPF, "3, 11, 3, 1, fill, default");
		
		JLabel lblDatadeNascimento = new JLabel("Data de Nascimento:");
		lblDatadeNascimento.setForeground(Color.WHITE);
		lblDatadeNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblDatadeNascimento, "2, 17, left, default");
		
		txtDtnascimento = new JTextField();
		txtDtnascimento.setColumns(10);
		add(txtDtnascimento, "3, 17, fill, default");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblTelefone, "4, 17, right, center");
		
		txtTelefone = new JFormattedTextField();
		add(txtTelefone, "5, 17, fill, default");
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblEndereco, "2, 23, right, default");
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		add(txtEndereco, "3, 23, 3, 1, fill, default");
		

		try {
			mascaraTelefone = new MaskFormatter("(##)9####-####");
			mascaraTelefone.setValueContainsLiteralCharacters(false);
		} catch (ParseException e2) {
			//silent
			e2.printStackTrace();
		}
		mascaraTelefone.setValueContainsLiteralCharacters(false);
		
		txtTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefone.setVisible(true);
			}
		});
		
		
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtTelefone.setForeground(Color.BLUE);
		txtTelefone.setBounds(90, 60, 270, 20);
		txtTelefone.setVisible(false);
		
		
		
		
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaController controller = new PessoaController();
				
				if(cliente == null) {
					cliente = new Pessoa();
				}
				
				if(cliente.getId() == null) {
					try {
						controller.inserir(cliente);
						JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!", 
								"Sucesso", JOptionPane.INFORMATION_MESSAGE);
					} catch (CampoInvalidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), 
								"Atenção", JOptionPane.ERROR_MESSAGE);
					}
				}		
			}
		});
		
		btnSalvar.setBackground(new Color(231, 200, 24));
		btnSalvar.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icones/icons8-salvar-50.png")));
		add(btnSalvar, "3, 28");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
			}
		});
		
		btnVoltar.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icones/icons8-voltar-50.png")));
		btnVoltar.setBackground(new Color(231, 200, 24));
		add(btnVoltar, "5, 28");

	}
	
}